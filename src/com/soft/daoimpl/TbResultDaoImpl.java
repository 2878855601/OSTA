package com.soft.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.bean.TbResultBean;
import com.soft.bean.TbUserBean;
import com.soft.dao.IBaseDao;
import com.soft.util.DBUtil;

public class TbResultDaoImpl implements IBaseDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/**插入考生的答题信息*/
	@Override
	public boolean insertByBean(Object bean) {
		TbResultBean resultBean = (TbResultBean) bean;
		try {
			con = DBUtil.getConnection();
			String sql = "insert into tb_result values (?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, resultBean.getU_no());
			ps.setString(2, resultBean.getI_no());
			ps.setString(3, resultBean.getR_answer());
			ps.setString(4, resultBean.getR_score());
			int cunt = ps.executeUpdate();
			if(cunt > 0){
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
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 计算学生的得分
	 * @param uno	考生号
	 * @return	分数
	 */
	public int score(String uno){
		int  rscore = 0;
		try {
			con = DBUtil.getConnection();
			String sql = "select R_SCORE from tb_result where U_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, uno);
			rs = ps.executeQuery();
			while(rs.next()){
				int q = Integer.valueOf(rs.getString(1));
				rscore += q;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rscore;
	}
	
	public List<?> findAll(String uno){
		List<TbResultBean> beanList = new ArrayList<TbResultBean>();
		try {
			con = DBUtil.getConnection();
			String sql = "select * from tb_result where U_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, uno);
			rs = ps.executeQuery();
			while(rs.next()){
				TbResultBean bean = new TbResultBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				beanList.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beanList;
	}
	
	/**
	 * 查询考生是否答过某题
	 * @param uno	考生号
	 * @param ino	考题号
	 * @return	返回真假
	 */
	public boolean finAll(String uno,String ino){
		try {
			con = DBUtil.getConnection();
			String sql = "select * from tb_result where u_no = ? and i_no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, uno);
			ps.setString(2, ino);
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.realease(rs, ps, con);
		}
		return false;
	}
	
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 清空考生成绩表
	 * @return	返回真假
	 */
	public boolean delete(){
		try {
			con = DBUtil.getConnection();
			String sql = "delete from tb_result";
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

	/**修改考生答题信息*/
	@Override
	public boolean updateByBean(Object bean) {
		TbResultBean resultBean = (TbResultBean) bean;
		try {
			con = DBUtil.getConnection();
			String sql = "update tb_result set r_answer = ? , r_score = ? where i_no = ? and u_no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, resultBean.getR_answer());
			ps.setString(2, resultBean.getR_score());
			ps.setString(3, resultBean.getI_no());
			ps.setString(4, resultBean.getU_no());
			int cunt = ps.executeUpdate();
			if(cunt > 0){
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
	 * 直接修改某个考生的成绩
	 * @param score	考生成绩
	 * @param uno	考生准考号
	 */
	public void updateByScore(String score,String uno){
		try {
			con = DBUtil.getConnection();
			String sql = "update tb_result set r_score = ? where u_no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, score);
			ps.setString(2, uno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.realease(null, ps, con);
		}
	}
	
}
