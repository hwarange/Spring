-- =====================================================
-- data.sql : 샘플 데이터 삽입 스크립트
-- =====================================================

USE ssafydb;

-- 초기 샘플 데이터 삽입
INSERT INTO board (title, writer, content)
VALUES
  ('MyBatis 란?',       '홍길동', 'SQL 매핑 프레임워크입니다.'),
  ('Spring Boot 설정',  '이영희', 'pom.xml 의존성을 추가합니다.'),
  ('CRUD 실습 시작',    '박철수', 'Create/Read/Update/Delete');

-- 삽입 확인
SELECT * FROM board;
