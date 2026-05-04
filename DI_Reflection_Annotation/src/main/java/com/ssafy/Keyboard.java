package com.ssafy;

@MyComponent
public class Keyboard {

	// 리플렉션 getDeclaredConstructor().newInstance() 호출을 위한 기본 생성자 필수
	public Keyboard() {
		System.out.println("Keyboard 생성");
	}

	public void type() {
		System.out.println("[Keyboard] 타이핑 중...");
	}
}
