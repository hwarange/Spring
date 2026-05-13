package com.ssafy.board.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatisConfig : SqlSessionFactory 를 1회만 생성해 보관하는 헬퍼 클래스
 *
 * <p>MyBatis 핵심 객체 3종
 *   1) SqlSessionFactoryBuilder : Factory 를 만드는 "공장 건설자"
 *   2) SqlSessionFactory        : SqlSession 을 찍어내는 공장 (싱글톤)
 *   3) SqlSession               : SQL 실행 단위 (요청마다 생성/close)
 */
public class MyBatisConfig {

	private static SqlSessionFactory factory;

	// 클래스 로딩 시 단 한 번 실행되는 static 초기화 블록
	static {
		// TODO 1-04A: 설정파일의 classpath 경로(문자열)를 변수에 담기
		//             힌트: "mybatis-config.xml"
		String resource = "mybatis-config.xml";

		// TODO 1-04B: Resources.getResourceAsStream(resource) 로 InputStream 얻기
		//             try-with-resources 권장
		//             try (InputStream inputStream = ... ) { ... }
		try(InputStream inputStream = Resources.getResourceAsStream(resource)){
			
		
		// TODO 1-04C: try 블록 안에서 Factory 빌드
		//             힌트: factory = new SqlSessionFactoryBuilder().build(inputStream);
		//             성공 시 "공장 건설 성공!" 출력
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		}
		// TODO 1-04D: catch (IOException e) — 실패 메시지 출력 + e.printStackTrace()
		catch (IOException e) {
			System.out.println("공장 생성이 실패했습니다 ㅠㅠ");
			e.printStackTrace();
		}
		
	}

	/** 외부에서 공장(SqlSessionFactory) 객체를 얻을 때 사용 */
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
