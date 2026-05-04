package com.ssafy.live;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingTest {
	//우리가 로깅을 찍기위한 log 객체를 생성
	private static final Logger Log = LoggerFactory.getLogger(LoggingTest.class);
	
	public static void main(String[] args) {
		//다양한 로그 레벨로 메세지를 출력
		
		Log.trace("trace: {}", "트레이스 레벨 출력");
		Log.debug("debug: {}", "디버그 레벨 출력");
		Log.info("info: {}", "인포 레벨 출력");
		Log.warn("warn: {}", "워닝 레벨 출력");
		Log.error("error: {}", "에러 레벨 출력");
	}
}
