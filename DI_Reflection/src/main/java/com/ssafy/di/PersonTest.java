package com.ssafy.di;

// Person 클래스가 잘 동작하는지 가볍게 확인 (유닛 테스트 아님, 그냥 main 출력)
// → "길동이가 노래를 부릅니다!" 가 찍히면 OK
public class PersonTest {
  public static void main(String[] args) {
    Person gildong = new Person(20, "길동", 100);
    gildong.sing();
  }
}
