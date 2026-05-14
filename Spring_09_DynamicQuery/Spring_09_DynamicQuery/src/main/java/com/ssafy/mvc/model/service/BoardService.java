package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

public interface BoardService {

	// ── 기본 CRUD ───────────────────────────────────────────────
	List<Board> getBoardList();

	Board readBoard(int id);              // 조회수 +1

	void writeBoard(Board board);

	void removeBoard(int id);

	void modifyBoard(Board board);

	Board getBoard(int id);               // 조회수 증가 없이 (수정 폼용)

	// ── 동적 SQL ────────────────────────────────────────────────
	List<Board> search(SearchCondition condition);

	void modifyBoardDynamic(Board board);

	int removeBoards(List<Integer> ids);

	List<Board> getPopularBoards(int minViewCnt);

	// ── 트랜잭션 시연 ─────────────────────────────────────────────
	Board readBoardWithRollback(int id, boolean shouldFail);
}
