package com.ssafy;

@MyComponent
public class Computer {

	@MyAutowired
	private Keyboard keyboard;

	// 리플렉션 getDeclaredConstructor().newInstance() 호출을 위한 기본 생성자 필수
	public Computer() {
		System.out.println("Computer 생성");
	}

	public void work() {
		System.out.println("[Computer] 작업 시작");
		keyboard.type();
		System.out.println("[Computer] 작업 완료");
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}
}
