package com.soft.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFileUtil {
	public static List<List<String>> readFileUtil(String fileName){
		List<List<String>> result = new ArrayList<List<String>>();
		try {

			//（给后面这俩创建输入流） the xlsx/xls file  
			FileInputStream fis = new FileInputStream(fileName);  

			//(给工作表创建实例)Create Workbook instance for xlsx/xls file input stream  
			Workbook workbook = null;

			//判断excel文件类型
			if(fileName.toLowerCase().endsWith("xlsx")){  
				workbook = new XSSFWorkbook(fis);  
			}else if(fileName.toLowerCase().endsWith("xls")){  
				workbook = new HSSFWorkbook(fis);  
			}

			//（获取在xlsx里面的sheet数量嘛）Get the number of sheets in the xlsx file  
			int numberOfSheets = workbook.getNumberOfSheets();  

			//（显然是遍历每一个sheet）loop through each of the sheets
			for(int i=0; i < numberOfSheets; i++){  

				//（肯定定位sheet）Get the nth sheet from the workbook  
				Sheet sheet = workbook.getSheetAt(i);  

				//（既然都sheet，那么接下来一定是遍历sheet的每一行）every sheet has rows, iterate over them  
				Iterator<Row> rowIterator = sheet.iterator();  
				while (rowIterator.hasNext()){ 
					//创建行List
					List<String> rowList = new ArrayList<String>();

					//（得到每一行的对象）Get the row object  
					Row row = rowIterator.next();  

					//（那每一行都由多个单元格组成，所以肯定是遍历每行的单元格）Every row has columns, get the column iterator and iterate over them  
					Iterator<Cell> cellIterator = row.cellIterator();  
					while (cellIterator.hasNext())   {
						//获取cell对象
						Cell cell = cellIterator.next();  

						//（检查每个单元格类型，和那个什么，反正就是那个意思了）check the cell type and process accordingly  
						switch(cell.getCellType()){

						//判断单元格是否为string类型
						case Cell.CELL_TYPE_STRING:
							//将每个cell内容放进行List中
							rowList.add(cell.getStringCellValue());  
							break;  

						case Cell.CELL_TYPE_NUMERIC:  
							//将每个cell内容放进行List中
							String str = cell.getNumericCellValue()+"";
							rowList.add(str);
							break; 
						}

					} //（这边是结束单元格遍历）end of cell iterator  

					//将行集合添加到结果集里面
					result.add(rowList);
				}
			}   
			//（开流就要关流）close file input stream  
			fis.close();  
		}catch (IOException e) {
			e.printStackTrace();  
		}  

		//返回结果集
		return result;  
	}
}
