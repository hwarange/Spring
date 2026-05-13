package com.ssafy.board.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.config.MyBatisConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

/**
 * Test : 순수 자바 환경에서 MyBatis CRUD 가 동작하는지 검증하는 실행 진입점.
 */
public class Test {

	public static void main(String[] args) {

		// TODO 1-05A: SqlSession 획득
		//             힌트: MyBatisConfig.getFactory().openSession(true)
		//             - 인자 true 는 autoCommit 모드 (INSERT/UPDATE/DELETE 자동 커밋)
		SqlSession session = MyBatisConfig.getFactory().openSession(true);

		// TODO 1-05B: BoardDao 동적 프록시 획득
		//             힌트: session.getMapper(BoardDao.class)
		BoardDao dao = session.getMapper(BoardDao.class);

		// ===== CRUD 시연 (필요한 부분만 주석을 풀어 실행해 보세요) =====

		// (1) 전체 게시글 조회
		 System.out.println("===== 전체 게시글 조회 =====");
		 for (Board board : dao.selectAll()) {
		 	System.out.println(board);
		 }

		// (2) 단건 조회
		// System.out.println(dao.selectOne(1));

		// (2-1) MyBatis 2.x 스타일 — namespace + id 를 문자열로 호출
		//       (3.x 의 dao.selectOne(1) 과 같은 결과를 옛날 방식으로)
		// Board legacy = session.selectOne("com.ssafy.board.model.dao.BoardDao.selectOne", 1);
		// System.out.println("[2.x] " + legacy);

		// (3) 게시글 등록
		// Board newBoard = new Board("점심 코스 뭐 먹지?", "김철수", "A코스 먹을래!");
		// dao.insertBoard(newBoard);

		// (4) 게시글 수정
		// Board target = dao.selectOne(3);
		// target.setContent("아니 사실은 B코스!");
		// dao.updateBoard(target);

		// (5) 조회수 증가
		// dao.updateViewCnt(1);

		// (6) 게시글 삭제
		// dao.deleteBoard(3);

		// TODO 1-05C: session 자원 반납 (반드시!)
		//             힌트: session.close();
		 session.close();
	}
}
