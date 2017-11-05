package com.soft.bean;
/**
 * 考生成绩Bean类
 * @author JX170504 黄力超
 *
 */
public class TbResultBean {
	/**考生号*/
	private String u_no;
	/**试题号*/
	private String i_no;
	/**选择的答案*/
	private String r_answer;
	/**考生考试时的状态*/
	private String r_score;
	public TbResultBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TbResultBean(String u_no, String i_no, String r_answer, String r_score) {
		super();
		this.u_no = u_no;
		this.i_no = i_no;
		this.r_answer = r_answer;
		this.r_score = r_score;
	}

	public String getU_no() {
		return u_no;
	}
	public void setU_no(String u_no) {
		this.u_no = u_no;
	}
	public String getI_no() {
		return i_no;
	}
	public void setI_no(String i_no) {
		this.i_no = i_no;
	}
	public String getR_answer() {
		return r_answer;
	}
	public void setR_answer(String r_answer) {
		this.r_answer = r_answer;
	}
	public String getR_score() {
		return r_score;
	}
	public void setR_score(String r_score) {
		this.r_score = r_score;
	}
	
}
