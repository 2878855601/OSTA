package com.soft.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.bean.TbItemBankBean;
import com.soft.dao.IBaseDao;
import com.soft.util.DBUtil;
import com.sun.java.swing.plaf.windows.resources.windows;
/**
 * 试题信息Bean类实现类
 * @author JX170504 黄力超
 *
 */
public class TbItemBankDaoImpl implements IBaseDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public boolean insertByBean(Object bean) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insertByBean(List<String> itemBankList,String p_no){
		try {
			con = DBUtil.getConnection();
			String sql = "insert into tb_item_bank values (?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, itemBankList.get(1));
			ps.setString(2, itemBankList.get(0));
			ps.setString(3, itemBankList.get(2));
			ps.setString(4, itemBankList.get(3));
			ps.setString(5, itemBankList.get(4));
			ps.setString(6, itemBankList.get(5));
			ps.setString(7, itemBankList.get(6));
			ps.setString(8, itemBankList.get(7));
			ps.setString(9, itemBankList.get(8));
			ps.setString(10, p_no);
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
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String selAnswe(String ino,String answe){
		try {
			con = DBUtil.getConnection();
			String sql = "select i_score from tb_item_bank where i_no = ? and i_answer = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ino);
			ps.setString(2, answe);
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.realease(null, ps, con);
		}
		return "0";
	}
	
	/**查询试题中的单选题*/
	public List<?> SingleChoice(String type){
		List<TbItemBankBean> choiceList = new ArrayList<TbItemBankBean>();
		try {
			con = DBUtil.getConnection();
			String sql = "select * from tb_item_bank where i_type= ? order by i_no";
			ps = con.prepareStatement(sql);
			ps.setString(1, type);
			rs = ps.executeQuery();
			while(rs.next()){
				TbItemBankBean itemBankBean = new TbItemBankBean(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
				choiceList.add(itemBankBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.realease(null, ps, con);
		}
		return choiceList;
	}
	
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(){
		try {
			con = DBUtil.getConnection();
			String sql = "delete from tb_item_bank";
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			System.out.println("删除试题表" + count);
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
