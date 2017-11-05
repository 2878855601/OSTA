package com.soft.bean;
/**
 * 试题表bean类
 * @author JX170504
 *
 */
public class TbItemBankBean {
	/**题号*/
	private String i_no;
	/**题型*/
	private String i_type;
	/**题干*/
	private String i_content;
	/**选项A*/
	private String i_option_A;
	/**选项B*/
	private String i_option_B;
	/**选项C*/
	private String i_option_C;
	/**选项D*/
	private String i_option_D;
	/**答案*/
	private String i_answer;
	/**分值*/
	private String i_score;
	/**试卷编码*/
	private String p_no;
	
	
	public TbItemBankBean(String i_no, String i_type, String i_content, String i_option_A, String i_option_B,
			String i_option_C, String i_option_D, String i_answer, String i_score, String p_no) {
		super();
		this.i_no = i_no;
		this.i_type = i_type;
		this.i_content = i_content;
		this.i_option_A = i_option_A;
		this.i_option_B = i_option_B;
		this.i_option_C = i_option_C;
		this.i_option_D = i_option_D;
		this.i_answer = i_answer;
		this.i_score = i_score;
		this.p_no = p_no;
	}
	public TbItemBankBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getI_no() {
		return i_no;
	}
	public void setI_no(String i_no) {
		this.i_no = i_no;
	}
	public String getI_type() {
		return i_type;
	}
	public void setI_type(String i_type) {
		this.i_type = i_type;
	}
	public String getI_content() {
		return i_content;
	}
	public void setI_content(String i_content) {
		this.i_content = i_content;
	}
	public String getI_option_A() {
		return i_option_A;
	}
	public void setI_option_A(String i_option_A) {
		this.i_option_A = i_option_A;
	}
	public String getI_option_B() {
		return i_option_B;
	}
	public void setI_option_B(String i_option_B) {
		this.i_option_B = i_option_B;
	}
	public String getI_option_C() {
		return i_option_C;
	}
	public void setI_option_C(String i_option_C) {
		this.i_option_C = i_option_C;
	}
	public String getI_option_D() {
		return i_option_D;
	}
	public void setI_option_D(String i_option_D) {
		this.i_option_D = i_option_D;
	}
	public String getI_answer() {
		return i_answer;
	}
	public void setI_answer(String i_answer) {
		this.i_answer = i_answer;
	}
	public String getI_score() {
		return i_score;
	}
	public void setI_score(String i_score) {
		this.i_score = i_score;
	}
	public String getP_no() {
		return p_no;
	}
	public void setP_no(String p_no) {
		this.p_no = p_no;
	}
	
}
