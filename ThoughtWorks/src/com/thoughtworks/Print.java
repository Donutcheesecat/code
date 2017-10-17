package com.thoughtworks;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;
/*
 * 查询结果打印
 */
public class Print {
	public static void print(TreeMap<String,ArrayList<String>> timeRelated,TreeMap<String,ArrayList<String>> distanceRelated,TreeMap<String,ArrayList<String>> writerOffRelated){
		System.out.println("Reminder");
		System.out.println("==================");
		System.out.println();
		System.out.println("* Time-related maintenance coming soon...");
		for(Entry<String,ArrayList<String>> entry : timeRelated.entrySet()){
			System.out.print(entry.getKey()+": "+entry.getValue().size()+" (");
			for(int i=0;i<entry.getValue().size();i++){
				if(i!=entry.getValue().size()-1)
					System.out.print(entry.getValue().get(i)+", ");
				else
					System.out.print(entry.getValue().get(i));
			}
			System.out.println(")");

		}
		System.out.println();
		System.out.println("* Distance-related maintenance coming soon...");
		for(Entry<String,ArrayList<String>> entry : distanceRelated.entrySet()){
			System.out.print(entry.getKey()+": "+entry.getValue().size()+" (");
			for(int i=0;i<entry.getValue().size();i++){
				if(i!=entry.getValue().size()-1)
					System.out.print(entry.getValue().get(i)+", ");
				else
					System.out.print(entry.getValue().get(i));
			}
			System.out.println(")");
		}
		System.out.println();
		System.out.println("* Write-off maintenance coming soon...");
		for(Entry<String,ArrayList<String>> entry : writerOffRelated.entrySet()){
			System.out.print(entry.getKey()+": "+entry.getValue().size()+" (");
			for(int i=0;i<entry.getValue().size();i++){
				if(i!=entry.getValue().size()-1)
					System.out.print(entry.getValue().get(i)+", ");
				else
					System.out.print(entry.getValue().get(i));
			}
			System.out.println(")");
			System.out.println();
		}
	}
}
