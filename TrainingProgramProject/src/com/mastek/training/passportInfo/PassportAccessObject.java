package com.mastek.training.passportInfo;

import java.util.Collection;

public interface PassportAccessObject<P> {
	
	public P add(P newP);
	public Collection<P> listAll();
	public P find(int key);
	public P remove (int key);

}
