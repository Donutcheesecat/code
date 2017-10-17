ThoughtWorks2018校园招聘作业题目——出租车
=============
-------------
实现方式：Check类的check(String path)作为读取的入口,后调用相关类将车辆进行分类整理
# 一共有五个类构成
* 车辆信息 CarInfo
* 车辆信息格式化 FormatCar
* 相关判断方法 ReminderUtil
* 检测与分类 Check
* 打印输出 Print

# 测试
## 测试类
```JAVA
package com.thoughtworks;

public class Test {
	 public static void main(String[] args){
		 Check.check("D:\\text1.txt");//查询入口
		 Check.check("D:\\text2.txt");//查询入口
	 }
}
```
### 测试一 text1.txt
SubmitDate: 2030/09/01<br>
CAR0001|2025/04/05|Porsche|10000|F<br>
CAR0002|2029/10/14|Porsche|9000|F<br>
CAR0003|2026/08/17|Porsche|13000|F<br>
CAR0004|2027/11/01|BYD|23000|T<br>
CAR0005|2027/01/11|BYD|19500|F<br>
CAR0006|2029/07/01|Audi|10001|T<br>
CAR0007|2028/04/19|Ford|9800|F<br>
CAR0008|2027/07/10|Ford|15000|T<br>
CAR0009|2024/10/22|Ford|90300|F<br>
### 测试二 text2.txt
SubmitDate: 2050/05/01<br>
CAR0001|2044/05/01|Volkswagen|65535|F<br>
CAR0002|2044/05/03|BMW|100001|F<br>
CAR0003|2047/05/02|Mercedes-Benz|37789|T<br>
CAR0004|2047/05/03|Honda|59908|T<br>
CAR0005|2049/12/10|Peugeot|49999|F<br>
CAR0006|2046/11/15|Jeep|2000|F<br>
CAR0007|2046/11/16|Jeep|5000|F<br>
## 测试结果
![](https://github.com/Donutcheesecat/code/raw/master/ThoughtWorks/picture/result.png)

