package com.soft.util;

import java.io.File;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.soft.daofactor.DaoFactory;
import com.soft.daoimpl.TbItemBankDaoImpl;
import com.soft.daoimpl.TbPaperDaoImpl;
import com.soft.daoimpl.TbResultDaoImpl;
import com.soft.daoimpl.TbUserDaoImpl;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 * 解压导入的文件
 * @author JX170504 黄力超
 *
 */
public class ZipFileUtil {
	/**
	 * 
	 * @param path	压缩包的路径(带包名)
	 * @param dest	解压后的存放路径
	 * @param pwd	解压密码
	 */
	public static void zipFile(String path, String dest, String pwd){
		File file = new File(path);
		try {
			//指向要解压的文件
			ZipFile zipFile = new ZipFile(file);
			//设置文件的编码格式
			zipFile.setFileNameCharset("UTF-8");
			if(!zipFile.isValidZipFile()){
				System.out.println("文件损坏");
			}else{
				//解压目录
				File destDir = new File(dest);
				if(destDir.isDirectory() && !destDir.exists()){
					destDir.mkdir();
				}
				if(zipFile.isEncrypted()){
					zipFile.setPassword(pwd.toCharArray());
				}
				//解压文件
				zipFile.extractAll(dest);

				File file1=new File(dest + "\\exam");
				String test[];
				test=file1.list();
			}
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
