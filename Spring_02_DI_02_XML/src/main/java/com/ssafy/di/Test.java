package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		//이미 생성된 객체(Bean)을 꺼내보자
		
		Programmer p = (Programmer) context.getBean("programmer");
		Desktop desktop = context.getBean("desktop", Desktop.class);
		
		//수동으로 조립을 해주시면 된다...!
		p.setComputer(desktop);
		p.coding();
	
	}
	
}
