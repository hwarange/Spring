package com.ssafy.di;

public class Desktop implements Computer {
	
	private String CPU;
	private String RAM;
	private String SSD;
	private String GPU;

	@Override
	public String getInfo() {

		return "데스크톱";
	}

}
