package com.ssafy.board;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * BoardApplication : Spring Boot 진입점.
 *
 * <p>Mapper Bean 등록 방법 두 가지
 *   1) @MapperScan("패키지명") : 일괄 등록 (이 클래스에 어노테이션 1개)
 *   2) 각 DAO 인터페이스에 @Mapper : 개별 등록
 *
 *  이 프로젝트는 1) 방식을 채택할 예정.
 */
@SpringBootApplication
@MapperScan("com.ssafy.board.model.dao")
// TODO 2-02A: @MapperScan 으로 DAO 인터페이스가 위치한 패키지 지정
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}
}
