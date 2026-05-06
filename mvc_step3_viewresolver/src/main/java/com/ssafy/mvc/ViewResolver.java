package com.ssafy.mvc;

public class ViewResolver {

    // TODO 3-01: prefix, suffix 필드 선언 (final String)
	final String prefix;
	final String suffix;
	
    // TODO 3-02: 생성자 — 외부에서 prefix, suffix를 주입받아 필드에 설정
	
	public ViewResolver(String prefix, String suffix) {
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
    public String resolve(String viewName) {
        // TODO 3-03: 논리적 View 이름을 물리적 경로로 변환 — prefix + "/" + viewName + suffix
        // - prefix + viewName + suffix
    	return prefix+viewName+suffix;
    }

}
