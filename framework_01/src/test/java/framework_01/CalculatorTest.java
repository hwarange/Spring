package framework_01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.ssafy.live.Calculator;

public class CalculatorTest {
	
	// 로거 객체 생성
	Logger log = LoggerFactory.getLogger(CalculatorTest.class);

	// 매번 초기화 해줘야 하는 객체 계산기 선언...!
	Calculator calc;
	
	// 매번 테스트 마다 해당 calc를 초기화 해주는 부분!
	@BeforeEach
	void setup() {
		calc = new Calculator();
		log.info("새로운 계산기 생성!");
	}
	
	@Test //우리가 테스트를 해보고 싶은 유닛테스트 메서드 생성
	public void add_1_by_2_to_3() {
		int result = calc.add(1, 2);
		log.trace("계산 결과는 {}입니다.", result);
		Assertions.assertEquals(result, 3);
	}

}
