package com.soft.dao;

import java.util.List;

public interface IBaseDao {
	//插入的方法
	public boolean insertByBean(Object bean);
	//查询的方法
	public List<?> findAll();
	//删除的方法
	public boolean delete(int id);
	//修改的方法
	public boolean updateByBean(Object bean);
}
