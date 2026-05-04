package com.ssafy.di;

// 슬라이드 17: 제어의 역전(IoC) 체험
// main 어디에도 new Person()이 없다 → 컨테이너가 생성·보관 담당
public class Main03_Container {

  public static void main(String[] args) throws Exception {
    // 컨테이너 생성 시점에 AppConfig를 읽어 @MyBean 메서드 전부 실행 → beanMap 등록
    MyContainer container = new MyContainer(AppConfig.class);

    // 이름으로 빈 조회
    Person gildong = (Person) container.getBean("gildong");
    gildong.sing();

    Person yumi = (Person) container.getBean("yumi");
    yumi.sing();
  }
}
