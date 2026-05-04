package com.ssafy.di;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// 슬라이드 16: 미니 IoC 컨테이너
// "생성"과 "보관"을 담당. 진짜 Spring 컨테이너의 핵심 아이디어를 압축한 버전.
public class MyContainer {

  // 빈 저장소(사물함): 이름 → 객체
  private final Map<String, Object> beanMap = new HashMap<>();

  public Object getBean(String name) {
    return beanMap.get(name);
  }

  // 설정 클래스를 받아 @MyBean 메서드를 전부 실행하고 결과를 beanMap에 저장
  public MyContainer(Class<?> configClass) throws Exception {
    // 1단계: 리플렉션으로 설정 클래스(AppConfig) 객체 생성
    Object config = configClass.getDeclaredConstructor().newInstance();

    // 2단계: 모든 메서드 순회하며 @MyBean 붙은 것만 골라
    // 3단계: 메서드 실행 → 반환된 객체를 name과 함께 beanMap에 저장
    for (Method method : configClass.getDeclaredMethods()) {
      if (method.isAnnotationPresent(MyBean.class)) {
        Object bean = method.invoke(config);
        String beanName = method.getAnnotation(MyBean.class).name();
        beanMap.put(beanName, bean);
      }
    }
  }
}
