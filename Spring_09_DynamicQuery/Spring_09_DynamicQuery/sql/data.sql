-- =====================================================
-- data.sql : 샘플 데이터 삽입 스크립트
--   ※ 9회차 동적 SQL/트랜잭션 실습을 위해 데이터 개수를 늘렸습니다.
--   ※ 검색/정렬 결과를 눈으로 확인할 수 있을 만큼 다양화했습니다.
-- =====================================================

USE ssafydb;

-- 기존 데이터 초기화 (선택)
-- TRUNCATE TABLE board;

-- 초기 샘플 데이터 삽입
INSERT INTO board (title, writer, content, view_cnt)
VALUES
  ('MyBatis 란?',             '홍길동', 'SQL 매핑 프레임워크입니다.',                 12),
  ('Spring Boot 설정',         '이영희', 'pom.xml 의존성을 추가합니다.',               7),
  ('CRUD 실습 시작',           '박철수', 'Create/Read/Update/Delete',                  3),
  ('동적 SQL 입문',            '홍길동', 'if, choose, foreach, where 등을 다룹니다.', 25),
  ('트랜잭션이란?',            '이영희', 'ACID 원칙을 보장하는 작업 단위입니다.',     18),
  ('@Transactional 어노테이션', '박철수', 'Spring AOP 기반으로 동작합니다.',            9),
  ('정렬 조건 동적 적용',       '김철수', 'ORDER BY 도 if 태그로 가능!',                15),
  ('foreach 로 IN 절 처리',     '김철수', '리스트를 받아 한 번에 조회합니다.',           4),
  ('CDATA 와 부등호',          '김영수', 'XML 엔티티 치환 vs CDATA 섹션',              22),
  ('Spring TX 실습',           '김영수', '@Transactional 적용 후 롤백 확인',           6);
