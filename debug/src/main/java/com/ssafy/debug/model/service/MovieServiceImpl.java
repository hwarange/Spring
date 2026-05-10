package com.ssafy.debug.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.debug.model.dao.MovieDao;
import com.ssafy.debug.model.dto.MovieDto;

public class MovieServiceImpl implements MovieService{
	/*
	@Component 이 클래스를 빈으로 등록
	public class MovieDaoImpl implements MovieDao
	
	@Service
	public class MovieServiceImpl implements MovieService
	
	스프링이 시작하면서 @Component, @Service -> 어노테이션이 붙어있는 클래스는
	미리 객체를 생성하는 빈으로 만들어서 컨테이너 안에 준비를 해놓는다.
	
	MovieDaoImpl 클래스로 만든 MovieDao 타입의 객체
	
	MovieServiceImpl 객체는 MovieDao 타입의 객체가 필요
	스프링이 의존성 주입
	
	@Autowired : 알아서 넣어줘
	컨테이너 안에 있는 빈 중에서 해당 타입의 빈(객체)를 알아서 찾아서 넣어줌
	
	*/
	
	@Autowired
	private MovieDao movieDao;
	
	@Override
	public int registMovie(MovieDto movieDto) {
		return movieDao.insertMovie(movieDto);
	}
	
	@Override
	public List<MovieDto> getMovieList() {
		return movieDao.selectMovieList();
	}
	
	@Override
	public MovieDto getMovieDetail(int movieId) {
		return movieDao.selectMovieDetail(movieId);
	}
	
	@Override
	public int deleteMovie(int movieId) {
		return movieDao.deleteMovie(movieId);
	}
	
	@Override
	public int updateMovie(MovieDto movieDto) {
		return movieDao.updateMovie(movieDto);
	}
	
}
