package com.ssafy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 클래스에 붙이면 MyAnnotationContainer 패키지 스캔 시 자동으로 빈 등록
// 스프링의 @Component + @ComponentScan 원리와 동일
@Retention(RetentionPolicy.RUNTIME)  // 실행 중 스캔할 수 있도록 RUNTIME 필수
@Target(ElementType.TYPE)            // 클래스에만 사용 가능
public @interface MyComponent {
}
