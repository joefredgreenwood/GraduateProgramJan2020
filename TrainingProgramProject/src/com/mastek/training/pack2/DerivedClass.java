package com.mastek.training.pack2;

import com.mastek.training.pack1.SimpleClass;

public class DerivedClass extends SimpleClass {
	
	public static void main(String[] args) {
		DerivedClass sc1 = new DerivedClass();
		System.out.println(
				//"Private: "+sc1.privateNumber+
				//", Default: "+sc1.defaultNumber+
				", Protected: "+sc1.protectedNumber+
				", Public: "+sc1.publicNumber);
		//In a derived class we can access protected members as well from the original devised.
	}
	
	
	
	

}
