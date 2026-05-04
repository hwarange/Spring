package com.ssafy.di;

import java.lang.reflect.Method;

// 슬라이드 13 선행실습: 리플렉션으로 @MyBean 메서드 찾기
// AppConfig.class → 모든 메서드 → @MyBean 붙은 것만 이름 출력
public class Main02_Reflection {
  public static void main(String[] args) {
    Method[] methods = AppConfig.class.getDeclaredMethods();
    for (Method m : methods) {
      if (m.isAnnotationPresent(MyBean.class)) {
        System.out.println("@MyBean이 붙은 메서드: " + m.getName());
      }
    }
  }
}
