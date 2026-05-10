package com.ssafy.debug.model.dao;

import java.util.List;

import com.ssafy.debug.model.dto.MovieDto;

//Dao: DB에 접근하는 객체
//dao의 메서드들은 보통 sql쿼리와 1:1대응
public interface MovieDao {
	int insertMovie(MovieDto movieDto);
	// INSERT INTO movie (movie_id, title, director, genre, runningTime, released) VALUES (?, ?, ?, ?, ?, ?)
	// 메서드에서 구현할 것: dto가 주어지면 dto에서 값을 꺼내서 sql 쿼리문 완성하고 쿼리를 수행하는 역할
	// executeUpdate()의 경우에는 적용된 행의 개수를 반환
	// 업데이트가 1개 됐으면 1을 반환, 안됐으면 0을 반환
	List<MovieDto> selectMovieList();
	MovieDto selectMovieDetail(int movieId);
	int deleteMovie(int movieId);
	int updateMovie(MovieDto movieDto);
}
