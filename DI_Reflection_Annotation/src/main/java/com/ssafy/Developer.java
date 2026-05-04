package com.ssafy;

// Developer → Computer → Keyboard 의존 관계
@MyComponent
public class Developer {

	@MyAutowired
	private Computer computer;

	// 리플렉션 getDeclaredConstructor().newInstance() 호출을 위한 기본 생성자 필수
	public Developer() {
		System.out.println("Developer 생성");
	}

	public void develop() {
		System.out.println("[Developer] 개발 시작");
		computer.work();
		System.out.println("[Developer] 개발 완료");
	}

	public Computer getComputer() {
		return computer;
	}
}
