package com.soft.bean;

public class UserPaperBean {
	private TbPaperBean paperBean;
	private TbUserBean userBean;
	
	
	public UserPaperBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPaperBean(TbPaperBean paperBean, TbUserBean userBean) {
		super();
		this.paperBean = paperBean;
		this.userBean = userBean;
	}
	public TbPaperBean getPaperBean() {
		return paperBean;
	}
	public void setPaperBean(TbPaperBean paperBean) {
		this.paperBean = paperBean;
	}
	public TbUserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(TbUserBean userBean) {
		this.userBean = userBean;
	}
	
}
