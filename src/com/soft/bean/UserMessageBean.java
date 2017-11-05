package com.soft.bean;

import java.util.List;

public class UserMessageBean {
	private TbPaperBean paperBean;
	private List<TbUserBean> tbUserBean;
	
	public UserMessageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserMessageBean(TbPaperBean paperBean, List<TbUserBean> tbUserBean) {
		super();
		this.paperBean = paperBean;
		this.tbUserBean = tbUserBean;
	}
	@Override
	public String toString() {
		return "UserMessageBean [paperBean=" + paperBean + ", tbUserBean=" + tbUserBean + "]";
	}
	public TbPaperBean getPaperBean() {
		return paperBean;
	}
	public void setPaperBean(TbPaperBean paperBean) {
		this.paperBean = paperBean;
	}
	public List<TbUserBean> getTbUserBean() {
		return tbUserBean;
	}
	public void setTbUserBean(List<TbUserBean> tbUserBean) {
		this.tbUserBean = tbUserBean;
	}
	
}
