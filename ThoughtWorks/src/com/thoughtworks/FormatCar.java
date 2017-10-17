package com.thoughtworks;

import java.time.LocalDate;
/*
 * 由字符串格式化为CarInfo的数据结构
 */
public class FormatCar {
	public static CarInfo getCar(String s){
		String[] arr = s.split("\\|");
    	String plateNum = arr[0];
    	String[] tempDate = arr[1].split("/");
    	LocalDate date = LocalDate.of(Integer.valueOf(tempDate[0]), Integer.valueOf(tempDate[1]), Integer.valueOf(tempDate[2]));
    	String brand = arr[2];
    	int mileage = Integer.valueOf(arr[3]);
    	char overhaul = arr[4].charAt(0);
		
		return new CarInfo(plateNum,date,brand,mileage,overhaul);
	}
}
