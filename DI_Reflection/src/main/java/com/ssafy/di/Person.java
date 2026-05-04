package com.ssafy.di;

// 슬라이드 14: 컨테이너가 관리할 평범한 자바 객체(POJO)
// 특별한 인터페이스 구현·상속 없음 → Spring의 POJO 철학
public class Person {
  int age;
  String name;
  int score;

  public Person(int age, String name, int score) {
    this.age = age;
    this.name = name;
    this.score = score;
  }

  public void sing() {
    System.out.println(name + "이가 노래를 부릅니다!");
  }

  @Override
  public String toString() {
    return "Person{name='" + name + "', age=" + age + ", score=" + score + "}";
  }
}
