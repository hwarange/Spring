package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;

/**
 * BoardService : 비즈니스 로직 계층 인터페이스.
 *
 *  - getXxx / removeXxx 등 "행위 의도" 가 드러나는 이름을 사용해
 *    DAO 의 selectXxx 계열과 차별화한다.
 */
public interface BoardService {

	/** 전체 게시글 목록 조회 */
	List<Board> getBoardList();

	/** 단건 조회 (조회수 +1 포함) */
	Board getBoard(int id);

	/** 게시글 등록 */
	void writeBoard(Board board);

	/** 게시글 삭제 */
	void removeBoard(int id);

	/** 게시글 수정 */
	void modifyBoard(Board board);
}
