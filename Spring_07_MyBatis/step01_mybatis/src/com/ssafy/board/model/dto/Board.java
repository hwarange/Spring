package com.ssafy.board.model.dto;

/**
 * Board DTO (Data Transfer Object)
 * - board 테이블의 한 행(row)을 표현하는 POJO 클래스
 * - DB 컬럼명(snake_case)과 자바 필드명(camelCase)이 다름에 유의
 *   ex) reg_date -> regDate, view_cnt -> viewCnt
 *   -> BoardMapper.xml 의 resultMap 또는 SELECT 별칭으로 매핑 처리
 */
public class Board {
	private int id;
	private String title, writer, content;
	private String regDate;   // DB 컬럼: reg_date  (snake_case <-> camelCase 불일치)
	private int viewCnt;      // DB 컬럼: view_cnt  (snake_case <-> camelCase 불일치)

	public Board() {
	}

	// 게시글 등록용 생성자 (id, regDate, viewCnt 는 DB 가 자동 채움)
	public Board(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public Board(int id, String title, String writer, String content, String regDate, int viewCnt) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getWriter() { return writer; }
	public void setWriter(String writer) { this.writer = writer; }

	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }

	public String getRegDate() { return regDate; }
	public void setRegDate(String regDate) { this.regDate = regDate; }

	public int getViewCnt() { return viewCnt; }
	public void setViewCnt(int viewCnt) { this.viewCnt = viewCnt; }

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", regDate=" + regDate
				+ ", viewCnt=" + viewCnt + "]";
	}
}
