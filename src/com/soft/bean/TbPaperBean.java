package com.soft.bean;
/**
 * 试题信息Bean类
 * @author JX170504
 *
 */
public class TbPaperBean {
	/**试卷编号*/
	private String p_no;
	/**本场考试的名称*/
	private String p_name;
	/**本场考试的时间*/
	private String p_time;
	/**本场考试的类型*/
	private String p_type;
	/**本场考试鉴定的工种*/
	private String p_work;
	/**鉴定机构*/
	private String p_institution;
	/**鉴定等级*/
	private String p_grade;
	/**及格分数*/
	private String p_score;
	/**单选*/
	private String p_radio;
	/**多选*/
	private String p_multiselect;
	/**倒计时*/
	private String p_sount_down;
	/**考试的状态*/
	private String p_state;
	
	public TbPaperBean(String p_no, String p_name, String p_time, String p_type, String p_work, String p_institution,
			String p_grade, String p_score, String p_radio, String p_multiselect, String p_sount_down, String p_state) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_time = p_time;
		this.p_type = p_type;
		this.p_work = p_work;
		this.p_institution = p_institution;
		this.p_grade = p_grade;
		this.p_score = p_score;
		this.p_radio = p_radio;
		this.p_multiselect = p_multiselect;
		this.p_sount_down = p_sount_down;
		this.p_state = p_state;
	}
	public TbPaperBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getP_state() {
		return p_state;
	}
	public void setP_state(String p_state) {
		this.p_state = p_state;
	}
	public String getP_no() {
		return p_no;
	}
	public void setP_no(String p_no) {
		this.p_no = p_no;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_time() {
		return p_time;
	}
	public void setP_time(String p_time) {
		this.p_time = p_time;
	}
	public String getP_type() {
		return p_type;
	}
	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	public String getP_work() {
		return p_work;
	}
	public void setP_work(String p_work) {
		this.p_work = p_work;
	}
	public String getP_institution() {
		return p_institution;
	}
	public void setP_institution(String p_institution) {
		this.p_institution = p_institution;
	}
	public String getP_grade() {
		return p_grade;
	}
	public void setP_grade(String p_grade) {
		this.p_grade = p_grade;
	}
	public String getP_score() {
		return p_score;
	}
	public void setP_score(String p_score) {
		this.p_score = p_score;
	}
	public String getP_radio() {
		return p_radio;
	}
	public void setP_radio(String p_radio) {
		this.p_radio = p_radio;
	}
	public String getP_multiselect() {
		return p_multiselect;
	}
	public void setP_multiselect(String p_multiselect) {
		this.p_multiselect = p_multiselect;
	}
	public String getP_sount_down() {
		return p_sount_down;
	}
	public void setP_sount_down(String p_sount_down) {
		this.p_sount_down = p_sount_down;
	}
	
}
