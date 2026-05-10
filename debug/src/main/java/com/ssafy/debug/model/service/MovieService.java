package com.ssafy.debug.model.service;

import java.util.List;

import com.ssafy.debug.model.dto.MovieDto;

// dao의 메서드는 sql과 1대1 대응
// service의 메서드는 controller의 요청에 대응
// service 메서드명: 비즈니스 로직에 맞게

public interface MovieService {
	int registMovie(MovieDto movieDto);
	List<MovieDto> getMovieList();
	MovieDto getMovieDetail(int movieId);
	int deleteMovie(int movieId);
	int updateMovie(MovieDto movieDto);
}
