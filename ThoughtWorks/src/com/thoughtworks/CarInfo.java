package com.thoughtworks;

import java.time.LocalDate;
/**
 * 车辆信息类
 * @author yangge
 *
 */
public class CarInfo {
	String plateNum;//车牌号
	LocalDate date;//购买日期
	String brand;//汽车品牌
	int mileage;//⽬目前运⾏行行公⾥里里数
	char overhaul;//有⽆无⼤大修
	public CarInfo(String plateNum,LocalDate date,String brand,int mileage,char overhaul){
		this.plateNum = plateNum;
		this.date = date;
		this.brand = brand;
		this.mileage = mileage;
		this.overhaul = overhaul;
	}
	public boolean isOverhaul(){
		boolean judge = false;
		if(this.overhaul=='T')
			judge = true;
		return judge;
	}
}
