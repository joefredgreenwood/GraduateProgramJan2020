package com.mastek.training.pack1;

public class DerivedClass extends SimpleClass {
	
	public static void main(String[] args) {
		DerivedClass sc1 = new DerivedClass();
		System.out.println(
				//"Private: "+sc1.privateNumber+
				", Default: "+sc1.defaultNumber+
				", Protected: "+sc1.protectedNumber+
				", Public: "+sc1.publicNumber);
		//In a derived class we can access all members except private AGAIN (hence why its commented out)
	}
	
	
	
	

}
