package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

/**
 * MyBatis 매퍼 인터페이스.
 *  - 각 메서드명은 BoardMapper.xml 의 <select>, <insert>, <update>, <delete> 의 id 속성과 일치해야 한다.
 */
public interface BoardDao {

	// ── 기본 CRUD (이미 완성) ───────────────────────────────────
	List<Board> selectAll();

	Board selectOne(int id);

	void insertBoard(Board board);

	void deleteBoard(int id);

	void updateBoard(Board board);

	void updateViewCnt(int id);

	// 03 : updateBoardDynamic(Board) 선언 (반환 void)
	void updateBoardDynamic(Board board);

	//  08 : deleteBoards(List<Integer> ids) 선언 (반환 int — 삭제된 행 수)
	int deleteBoards (List<Integer> ids);
	// TODO 15 : selectByMinViewCnt(int minViewCnt) 선언 (반환 List<Board>)

	// TODO 20 : search(SearchCondition condition) 선언 (반환 List<Board>)

}
