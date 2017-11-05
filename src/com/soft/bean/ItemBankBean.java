package com.soft.bean;

import java.util.List;

public class ItemBankBean {
	/**单选的试题*/
	private List<TbItemBankBean> singleChoiceList;
	/**多选的试题*/
	private List<TbItemBankBean> multipChoiceList;
	/**试卷的信息*/
	private TbPaperBean bean;
	/**考生答题的信息*/
	private List<TbResultBean> resBean;
	
	
	
	public ItemBankBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemBankBean(List<TbItemBankBean> singleChoiceList, List<TbItemBankBean> multipChoiceList, TbPaperBean bean,
			List<TbResultBean> resBean) {
		super();
		this.singleChoiceList = singleChoiceList;
		this.multipChoiceList = multipChoiceList;
		this.bean = bean;
		this.resBean = resBean;
	}
	public List<TbResultBean> getResBean() {
		return resBean;
	}
	public void setResBean(List<TbResultBean> resBean) {
		this.resBean = resBean;
	}
	public List<TbItemBankBean> getSingleChoiceList() {
		return singleChoiceList;
	}
	public void setSingleChoiceList(List<TbItemBankBean> singleChoiceList) {
		this.singleChoiceList = singleChoiceList;
	}
	public List<TbItemBankBean> getMultipChoiceList() {
		return multipChoiceList;
	}
	public void setMultipChoiceList(List<TbItemBankBean> multipChoiceList) {
		this.multipChoiceList = multipChoiceList;
	}
	public TbPaperBean getBean() {
		return bean;
	}
	public void setBean(TbPaperBean bean) {
		this.bean = bean;
	}
	
}
