package com.datahub.template.beans;

public enum TmpType {
	
	Dummy,
	A,
	B;
	
	public int index() {
		return ordinal();
	}

}
