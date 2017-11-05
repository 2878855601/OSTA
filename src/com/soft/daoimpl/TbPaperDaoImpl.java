package com.soft.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.soft.bean.TbPaperBean;
import com.soft.dao.IBaseDao;
import com.soft.util.DBUtil;
/**
 * 试卷信息Bean类实现类
 * @author JX170504
 *
 */
public class TbPaperDaoImpl implements IBaseDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public boolean insertByBean(Object bean) {
		// TODO Auto-generated method stub
		return false;
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
	
	public boolean insertByBean(List<String> paperList){
		try {
			con = DBUtil.getConnection();
			String sql = "insert into tb_paper values (?,?,?,?,?,?,?,?,?,?,?,?	)";
			ps = con.prepareStatement(sql);
			String timrs = paperList.get(2).substring(0,3);
			long downTime = Long.parseLong(timrs)*60;
			String updTime = this.downTime(downTime);
			ps.setString(1, paperList.get(0));
			ps.setString(2, paperList.get(1));
			ps.setString(3, paperList.get(2));
			ps.setString(4, paperList.get(3));
			ps.setString(5, paperList.get(4));
			ps.setString(6, paperList.get(5));
			ps.setString(7, paperList.get(6));
			ps.setString(8, paperList.get(7));
			ps.setString(9, paperList.get(8));
			ps.setString(10, paperList.get(9));
			ps.setString(11, updTime);
			ps.setString(12, "等待考试");
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
	
	/**查询返回试卷表的信息*/
	public TbPaperBean sel(){
		TbPaperBean paperBean = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from tb_paper";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				paperBean = new TbPaperBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
							rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
							rs.getString(10),rs.getString(11),rs.getString(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.realease(null, ps, con);
		}
		return paperBean;
	}
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 清空试卷表
	 * @return 返回真假
	 */
	public boolean delete(){
		try {
			con = DBUtil.getConnection();
			String sql = "delete from tb_paper";
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
	
	@Override
	public boolean updateByBean(Object bean) {
		// TODO Auto-generated method stub
		return false;
	}
	/**开始考试*/
	public boolean update(String sountDown, String state){
		try {
			con = DBUtil.getConnection();
			String sql ="update tb_paper set P_COUNT_DOWN = ? , p_state = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, sountDown);
			ps.setString(2, state);
			int cuont = ps.executeUpdate();
			if(cuont > 0){
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
	 * 	修改考试状态
	 * @param state	考试状态
	 * @return
	 */
	public boolean update(String state){
		try {
			con = DBUtil.getConnection();
			String sql ="update tb_paper set p_state = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, state);
			int cuont = ps.executeUpdate();
			if(cuont > 0){
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
}
