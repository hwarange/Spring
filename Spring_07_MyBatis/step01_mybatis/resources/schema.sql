-- =====================================================
-- schema.sql : DB 및 테이블 생성 스크립트
-- 실행 위치 : MySQL Workbench 또는 CLI
-- =====================================================

-- 1. 데이터베이스 생성 (이미 있으면 생략)
CREATE DATABASE IF NOT EXISTS ssafydb DEFAULT CHARACTER SET utf8mb4;

-- 2. 데이터베이스 선택
USE ssafydb;

-- 3. board 테이블 생성
--    - id        : PK (auto_increment)
--    - title     : 제목 (NOT NULL)
--    - writer    : 작성자 (NOT NULL)
--    - content   : 본문 (TEXT)
--    - reg_date  : 등록일 (default 현재 시각)  <- snake_case
--    - view_cnt  : 조회수 (default 0)         <- snake_case
CREATE TABLE IF NOT EXISTS board
  (
     id       INT auto_increment PRIMARY KEY,
     title    VARCHAR(100) NOT NULL,
     writer   VARCHAR(50)  NOT NULL,
     content  TEXT,
     reg_date TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
     view_cnt INT          DEFAULT 0
  );
