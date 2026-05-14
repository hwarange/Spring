package com.ssafy.mvc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis 설정 클래스.
 *
 * @MapperScan : 지정한 패키지 하위의 인터페이스를 자동으로 스캔하여
 *               Mapper 빈(Bean)으로 등록한다.
 *               (각 인터페이스마다 @Mapper 를 붙이지 않아도 됨)
 */
@Configuration
@MapperScan(basePackages = "com.ssafy.mvc.model.dao")
public class MyBatisConfig {

}
