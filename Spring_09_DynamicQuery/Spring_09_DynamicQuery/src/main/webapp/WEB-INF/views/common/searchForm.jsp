<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- TODO 19A (완성본 제공)
  list.jsp 에서 <%@ include %> 로 포함되는 검색 폼입니다.
  시간 절약을 위해 미리 작성되어 있습니다. 아래 포인트를 코드에서 직접 확인하세요.

  ① form action="search" method="GET" — 검색은 GET 으로 보내는 이유는?
     (URL 에 조건이 노출 → 북마크/공유 가능 → 검색의 본질)
  ② name="key", name="word", name="orderBy", name="orderByDir"
     → SearchCondition DTO 의 필드명과 일치해야
       컨트롤러 @ModelAttribute 가 자동 매핑됨!
  ③ <option value="none"> — 매퍼의 <if test="key != 'none'"> 와 짝
  ④ orderBy 의 value 가 "view_cnt" (snake_case) 인 이유?
     → ORDER BY 는 DB 컬럼명으로 정렬하므로 snake_case 가 맞음
--%>
<form action="search" method="GET" class="row lh-base my-3">
	<div class="col-2">
		<label class="form-label">검색기준</label>
		<select class="form-select" name="key">
			<option value="none" selected="selected">없음</option>
			<option value="writer">쓰니</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
	</div>
	<div class="col-5">
		<label class="form-label">검색 내용</label>
		<input type="text" name="word" class="form-control">
	</div>
	<div class="col-2">
		<label class="form-label">정렬기준</label>
		<select class="form-select" name="orderBy">
			<option value="none" selected="selected">없음</option>
			<option value="writer">쓰니</option>
			<option value="title">제목</option>
			<option value="view_cnt">조회수</option>
		</select>
	</div>
	<div class="col-2">
		<label class="form-label">정렬방향</label>
		<select class="form-select" name="orderByDir">
			<option value="asc">오름차순</option>
			<option value="desc">내림차순</option>
		</select>
	</div>
	<div class="col-1 d-flex align-items-end">
		<input type="submit" value="검색" class="btn btn-primary">
	</div>
</form>
