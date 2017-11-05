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
import com.soft.bean.UserPaperBean;
import com.soft.daofactor.DaoFactory;
import com.soft.daoimpl.TbItemBankDaoImpl;
import com.soft.daoimpl.TbPaperDaoImpl;
import com.soft.daoimpl.TbResultDaoImpl;
import com.soft.daoimpl.TbUserDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserManageServert
 */

public class UserManageServert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManageServert() {
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
		PrintWriter out = response.getWriter();
		if(!action.equals("") && null != action){
			if(action.equals("downTime")){
				String uno = request.getParameter("uno");
				System.out.println(uno);
				TbPaperBean bean =  paperDaoImpl.sel();
				TbUserBean userBean = userDaoImpl.user(uno);
				UserPaperBean userPaper = new UserPaperBean(bean, userBean);
				JSONObject userPaperBean = JSONObject.fromObject(userPaper);
				out.print(userPaperBean);
				out.flush();
				out.close();
			}else if(action.equals("submit")){
				String uno = request.getParameter("uno").trim();
				int rscore = resultDaoImpl.score(uno);
				TbUserBean bean = userDaoImpl.user(uno);
				if(!bean.getU_static().equals("作弊") && !bean.getU_static().equals("违纪")){
					boolean coun = userDaoImpl.updateByBean(uno, "已交卷");
				}
				TbUserBean userBean = userDaoImpl.user(uno);
				TbPaperBean paperBean =  paperDaoImpl.sel();
				request.setAttribute("userBean", userBean);
				request.setAttribute("paperBean", paperBean);
				request.setAttribute("score", rscore);
				request.getRequestDispatcher("UserScore.jsp").forward(request, response);
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
