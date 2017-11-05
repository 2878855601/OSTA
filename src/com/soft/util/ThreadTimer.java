package com.soft.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.soft.bean.TbPaperBean;
import com.soft.daofactor.DaoFactory;
import com.soft.daoimpl.TbPaperDaoImpl;

public class ThreadTimer extends Thread {

	private int time;
	TbPaperDaoImpl paperDaoImpl = (TbPaperDaoImpl) DaoFactory.getInsrance("com.soft.daoimpl.TbPaperDaoImpl");
	public static Timer times;
	public ThreadTimer() {
		super();
		// TODO Auto-generated constructor stub
		TbPaperBean bean =  paperDaoImpl.sel();
		String res = bean.getP_sount_down();
		if(res == "00:00:00"){
			boolean cont = paperDaoImpl.update("00:00:00","考试结束");
			times.stop();
		}
		String re[] = res.split(":");
		int hour =Integer.valueOf(re[0]);
		int min = Integer.valueOf(re[1]);
		int sec = Integer.valueOf(re[2]);
		time = hour*3600 + min*60 + sec;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		times = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TbPaperBean bean = paperDaoImpl.sel();
				if(ThreadTimer.this.time < 0 || bean.getP_state().equals("考试结束")){
					boolean cont = paperDaoImpl.update("00:00:00","考试结束");
					times.stop();
				}else{
					String downTime = ThreadTimer.this.downTime(time);
					boolean cunt = paperDaoImpl.update(downTime, "考试中");
				}
				ThreadTimer.this.time -- ;
			}
		});
		times.start();
	}

	/**以时分秒的格式获取时间*/
	public String downTime(int scend){
		String getTime = null;
		int hour = 0;//小时
		int minute = 0;//分钟
		int seconds = 0;//秒
		hour = scend / 3600;
		minute = (scend - hour * 3600) / 60;
		seconds = scend - hour * 3600 - minute * 60;
		if(minute<10 && seconds<10){
			getTime = "0"+hour+":0"+minute+":0"+seconds;
		}else if(minute>=10 && seconds<10){
			getTime = "0"+hour+":"+minute+":0"+seconds;
		}else if(minute<10 && seconds>=10){
			getTime = "0"+hour+":0"+minute+":"+seconds;
		}else if(minute>=10 && seconds>=10){
			getTime = "0"+hour+":"+minute+":"+seconds;
		}
		return getTime;
	}

}
