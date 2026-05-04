package com.ssafy;

// @MyComponent 기반 동적 스캔 시연
// 나중에 배울 Spring의 new AnnotationConfigApplicationContext + @ComponentScan("com.ssafy") 와 동일
public class Main02_Scan {

	public static void main(String[] args) {
		System.out.println("=== 동적 애노테이션 스캔 컨테이너 시작 ===");

		// 패키지명만 지정하면 @MyComponent 클래스를 자동으로 찾아 등록
		MyAnnotationContainer container = new MyAnnotationContainer("com.ssafy");

		container.printBeans();

		Developer developer = container.getBean(Developer.class);
		developer.develop();
	}
}
