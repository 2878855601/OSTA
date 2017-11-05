package com.soft.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.bean.TbUserBean;
import com.soft.dao.IBaseDao;
import com.soft.util.DBUtil;

public class TbUserDaoImpl implements IBaseDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public boolean insertByBean(Object bean) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 将考生信息导入数据库
	 * @param uerList	考生信息集合
	 * @return	返回真假
	 */
	public boolean insertByBean(List<String> uerList){
		try {
			con = DBUtil.getConnection();
			String sql = "insert into tb_user values (?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, uerList.get(0));
			ps.setString(2, uerList.get(1));
			ps.setString(3, uerList.get(2));
			ps.setString(4, "等待登录");
			ps.setInt(5, 0);
			int count = ps.executeUpdate();
			if(count > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.realease(null, ps, con);
		}
		return false;
	}
	/**查询所有的考生信息，并返回一个集合*/
	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		List<TbUserBean> userList = new ArrayList<TbUserBean>();
		try {
			con = DBUtil.getConnection();
			String sql = "select * from tb_user order by u_no";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				do{
					TbUserBean userBean = new TbUserBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
					userList.add(userBean);
				}while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.realease(rs, ps, con);
		}
		return userList;
	}
	/**
	 * 查询考生登录
	 * @param uno	考生号
	 * @param uid	考生身份证
	 * @param uname	考生名字
	 * @return	成功true失败false
	 */
	public boolean findAll(String uno,String uid,String uname){
		try {
			con = DBUtil.getConnection();
			String sql = "select * from tb_user where u_no = ? and u_id = ? and u_name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, uno);
			ps.setString(2, uid);
			ps.setString(3, uname);
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询单个考生的信息
	 * @param uno	考生号
	 * @return	考生信息
	 */
	public TbUserBean user(String uno){
		TbUserBean userBean = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from tb_user where u_no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, uno);
			rs = ps.executeQuery();
			while(rs.next()){
				userBean = new TbUserBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userBean;
	}
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 清空考生表
	 * @return	返回真假
	 */
	public boolean delete(){
		try {
			con = DBUtil.getConnection();
			String sql = "delete from tb_user";
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if(count > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.realease(null, ps, con);
		}
		return false;
	}
	/**
	 * 修改学生状态
	 * @param uno	学生号
	 * @param ustate	学生状态
	 * @return
	 */
	public boolean updateByBean(String uno,String ustate){
		try {
			con = DBUtil.getConnection();
			String sql = "update tb_user set u_static = ? where u_no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ustate);
			ps.setString(2, uno);
			int count = ps.executeUpdate();
			if(count > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.realease(null, ps, con);
		}
		return false;
	}
	/**
	 * 记录学生的总成绩
	 * @param uno 学生号
	 * @param total_points	成绩
	 * @return
	 */
	public boolean updateByBean(String uno,int total_points){
		try {
			con = DBUtil.getConnection();
			String sql = "update tb_user set u_total_points = ? where u_no = ?";
			System.out.println(sql);
			ps = con.prepareStatement(sql);
			ps.setInt(1, total_points);
			ps.setString(2, uno);
			int count = ps.executeUpdate();
			if(count > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.realease(null, ps, con);
		}
		return false;
	}
	@Override
	public boolean updateByBean(Object bean) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
