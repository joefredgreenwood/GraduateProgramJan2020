package com.mastek.training.pack1;

public class SimpleClassTwo {

	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		System.out.println(
				//"Private: "+sc1.privateNumber+
				", Default: "+sc1.defaultNumber+
				", Protected: "+sc1.protectedNumber+
				", Public: "+sc1.publicNumber);
		//In another class of same package we can access all members except private (hence why its commented out)
	}
}
