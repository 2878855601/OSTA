package com.soft.daofactor;

import com.soft.dao.IBaseDao;

public class DaoFactory {
	public static IBaseDao getInsrance(String className){
		IBaseDao baseDao = null;
		try {
			Class clazz = Class.forName(className);
			try {
				baseDao = (IBaseDao) clazz.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baseDao;
	}

}
