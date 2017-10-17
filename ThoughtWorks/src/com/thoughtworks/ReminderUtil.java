package com.thoughtworks;

import java.time.LocalDate;

public class ReminderUtil {
	public static final int F_SERVICE_LIFE = 2190;
	public static final int T_SERVICE_LIFE = 1095;
	public static boolean timeRelated(CarInfo car,LocalDate curDate){//定期保养
		boolean judge = false;
		LocalDate temp = car.date; 
		if(car.isOverhaul()){
			while(!temp.isAfter(curDate)&&!temp.equals(curDate)){
				temp = temp.plusMonths(3);
			}
		}
		else{
			if(curDate.getYear()-car.date.getYear()<3){
				while(!temp.isAfter(curDate)&&!temp.equals(curDate)){
					temp = temp.plusMonths(12);
				}
			}
			else{ 
				while(!temp.isAfter(curDate)&&!temp.equals(curDate)){
					temp = temp.plusMonths(6);
				}
			}
		}
		if(curDate.getMonthValue() == temp.getMonthValue()){
			if(curDate.getDayOfMonth()<=temp.getDayOfMonth())
				judge = true;
		}
		else if( temp.getMonthValue() - curDate.getMonthValue()==1){
			judge = true;
		}
		return judge;
	}
	public static boolean distanceRelated(CarInfo car,LocalDate curDate){//每1万公⾥里里保养
		boolean judge = false;
		if(car.mileage%10000==0||(car.mileage%10000>=9500&&car.mileage%10000<=9999))
			judge = true;
		return judge;
	}
	public static boolean writerOffRelated(CarInfo car,LocalDate curDate){//报废提醒
		boolean judge = false;
		LocalDate writerOffDate = null;
		if(car.isOverhaul())
			writerOffDate = car.date.plusDays(T_SERVICE_LIFE);
		else
			writerOffDate = car.date.plusDays(F_SERVICE_LIFE);
		if(writerOffDate.isAfter(curDate)){
			if(writerOffDate.getYear() == curDate.getYear()){
				if(writerOffDate.getMonthValue()-curDate.getMonthValue()==1)
					judge = true;
				else if(writerOffDate.getMonthValue() == curDate.getMonthValue()){
					if(curDate.getDayOfMonth()<writerOffDate.getDayOfMonth())
						judge = true;
				}

			}
		}
		return judge;
	}
	public static boolean writerOff(CarInfo car,LocalDate curDate){//报废提醒
		boolean judge = false;
		LocalDate writerOffDate = null;
		if(car.isOverhaul())
			writerOffDate = car.date.plusDays(T_SERVICE_LIFE);
		else
			writerOffDate = car.date.plusDays(F_SERVICE_LIFE);
		if(writerOffDate.isBefore(curDate)||writerOffDate.equals(curDate))
			judge = true;
		return judge;
	}

}
