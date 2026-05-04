package com.ssafy.di;

// 슬라이드 6: 강한 결합(Tight Coupling) 비교용
// 객체가 100개면 new도 100번 → 컨테이너가 등장한 이유
public class Main01_Tight {

  public static void main(String[] args) {
    Person gildong = new Person(20, "길동", 100);
    Person yumi = new Person(18, "유미", 95);

    System.out.println(gildong);
    System.out.println(yumi);
    gildong.sing();
  }
}
