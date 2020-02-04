package com.mastek.training.basics;

public class ExampleApplication {
	public static void main(String[] args) {
		int maxResult = 0; // This is used to declare a variable so you can use it multiple times //

		maxResult = SolutionProvider.getMaxNumber(10, 2);
		System.out.println("Max result is " + maxResult);

		maxResult = SolutionProvider.getMaxNumber(10, 20);
		System.out.println("Max result is " + maxResult);

		maxResult = SolutionProvider.getMaxNumber(-10, -2);
		System.out.println("Max result is " + maxResult);

		maxResult = SolutionProvider.getMaxNumber(1000, 2221);
		System.out.println("Max result is " + maxResult);
		
		SolutionProvider.multiplyTable(4);

	}
}
