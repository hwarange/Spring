package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
// TODO 24 : org.springframework.transaction.annotation.Transactional import 추가

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

@Service
// TODO 25 : 클래스 위에 @Transactional 추가 (모든 public 메서드에 기본 트랜잭션 적용)
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	// TODO 26 : 아래 메서드 위에 @Transactional(readOnly = true) 추가
	@Override
	public List<Board> getBoardList() {
		System.out.println("게시글 전체 목록");
		return boardDao.selectAll();
	}

	// (readBoard 는 조회수 +1 이 일어나므로 readOnly 가 아닌 일반 트랜잭션이어야 함)
	@Override
	public Board readBoard(int id) {
		System.out.println("게시글 상세 조회");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성");
		boardDao.insertBoard(board);
	}

	@Override
	public void removeBoard(int id) {
		System.out.println("게시글 삭제");
		boardDao.deleteBoard(id);
	}

	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글 수정");
		boardDao.updateBoard(board);
	}

	// TODO 27 : 아래 메서드 위에 @Transactional(readOnly = true) 추가
	@Override
	public Board getBoard(int id) {
		return boardDao.selectOne(id);
	}

	// TODO 28 : 아래 메서드 위에 @Transactional(readOnly = true) 추가
	// TODO 21 : boardDao.search(condition) 결과 반환
	@Override
	public List<Board> search(SearchCondition condition) {
		System.out.println("게시글 검색 조건: " + condition);
		return null;
	}

	//  04 : boardDao.updateBoardDynamic(board) 호출
	@Override
	public void modifyBoardDynamic(Board board) {
		System.out.println("게시글 부분 수정: " + board);
		boardDao.updateBoardDynamic(board);
	}

	// TODO 09 : ids 가 null 이거나 비어 있으면 0 반환, 아니면 boardDao.deleteBoards(ids) 호출 결과 반환
	//          (빈 IN() 절은 SQL 오류를 일으키므로 서비스 단에서 가드!)
	@Override
	public int removeBoards(List<Integer> ids) {
		System.out.println("게시글 다건 삭제 대상 ID: " + ids);
		if(ids == null || ids.size() == 0)
			return 0;
		return boardDao.deleteBoards(ids);
	}

	// TODO 29 : 아래 메서드 위에 @Transactional(readOnly = true) 추가
	// TODO 16 : boardDao.selectByMinViewCnt(minViewCnt) 결과 반환
	@Override
	public List<Board> getPopularBoards(int minViewCnt) {
		System.out.println("인기 게시글 조회 (조회수 >= " + minViewCnt + ")");
		return null;
	}

	// TODO 30 : 트랜잭션 롤백 시연 메서드 구현
	//   1) boardDao.updateViewCnt(id) 로 조회수 +1
	//   2) shouldFail == true 이면 RuntimeException 던지기
	//      → 클래스 위 @Transactional 이 잘 동작한다면 위 조회수 증가도 rollback 됨
	//   3) shouldFail == false 이면 boardDao.selectOne(id) 결과 반환
	@Override
	public Board readBoardWithRollback(int id, boolean shouldFail) {
		System.out.println("[TX 시연] readBoardWithRollback 호출 - id=" + id + ", shouldFail=" + shouldFail);
		return null;
	}

}
