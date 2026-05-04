package com.ssafy.di;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 슬라이드 15: 빈 등록용 커스텀 어노테이션
// RUNTIME → 실행 중에도 정보 유지(리플렉션으로 읽기 위해 필수)
// METHOD  → 메서드에만 부착 가능
// name() → Bean 이름 (기본값 "")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyBean {
  String name() default "";
}
