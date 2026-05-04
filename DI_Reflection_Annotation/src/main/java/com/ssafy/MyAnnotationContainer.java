package com.ssafy;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 애노테이션 기반 동적 스캔 컨테이너 (필드 주입만 지원)
// 지정한 패키지에서 @MyComponent 클래스를 자동으로 찾아 빈으로 등록하고,
// @MyAutowired 필드에 의존성을 주입한다.
// 스프링 @ComponentScan + @Autowired 의 동작 원리와 동일
public class MyAnnotationContainer {

	// 빈 저장소: 타입 → 객체
	private final Map<Class<?>, Object> beanMap = new HashMap<>();

	public MyAnnotationContainer(String basePackage) {

		// 1단계: 패키지명 → 폴더 경로 변환 ("com.ssafy" → "com/ssafy")
		String path = basePackage.replace('.', '/');
		System.out.println("[1단계] 스캔 경로 변환: " + basePackage + " → " + path);

		// 2~3단계: classpath에서 패키지 디렉토리를 찾고 .class 파일 목록 수집
		//   getResources() = classpath 전체에서 해당 경로를 모두 반환 (test-classes, classes 등)
		List<String> classNames = new ArrayList<>();
		try {
			Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(path);
			while (resources.hasMoreElements()) {
				File dir = new File(resources.nextElement().toURI());
				System.out.println("[2단계] 스캔 디렉토리: " + dir.getAbsolutePath());
				File[] files = dir.listFiles();
				if (files == null) continue;
				for (File file : files) {
					if (file.getName().endsWith(".class")) {
						String name = basePackage + "." + file.getName().replace(".class", "");
						if (!classNames.contains(name)) {
							classNames.add(name);
							System.out.println("[3단계] 클래스 발견: " + name);
						}
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("패키지 스캔 실패: " + basePackage, e);
		}

		// 4~5단계: @MyComponent 클래스를 빈으로 등록
		//   Class.forName()  = 문자열로 클래스를 실행 중에 동적으로 불러옴 (리플렉션)
		//   newInstance()    = 기본 생성자로 객체 자동 생성
		for (String name : classNames) {
			try {
				Class<?> clazz = Class.forName(name);
				if (clazz.isAnnotationPresent(MyComponent.class)) {
					beanMap.put(clazz, clazz.getDeclaredConstructor().newInstance());
					System.out.println("[4~5단계] 빈 등록: " + clazz.getSimpleName());
				}
			} catch (Exception e) { /* 인터페이스·애노테이션 등 인스턴스화 불가 클래스 무시 */ }
		}

		// 6단계: 등록된 모든 빈의 @MyAutowired 필드에 의존성 주입
		beanMap.values().forEach(this::injectDependencies);

		System.out.println("[완료] 빈 " + beanMap.size() + "개 등록 완료");
	}

	// @MyAutowired 필드를 찾아 beanMap에서 맞는 빈을 주입
	private void injectDependencies(Object bean) {
		for (Field field : bean.getClass().getDeclaredFields()) {
			if (!field.isAnnotationPresent(MyAutowired.class)) continue;

			Object dependency = beanMap.get(field.getType());
			if (dependency == null)
				throw new RuntimeException("주입할 빈 없음: " + field.getType().getSimpleName());

			try {
				field.setAccessible(true);  // private 필드 접근 허용
				field.set(bean, dependency);
				System.out.println("[6단계] 주입: " + bean.getClass().getSimpleName()
					+ "." + field.getName() + " ← " + dependency.getClass().getSimpleName());
			} catch (Exception e) {
				throw new RuntimeException("필드 주입 실패: " + field.getName(), e);
			}
		}
	}

	// 스프링 getBean()과 동일: 타입으로 빈을 꺼낸다
	@SuppressWarnings("unchecked")
	public <T> T getBean(Class<T> type) {
		Object bean = beanMap.get(type);
		if (bean == null)
			throw new RuntimeException("등록된 빈 없음: " + type.getSimpleName());
		return (T) bean;
	}

	public void printBeans() {
		System.out.println("=== 등록된 빈 목록 (총 " + beanMap.size() + "개) ===");
		beanMap.forEach((type, bean) ->
			System.out.println("  [" + type.getSimpleName() + "] → " + bean.getClass().getSimpleName())
		);
	}
}
