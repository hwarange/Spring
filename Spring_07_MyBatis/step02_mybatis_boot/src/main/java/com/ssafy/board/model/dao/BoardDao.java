package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Board;

/**
 * BoardDao : 게시판 데이터 접근(DAO) 인터페이스
 *
 * <p>MyBatis 3.x 부터는 DAO 인터페이스만 정의하면
 *    MyBatis 가 동적 프록시(Dynamic Proxy)로 구현체를 자동 생성해 준다.
 *    -> 우리는 구현체(impl 클래스)를 직접 작성하지 않는다.</p>
 *
 * <p>매핑 규칙
 *   1) 이 인터페이스의 FQCN  <->  Mapper XML 의 namespace
 *   2) 메서드 이름           <->  &lt;select&gt;/&lt;insert&gt;... 의 id 속성</p>
 */
public interface BoardDao {

	// TODO 1-03A: 전체 게시글 조회 — 메서드 이름은 selectAll
	List<Board> selectAll();

	// TODO 1-03B: 단건 조회 — selectOne, 파라미터는 id
	Board selectOne(int id);
	// TODO 1-03C: 게시글 등록 — insertBoard, 파라미터는 Board
	void insertBoard(Board board);
	// TODO 1-03D: 게시글 삭제 — deleteBoard, 파라미터는 id
	void deleteBoard(int id);
	// TODO 1-03E: 게시글 수정 — updateBoard, 파라미터는 Board
	void updateBoard(Board board);
	// TODO 1-03F: 조회수 1 증가 — updateViewCnt, 파라미터는 id
	void updateViewCnt(int id);
}
