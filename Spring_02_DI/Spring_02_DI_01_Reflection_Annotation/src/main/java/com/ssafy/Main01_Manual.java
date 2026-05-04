package com.ssafy;

// 비교용: @MyComponent 자동 스캔 없이 모든 객체를 수동으로 생성하는 방식
// 이 방식의 불편함이 Main02_Scan의 자동 스캔 방식으로 해결됨
public class Main01_Manual {

	public static void main(String[] args) {
		System.out.println("=== @MyComponent 없이 수동 방식 ===");

		// 모든 객체를 직접 생성해야 하며, @MyAutowired 필드는 주입이 안 됨
		Keyboard keyboard = new Keyboard();
		Computer computer = new Computer();
		// computer의 keyboard 필드는 null → NullPointerException 발생 가능

		System.out.println("keyboard = " + keyboard);
		System.out.println("computer.keyboard = null (주입 안 됨) → Main02_Scan 에서 해결");
	}
}
