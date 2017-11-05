package com.soft.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.bean.TbPaperBean;
import com.soft.bean.TbResultBean;
import com.soft.daofactor.DaoFactory;
import com.soft.daoimpl.TbItemBankDaoImpl;
import com.soft.daoimpl.TbPaperDaoImpl;
import com.soft.daoimpl.TbResultDaoImpl;
import com.soft.daoimpl.TbUserDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserVerifyServert
 */

public class UserVerifyServert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserVerifyServert() {
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
		if(null != action && !action.equals("")){
			if(action.equals("verify")){
				TbPaperBean bean = paperDaoImpl.sel();
				JSONObject jsonBean = JSONObject.fromObject(bean);
				out.print(jsonBean);
				out.flush();
				out.close();
			}else if(action.equals("answer")){
				String ino = request.getParameter("ino").trim();
				String answe = request.getParameter("answe").trim();
				String uno = request.getParameter("uno").trim();
				String score = itemBankDaoImpl.selAnswe(ino, answe);
				int scores = Integer.valueOf(score);
				int scor = resultDaoImpl.score(uno);
				int sum = scor+scores;
				boolean cut  = userDaoImpl.updateByBean(uno,sum);
				TbResultBean resultBean = new TbResultBean(uno, ino, answe, score);
				boolean sctue = resultDaoImpl.finAll(uno, ino);
				if(sctue){
					boolean scupd = resultDaoImpl.updateByBean(resultBean);
					if(scupd){
						out.print("1");
						out.flush();
						out.close();
					}
				}else{
					boolean scins = resultDaoImpl.insertByBean(resultBean);
					if(scins){
						out.print("1");
						out.flush();
						out.close();
					}
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
