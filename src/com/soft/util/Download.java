package com.soft.util;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.soft.bean.TbPaperBean;
import com.soft.bean.TbUserBean;
import com.soft.daofactor.DaoFactory;
import com.soft.daoimpl.TbItemBankDaoImpl;
import com.soft.daoimpl.TbPaperDaoImpl;
import com.soft.daoimpl.TbUserDaoImpl;

public class Download {
	public static void export(String url) throws Exception{  
		// 第一步，创建一个webbook，对应一个Excel文件  
		HSSFWorkbook wb = new HSSFWorkbook();  
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
		HSSFSheet sheet = wb.createSheet("学生表成绩表");  
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
		HSSFRow row = sheet.createRow((int) 0);  
		// 第四步，创建单元格，并设置值表头 设置表头居中  
		HSSFCellStyle style = wb.createCellStyle();  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  

		HSSFCell cell = row.createCell((short) 0);  
		cell.setCellValue("准考证号");  
		cell.setCellStyle(style);  
		cell = row.createCell((short) 1);  
		cell.setCellValue("考生姓名");  
		cell.setCellStyle(style);  
		cell = row.createCell((short) 2);  
		cell.setCellValue("考试科目");  
		cell.setCellStyle(style);  
		cell = row.createCell((short) 3);  
		cell.setCellValue("科目名称");  
		cell.setCellStyle(style);  
		cell = row.createCell((short) 4);  
		cell.setCellValue("工种");  
		cell.setCellStyle(style); 
		cell = row.createCell((short) 5);  
		cell.setCellValue("等级");  
		cell.setCellStyle(style); 
		cell = row.createCell((short) 6);  
		cell.setCellValue("成绩");  
		cell.setCellStyle(style); 
		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
		TbUserDaoImpl userDaoImpl = (TbUserDaoImpl) DaoFactory.getInsrance("com.soft.daoimpl.TbUserDaoImpl");
		TbPaperDaoImpl paperDaoImpl = (TbPaperDaoImpl) DaoFactory.getInsrance("com.soft.daoimpl.TbPaperDaoImpl");
		TbPaperBean bean =  paperDaoImpl.sel();
		List<TbUserBean> tbUserBean = (List<TbUserBean>) userDaoImpl.findAll();		
		for (int i = 0; i < tbUserBean.size(); i++){  
			row = sheet.createRow((int) i + 1);  
			// 第四步，创建单元格，并设置值  
			row.createCell((short) 0).setCellValue(tbUserBean.get(i).getU_id());  
			row.createCell((short) 1).setCellValue(tbUserBean.get(i).getU_name());  
			row.createCell((short) 2).setCellValue(bean.getP_no());  
			row.createCell((short) 3).setCellValue(bean.getP_name()); 
			row.createCell((short) 4).setCellValue(bean.getP_work());  
			row.createCell((short) 5).setCellValue(bean.getP_grade());  
			row.createCell((short) 6).setCellValue(tbUserBean.get(i).getU_total_points());  
			cell = row.createCell((short) 7);  
		}  
		// 第六步，将文件存到指定位置  
		try{  
			FileOutputStream fout = new FileOutputStream(url);  
			wb.write(fout);  
			fout.close();  
		}catch (Exception e){  
			e.printStackTrace();  
		}  
	}  
	
	public static void main(String[] args) {
	try {
		export("D:/JavaProject/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/OstaWeb/download/Student.xls");
	} catch (Exception e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
}
}
