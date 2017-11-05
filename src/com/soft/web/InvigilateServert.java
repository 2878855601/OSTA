package com.soft.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.bean.TbPaperBean;
import com.soft.bean.TbUserBean;
import com.soft.bean.UserMessageBean;
import com.soft.daofactor.DaoFactory;
import com.soft.daoimpl.TbItemBankDaoImpl;
import com.soft.daoimpl.TbPaperDaoImpl;
import com.soft.daoimpl.TbResultDaoImpl;
import com.soft.daoimpl.TbUserDaoImpl;
import com.soft.util.ThreadTimer;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class InvigilateServert
 */
public class InvigilateServert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InvigilateServert() {
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
		ThreadTimer thread = new ThreadTimer();
		out = response.getWriter();
		if(null != action && !action.equals("")){
			if(action.equals("userMessage")){
				TbPaperBean bean =  paperDaoImpl.sel();
				List<TbUserBean> tbUserBean = (List<TbUserBean>) userDaoImpl.findAll();
				UserMessageBean userMessage = new UserMessageBean(bean, tbUserBean);
				JSONObject userJosn = JSONObject.fromObject(userMessage);
				out.print(userJosn);
				out.flush();
				out.close();
			}else if(action.equals("state")){
				TbPaperBean bean =  paperDaoImpl.sel();
				List<TbUserBean> tbUserBean = (List<TbUserBean>) userDaoImpl.findAll();
				UserMessageBean userMessage = new UserMessageBean(bean, tbUserBean);
				JSONObject userJosn = JSONObject.fromObject(userMessage);
				out.print(userJosn);
				out.flush();
				out.close();
			}else if(action.equals("del")){
				String state = request.getParameter("uno");
				boolean cunt = userDaoImpl.updateByBean(state, "作弊");
				userDaoImpl.updateByBean(state, "作弊");
				if(cunt){
					out.print("1");
				}else{
					out.print("2");
				}
				out.flush();
				out.close();
			}else if(action.equals("weiji")){
				String state = request.getParameter("uno");
				boolean cunt = userDaoImpl.updateByBean(state, "违纪");
				if(cunt){
					out.print("1");
				}else{
					out.print("2");
				}
				out.flush();
				out.close();
			}else if(action.equals("qiangzhi")){
				String state = request.getParameter("uno");
				boolean cunt = userDaoImpl.updateByBean(state, "已交卷");
				if(cunt){
					out.print("1");
				}else{
					out.print("2");
				}
				out.flush();
				out.close();
			}else if(action.equals("begin")){
				thread.start();
			}else if(action.equals("stop")){
				ThreadTimer.times.stop();
				thread.interrupt();
				boolean cunt = paperDaoImpl.update("考试暂停");
			}else if(action.equals("go")){
				thread.start();
				boolean cunt = paperDaoImpl.update("考试中");
			}else if(action.equals("totalPoints")){
				TbPaperBean bean =  paperDaoImpl.sel();
				List<TbUserBean> tbUserBean = (List<TbUserBean>) userDaoImpl.findAll();
				for (TbUserBean tbUserBean2 : tbUserBean) {
					if(!tbUserBean2.getU_static().equals("作弊") && !tbUserBean2.getU_static().equals("违纪")){
						userDaoImpl.updateByBean(tbUserBean2.getU_no(), "已交卷");
					}
				}
				paperDaoImpl.update("考试结束");
				UserMessageBean userMessage = new UserMessageBean(bean, tbUserBean);
				JSONObject userJosn = JSONObject.fromObject(userMessage);
				out.print(userJosn);
				out.flush();
				out.close();
			}

		}
	}
	/**以时分秒的格式获取时间*/
	public String downTime(Long scend){
		String getTime = null;
		long hour = 0;//小时
		long minute = 0;//分钟
		long seconds = 0;//秒
		hour = scend / 3600;
		minute = (scend - hour * 3600) / 60;
		seconds = scend - hour * 3600 - minute * 60;
		if(minute<10 && seconds<10){
			getTime = "0"+hour+":0"+minute+":0"+seconds;
		}else if(minute>=10 && seconds<10){
			getTime = "0"+hour+":"+minute+":0"+seconds;
		}else if(minute<10 && seconds>=10){
			getTime = "0"+hour+":0"+minute+":"+seconds;
		}else if(minute>=10 && seconds>=10){
			getTime = "0"+hour+":"+minute+":"+seconds;
		}
		return getTime;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
