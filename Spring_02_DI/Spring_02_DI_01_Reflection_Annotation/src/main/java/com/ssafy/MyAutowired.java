package com.ssafy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 필드에 붙이면 MyAnnotationContainer가 beanMap에서 맞는 빈을 자동 주입
// 스프링의 @Autowired와 동일
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)  // 필드에만 사용 가능
public @interface MyAutowired {
}
