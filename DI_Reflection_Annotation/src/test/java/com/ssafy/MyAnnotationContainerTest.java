package com.ssafy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyAnnotationContainerTest {

	private MyAnnotationContainer container;

	@BeforeEach
	void setUp() {
		container = new MyAnnotationContainer("com.ssafy");
	}

	@Test
	@DisplayName("@MyComponent가 붙은 클래스들이 자동으로 빈으로 등록되어야 한다")
	void testComponentScan() {
		assertDoesNotThrow(() -> container.getBean(Keyboard.class));
		assertDoesNotThrow(() -> container.getBean(Computer.class));
		assertDoesNotThrow(() -> container.getBean(Developer.class));
	}

	@Test
	@DisplayName("스캔 후 @MyAutowired 필드에 의존성이 자동 주입되어야 한다")
	void testDependencyInjection() {
		Computer computer = container.getBean(Computer.class);
		Developer developer = container.getBean(Developer.class);

		assertNotNull(computer.getKeyboard(), "Computer의 Keyboard가 주입되어야 한다");
		assertNotNull(developer.getComputer(), "Developer의 Computer가 주입되어야 한다");
	}

	@Test
	@DisplayName("등록되지 않은 타입 요청 시 RuntimeException이 발생해야 한다")
	void testBeanNotFound() {
		assertThrows(RuntimeException.class, () -> container.getBean(String.class));
	}
}
