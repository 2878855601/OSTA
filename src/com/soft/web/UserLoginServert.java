package com.soft.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soft.bean.TbPaperBean;
import com.soft.bean.TbUserBean;
import com.soft.daofactor.DaoFactory;
import com.soft.daoimpl.TbItemBankDaoImpl;
import com.soft.daoimpl.TbPaperDaoImpl;
import com.soft.daoimpl.TbResultDaoImpl;
import com.soft.daoimpl.TbUserDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserLoginServert
 */

public class UserLoginServert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServert() {
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
		if(null != action && !action.equals("")){
			out  = response.getWriter();
			if(action.equals("load")){
				TbPaperBean bean = paperDaoImpl.sel();
				JSONObject jsonBean = JSONObject.fromObject(bean);
				out.print(jsonBean);
				out.flush();
				out.close();
			}else if(action.equals("login")){
				String uno = request.getParameter("uno");
				String uid = request.getParameter("uid");
				String uname = request.getParameter("uname");
				boolean result = userDaoImpl.findAll(uno, uid, uname);
				if(result){
					TbUserBean userBean = userDaoImpl.user(uno);
					if(userBean.getU_static().equals("等待登录")){
						boolean ren = userDaoImpl.updateByBean(uno, "等待考试");
					}
					TbPaperBean bean = paperDaoImpl.sel();
					HttpSession session = request.getSession();
					session.setAttribute("uno",uno);
					session.setAttribute("uid", uid);
					session.setAttribute("uname", uname);
					session.setAttribute("bean", bean);
					request.getRequestDispatcher("UserVerify.jsp").forward(request, response);
					return;
				}else{
					response.sendRedirect("UserLogin.jsp");
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
