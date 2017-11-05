package com.soft.bean;
/**
 * 考生表Bean类
 * @author JX170504
 *
 */
public class TbUserBean {
	/**考生号*/
	private String u_no;
	/**考生姓名*/
	private String u_name;
	/**考生身份证号码*/
	private String u_id;
	/**考生当前状态*/
	private String u_static;
	/**考生总成绩*/
	private int u_total_points;
	
	
	public TbUserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TbUserBean(String u_no, String u_name, String u_id, String u_static, int u_total_points) {
		super();
		this.u_no = u_no;
		this.u_name = u_name;
		this.u_id = u_id;
		this.u_static = u_static;
		this.u_total_points = u_total_points;
	}
	public int getU_total_points() {
		return u_total_points;
	}
	public void setU_total_points(int u_total_points) {
		this.u_total_points = u_total_points;
	}
	public String getU_no() {
		return u_no;
	}
	public void setU_no(String u_no) {
		this.u_no = u_no;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_static() {
		return u_static;
	}
	public void setU_static(String u_static) {
		this.u_static = u_static;
	}
	
	
}
