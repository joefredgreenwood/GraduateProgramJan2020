package com.mastek.training.pack1;

import java.util.Scanner;

public class ExceptionExample {

	public static void main(String[] args) {

		int num1=0,num2=0,result=0;

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter Num1: ");
			num1 = Integer.parseInt(sc.nextLine()); //fetch the string and convert it to int

			System.out.println("Enter Num2");
			num2 = Integer.parseInt(sc.nextLine());

			result = num1/num2;
			System.out.println("Division is: "+result);
		} 
		catch (NumberFormatException e) {
			e.printStackTrace();//print the same exception info on the console 
			System.err.println("Invalid number entered");
		}

		catch (Exception ex) { //Handles all kind of exceptions
			System.err.println("Exception Occured: "+ex); //Print Exception with message
			System.err.println("Exception Message: "+ex.getMessage());
			ex.printStackTrace(); // Print complete info about exception
		}



		finally {
			System.out.println("Scanner Closed"); //will always be executed regardless of success. If exception will abort here.
			sc.close();
		}

		System.out.println("Program complete");
	}
}