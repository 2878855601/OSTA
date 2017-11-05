package com.soft.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soft.bean.TbPaperBean;
import com.soft.daofactor.DaoFactory;
import com.soft.daoimpl.TbPaperDaoImpl;

import java.util.Properties;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLoginServert")
public class AdminLoginServert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginServert() {
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
		//加载监考员登陆信息配置文件
		Properties pro = new Properties();
		pro.load(AdminLoginServert.class.getClassLoader().getResourceAsStream("adminLogin.properties"));
		//获取监考员账号
		String pno = pro.getProperty("pno");
		//获取监考员密码
		String ppwd = pro.getProperty("ppwd");

		PrintWriter out = response.getWriter();
		if(null != action && !action.equals("")){
			/**监考员登陆界面获取验证码*/
			if(action.equals("authCode")){
				String[] code = {"1","2","3","4","5","6","7","8","9","0","A","B","C","D","E","F","G","H","I","J","K","L",
						"M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
				String authCode = "";
				//随机产生四位验证码
				for(int i = 0; i < 4; i++){
					int num = new Random().nextInt(code.length);
					authCode = authCode + code[num];
				}
				out.print(authCode);
				out.flush();
				out.close();
				return;
				/**监考员端登陆*/
			}else if(action.equals("login")){
				String no = request.getParameter("pno");
				String pwd = request.getParameter("ppwd");
				if(no.equals(pno) && pwd.equals(ppwd)){
					TbPaperDaoImpl paperDaoImpl = (TbPaperDaoImpl) DaoFactory.getInsrance("com.soft.daoimpl.TbPaperDaoImpl");
					TbPaperBean paperBean = paperDaoImpl.sel();
					HttpSession session = request.getSession();
					session.setAttribute("pno", no);
					if( null == paperBean ||paperBean.getP_state().equals("考试结束")){
						request.getRequestDispatcher("AdminMian.jsp").forward(request, response);
					}else{
						request.getRequestDispatcher("Invigilate.jsp").forward(request, response);
					}
					return;
				}else{
					response.sendRedirect("AdminLogin.jsp");
					return;
				}
				/**验证监考员账号是否存在*/
			}else if(action.equals("pnoCode")){
				String no = request.getParameter("pno");
				if(no.equals(pno)){
					out.print("1");
					out.flush();
					out.close();
					return;
				}
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
