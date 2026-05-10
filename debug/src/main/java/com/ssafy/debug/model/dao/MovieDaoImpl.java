package com.ssafy.debug.model.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ssafy.debug.model.dto.MovieDto;

@Component // 이 클래스를 Bean으로 등록
public class MovieDaoImpl implements MovieDao{
	private final Map<Integer, MovieDto> movieMap = new LinkedHashMap<>();
	private int sequence = 4;	//1씩 증가하는 ID
	
	// 기본적으로 3개를 넣어서 sequence가 4부터 시작
	public MovieDaoImpl() {
		movieMap.put(1, new MovieDto(1, "기생충", "봉준호", "드라마", 123, true));
		movieMap.put(2, new MovieDto(2, "bb", "bb", "bb", 123, true));
		movieMap.put(3, new MovieDto(3, "cc", "cc", "cc", 123, true));
	}
	
	// 클라이언트 -> movieDto가 만들어질 때는 movieId가 지정되지 않음
	// controller -> service -> dao
	
	@Override
	public int insertMovie(MovieDto movieDto) {
		movieDto.setMovieId(sequence++);
		movieMap.put(movieDto.getMovieId(), movieDto);
		return 1;
	}
	
	@Override
	public List<MovieDto> selectMovieList() {
		return new ArrayList<>(movieMap.values());
	}
	
	@Override
	public MovieDto selectMovieDetail(int movieId) {
		return movieMap.get(movieId);
	}
	
	@Override
	public int deleteMovie(int movieId) {
		return movieMap.remove(movieId) == null ? 0 : 1;
	}
	
	@Override
	public int updateMovie(MovieDto movieDto) {
		if(!movieMap.containsKey(movieDto.getMovieId()))
			return 0;
		movieMap.put(movieDto.getMovieId(), movieDto);
		return 1;
	}
}
