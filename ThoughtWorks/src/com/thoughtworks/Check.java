package com.thoughtworks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

public class Check {
	public static void check(String path){
		TreeMap<String,ArrayList<String>> timeRelated = new TreeMap<>();//报废提醒
		TreeMap<String,ArrayList<String>> distanceRelated = new TreeMap<>();//每1万公⾥里里保养提醒
		TreeMap<String,ArrayList<String>> writerOffRelated = new TreeMap<>();//定期保养
		File file = new File(path);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			String[] tempDate = reader.readLine().replaceAll("SubmitDate:","").trim().split("/");
			LocalDate curDate = LocalDate.of(Integer.valueOf(tempDate[0]), Integer.valueOf(tempDate[1]), Integer.valueOf(tempDate[2]));
			while((tempString = reader.readLine())!=null){
				CarInfo car = FormatCar.getCar(tempString);
				if(!ReminderUtil.writerOff(car,curDate)){//判断车辆是否已经报废
					if(ReminderUtil.writerOffRelated(car,curDate)){//判断车辆是否需要报废提醒
						if(!writerOffRelated.containsKey(car.brand)){
							writerOffRelated.put(car.brand, new ArrayList<String>());
							writerOffRelated.get(car.brand).add(car.plateNum);
						}
						else
							writerOffRelated.get(car.brand).add(car.plateNum);
					}
					else{
						if(ReminderUtil.distanceRelated(car,curDate)){//判断车辆是否需要每1万公⾥里里保养
							if(!distanceRelated.containsKey(car.brand)){
								distanceRelated.put(car.brand, new ArrayList<String>());
								distanceRelated.get(car.brand).add(car.plateNum);
							}
							else
								distanceRelated.get(car.brand).add(car.plateNum);
						}
						else if(!ReminderUtil.distanceRelated(car,curDate)&&ReminderUtil.timeRelated(car,curDate)){//判断车辆是否需要定期保养
							if(!timeRelated.containsKey(car.brand)){
								timeRelated.put(car.brand, new ArrayList<String>());
								timeRelated.get(car.brand).add(car.plateNum);
							}
							else
								timeRelated.get(car.brand).add(car.plateNum);
						}
					}
				}
			}
			Print.print(timeRelated, distanceRelated, writerOffRelated);//打印查询结果
			reader.close();	//关闭输入流
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{

		}
	}
}
