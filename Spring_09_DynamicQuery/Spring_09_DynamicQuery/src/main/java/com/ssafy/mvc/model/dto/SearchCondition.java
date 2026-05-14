package com.ssafy.mvc.model.dto;

/**
 * 게시글 검색·정렬 조건을 담는 DTO.
 *
 *  - key        : 검색 기준 (title / writer / content / none)
 *  - word       : 검색어
 *  - orderBy    : 정렬 기준 (title / writer / view_cnt / none)
 *  - orderByDir : 정렬 방향 (asc / desc)
 *
 *  ※ key, orderBy 가 "none" 이면 해당 조건을 적용하지 않는다.
 *    → 매퍼에서 <if test="key != 'none'"> 로 분기.
 */
public class SearchCondition {

	private String key;
	private String word;
	private String orderBy;
	private String orderByDir;

	public SearchCondition() {
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderByDir() {
		return orderByDir;
	}

	public void setOrderByDir(String orderByDir) {
		this.orderByDir = orderByDir;
	}

	@Override
	public String toString() {
		return "SearchCondition [key=" + key + ", word=" + word + ", orderBy=" + orderBy + ", orderByDir=" + orderByDir
				+ "]";
	}

}
