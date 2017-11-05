package com.soft.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.soft.bean.ExamMessageBean;
import com.soft.bean.ItemBankBean;
import com.soft.bean.TbItemBankBean;
import com.soft.bean.TbPaperBean;
import com.soft.bean.TbResultBean;
import com.soft.bean.TbUserBean;
import com.soft.bean.UserMessageBean;
import com.soft.daofactor.DaoFactory;
import com.soft.daoimpl.TbItemBankDaoImpl;
import com.soft.daoimpl.TbPaperDaoImpl;
import com.soft.daoimpl.TbResultDaoImpl;
import com.soft.daoimpl.TbUserDaoImpl;
import com.soft.util.Download;
import com.soft.util.ReadFileUtil;
import com.soft.util.ZipFileUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AdminManageServert
 */
@WebServlet("/AdminManageServert")
public class AdminManageServert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 上传文件存储目录
	private static final String UPLOAD_DIRECTORY = "upload";

	// 上传配置
	private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
	private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	private PrintWriter out;
	private String filePath = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminManageServert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		TbResultDaoImpl resultDaoImpl = (TbResultDaoImpl) DaoFactory.getInsrance("com.soft.daoimpl.TbResultDaoImpl");
		TbUserDaoImpl userDaoImpl = (TbUserDaoImpl) DaoFactory.getInsrance("com.soft.daoimpl.TbUserDaoImpl");
		TbItemBankDaoImpl itemBankDaoImpl = (TbItemBankDaoImpl) DaoFactory.getInsrance("com.soft.daoimpl.TbItemBankDaoImpl");
		TbPaperDaoImpl paperDaoImpl = (TbPaperDaoImpl) DaoFactory.getInsrance("com.soft.daoimpl.TbPaperDaoImpl");
		if(action != null && !action.equals("")){
			if(action.equals("toLead")){
				String pwd = request.getParameter("pwd");
				out  = response.getWriter();
				//检测是否为多媒体上传
				if(!ServletFileUpload.isMultipartContent(request)){
					out .println("失败");
					out .flush();
					out .close();
				}
				//配置对应的上传参数
				DiskFileItemFactory factory = new DiskFileItemFactory();
				//设置内存最大值，超过不直接放内存内
				factory.setSizeThreshold(MEMORY_THRESHOLD);
				//超过内存最大值直接在项目根目录下生成临时文件的存储目录
				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
				//
				ServletFileUpload upload = new ServletFileUpload(factory);
				//设置最大文件上传值
				upload.setFileSizeMax(MAX_FILE_SIZE);
				//最大请求支值
				upload.setFileSizeMax(MAX_REQUEST_SIZE);
				//设置中文
				upload.setHeaderEncoding("UTF-8");
				//构造临时存放路径
				String path = request.getServletContext().getRealPath("/WEB-INF/") + File.separator + UPLOAD_DIRECTORY;
				//当目录不存在时自动创建
				File dir = new File(path);
				if(!dir.exists()){
					dir.mkdir();
				}

				try {
					@SuppressWarnings("unchecked")
					List<FileItem>  fileItem = upload.parseRequest(request);
					if(fileItem != null && fileItem.size() > 0){
						for (FileItem intem : fileItem) {
							if(!intem.isFormField()){
								//获取路径
								String fileName = new File(intem.getName()).getName();
								filePath  = path + File.separator + fileName;
								//生成文件
								File store = new File(filePath );
								//保存文件
								intem.write(store);
								ZipFileUtil.zipFile(filePath, path + File.separator, pwd);
								String way = path + File.separator;
								//考生表的路径
								String user  = way + "\\exam\\UserInfo.xls";
								//考题表的路径
								String paper = way + "\\exam\\PaperInfo.xls";
								//清空考生成绩表
								boolean res = resultDaoImpl.delete();
								//清空考生表
								boolean use = userDaoImpl.delete();
								//清空试题表
								boolean ttem = itemBankDaoImpl.delete();
								//清空试卷表
								boolean pap	= paperDaoImpl.delete();
								
								//向数据库写入考生的信息
								List<List<String>> list = ReadFileUtil.readFileUtil(user);
								for(int j = 1; j < list.size(); j++){
									if(list.get(j).size() != 0){
										List<String> userList = list.get(j);
										boolean cunt = userDaoImpl.insertByBean(userList);
										if(cunt){
											System.out.println("考生表插入成功");
										}else{
											System.out.println("考生表插入失败");
										}
									}
								}

								//向试卷表和试题表写入数据
								List<List<String>> paperList = ReadFileUtil.readFileUtil(paper);
								for(int j = 1; j < paperList.size(); j++){
									if(paperList.get(j).size() != 0){
										String p_no = paperList.get(1).get(0);
										//向试卷表写入数据
										if(j < 2){
											List<String> papList = paperList.get(j);
											boolean cunt = paperDaoImpl.insertByBean(papList);
											if(cunt){
												System.out.println("试卷表插入成功");
											}else{
												System.out.println("试卷表插入失败");
											}
										}
										//向试题表写入数据
										if(j > 2){
											List<String> papeList = paperList.get(j);
											boolean cuntn = itemBankDaoImpl.insertByBean(papeList, p_no);
											if(cuntn){
												System.out.println("试题表插入成功");
											}else{
												System.out.println("试题表插入失败");
											}
										}
									}
								}
							}
							
							//返回数据到界面
							List<TbUserBean> userBean = (List<TbUserBean>) userDaoImpl.findAll();
							TbPaperBean paperBean = paperDaoImpl.sel();
							ExamMessageBean examMessage = new ExamMessageBean(userBean.size(), paperBean);
							JSONObject papbean = JSONObject.fromObject(examMessage);
							out.println(papbean);
							out.flush();
							out.close();
							return;
						}
					}
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//考生信息预览
			}else if(action.equals("user")){
				List<TbUserBean> userBean = (List<TbUserBean>) userDaoImpl.findAll();
				TbPaperBean paperBean = paperDaoImpl.sel();
				UserMessageBean userMessage = new UserMessageBean(paperBean, userBean);
				JSONObject userMessageBean = JSONObject.fromObject(userMessage);
				out  = response.getWriter();
				out.print(userMessageBean);
				out.flush();
				out.close();
				return;
			}else if(action.equals("paper")){
				String uno = request.getParameter("userno");
				boolean trn = userDaoImpl.updateByBean(uno, "考试中");
				List<TbItemBankBean> singleChoiceList = (List<TbItemBankBean>) itemBankDaoImpl.SingleChoice("单选题");
				List<TbItemBankBean> multipChoiceList = (List<TbItemBankBean>) itemBankDaoImpl.SingleChoice("多选题");
				TbPaperBean paperBean = paperDaoImpl.sel();
				List<TbResultBean> resBean = (List<TbResultBean>) resultDaoImpl.findAll(uno);
				ItemBankBean itemBank = new ItemBankBean(singleChoiceList, multipChoiceList, paperBean,resBean);
				JSONObject itemBankBean = JSONObject.fromObject(itemBank);
				out  = response.getWriter();
				out.print(itemBankBean);
				out.flush();
				out.close();
			}else if(action.equals("ok")){
				request.getRequestDispatcher("Invigilate.jsp").forward(request, response);
				/***********************导出成绩*********************/
			}else if(action.equals("downFile")){
				String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
				System.out.println(path);
				String updataPath = request.getServletContext().getRealPath("") + File.separator;
				System.out.println(updataPath);
				String url = updataPath + "Download" + "\\"; 
				String uekBane = "StudentTotalPoints.xls";
				String urls = url+uekBane;
				String baseUrl = path + "Download" + "/" + "StudentTotalPoints.xls";
				
				File downFile = new File(url);	
				if(!downFile.exists()){
					downFile.mkdirs();
				}
				try {
					Download.export(urls);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out  = response.getWriter();
				out.print(baseUrl);
				out.flush();
				out.close();
			}
			
			
		}
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
