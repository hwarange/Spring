package com.ssafy.di;


public class Programmer {
	private String name;
	private int age;
	// 인터페이스로 작성하여서 구현체인 Desktop <-> Laptop...! 
	// 활용할 수 있도록 만듦..!
	private Computer computer = new Desktop();

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public Programmer() {
	}



	public Programmer(String name, int age, Computer computer) {
		this.name = name;
		this.age = age;
		this.computer = computer;
	}
	
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 수행합니다.");
	}
}
