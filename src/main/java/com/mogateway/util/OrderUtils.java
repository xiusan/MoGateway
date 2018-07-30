package com.mogateway.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderUtils {
	
	public static String getOrderNo(){
		String orderNo = "";
		String date = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		Integer math = new Random().nextInt(1000);
		orderNo = date+""+math;
		return orderNo;
	}
	public static String getCouponNo(){
		String orderNo = "";
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		Integer math = new Random().nextInt(1000000);
		orderNo = date+""+math;
		return orderNo;
	}
	
	public static String getContractNo(){
		String orderNo = "";
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		//Integer math = new Random().nextInt(1000000);
		orderNo = date;
		return orderNo;
	}
	public static String getOrderDetailNo(String orderNo, Integer number){
//		if(number > 0 && number < 10){
//			orderNo+="00"+number;
//		}else if(){
//			
//		}
		return orderNo;
	}
	public static void main(String[] args){

		System.out.println(getOrderNo());
	}
}
