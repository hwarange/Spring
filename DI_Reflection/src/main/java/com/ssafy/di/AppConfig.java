package com.ssafy.di;

// 슬라이드 15: 컨테이너가 읽을 설계도
// @MyBean(name = "...") 메서드를 컨테이너가 리플렉션으로 찾아 실행 → 빈으로 등록
// 실제 Spring의 @Configuration + @Bean 과 동일한 구조
public class AppConfig {

  @MyBean(name = "gildong")
  public Person getGilDong() {
    return new Person(20, "길동", 100);
  }

  @MyBean(name = "yumi")
  public Person getYumi() {
    return new Person(18, "유미", 95);
  }
  
  public void nothing() {}
  public void nothing2() {}
  public void nothing3() {}
}
