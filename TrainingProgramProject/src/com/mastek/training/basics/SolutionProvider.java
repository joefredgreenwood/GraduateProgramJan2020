package com.mastek.training.basics;

import com.sun.org.apache.xpath.internal.operations.And;

public class SolutionProvider {

	/* Take 2 numbers from the user and displax the max as an output
	 * 
	 */
	//public static <return data type> name of function <param_type_1> <param_name_1>, ...
	public static int getMaxNumber(int num1,int num2){
		int max=0;

		if (num1>num2) {
			max=num1;
		} else {
			max=num2;

		}
		return max;
	}

	public static String divideNumbers(int num1,int num2){
		int answer=0, remainder=0;

		answer = (num1 / num2);
		remainder = num1 % num2;

		return answer +","+ remainder;
	}

	public static double kmToMile(double km){
		double miles=0;
		miles = (km / 1.608);
		return miles;
	}

	public static String areaOfRectangle(int num1,int num2){
		int area=0;
		area= (num1 * num2);
		if (num1==num2) {
			return "Square area is " + area;}
		else {return "Rectangle area is " + area;
		}

	}

	public static String grade(int grade1,int grade2, int grade3){
		float averageGrade=0; 
		String studentGrade;
		averageGrade= (grade1 + grade2 + grade3)/3;
		if (averageGrade>=90) {
			studentGrade="A*";}
		else if ((averageGrade<90)&&(averageGrade>=80)) {
			studentGrade="A";}
		else if ((averageGrade<80)&&(averageGrade>=70)) {
			studentGrade="B";}
		else if ((averageGrade<70)&&(averageGrade>=60)) {
			studentGrade="C";}
		else if ((averageGrade<60)&&(averageGrade>=50)) {
			studentGrade="D";}
		else {studentGrade="Fail";		
		}
		return studentGrade;

	}

	public static double journeyTime(double distance, double speed){
		double time=0;
		time = (distance / speed);
		return time;
	}

	public static double circleArea(double radius){
		double area;
		area = (radius*radius*3.14);
		return area;
	}

	public static void multiplyTable(int num1){
		for(int i=1;i<11;i++) {
			System.out.println(i*num1);
		}

	}


	public static int minValue(int num1, int num2, int num3){
		int oneToTwo, minToMin;
		oneToTwo = (Math.min(num1, num2));
		minToMin = (Math.min(oneToTwo, num3));
		return minToMin;
	}

}