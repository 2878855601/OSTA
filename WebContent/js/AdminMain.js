$(document).ready(function(){

	window.onload = setInterval( function getTime() {

	    var dateObj = new Date();

	    var year = dateObj.getFullYear();//年
	    var month = dateObj.getMonth()+1;//月
	    var date = dateObj.getDate();//日
		var hour = dateObj.getHours();//时
		var minute = dateObj.getMinutes();//分
		var second = dateObj.getSeconds();//秒
	    if(month<10){
	        month = "0"+month;
	    }
	    if(date<10){
	        date = "0"+date;
	    }
		if(hour<10){
	        hour = "0"+hour;
	    }
	    if(minute<10){
	        minute = "0"+minute;
	    }
	    if(second<10){
	        second = "0"+second;
	    }

	    var newDate = year+"年"+month+"月"+date+"日"+" "+hour + ":" + minute + ":" + second;
	    document.getElementById("time").innerHTML =newDate;//在div中写入时间
	   // setInterval('getTime()', 500);//每隔500ms执行一次getTime()
	},500);
	
	$("#help").click(function(){
		document.getElementById("divhelp").style.display ="block";
		document.getElementById("divmain").style.display ='none'; 
	});
	
	$("#helpbutton").click(function(){
		document.getElementById("divmain").style.display ="block";
		document.getElementById("divhelp").style.display ='none'; 
	});
});