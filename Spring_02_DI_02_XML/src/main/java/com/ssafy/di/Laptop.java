package com.ssafy.di;

public class Laptop implements Computer {
	private String CPU;
	private String RAM;
	private String SSD;
	private String GPU;
	
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "랩톱";
	}

}
