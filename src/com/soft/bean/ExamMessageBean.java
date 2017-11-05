package com.soft.bean;

public class ExamMessageBean {
	private int count;
	private TbPaperBean bean;
	
	
	
	@Override
	public String toString() {
		return "ExamMessageBean [count=" + count + ", bean=" + bean + "]";
	}
	public ExamMessageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamMessageBean(int count, TbPaperBean bean) {
		super();
		this.count = count;
		this.bean = bean;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public TbPaperBean getBean() {
		return bean;
	}
	public void setBean(TbPaperBean bean) {
		this.bean = bean;
	}
	
}
