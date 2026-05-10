package com.ssafy.debug.model.dto;

public class MovieDto {
	private int movieId;
	private String title;
	private String director;
	private String genre;
	private int runningTime;
	private boolean released;


	//기본생성자
	public MovieDto() {
		// TODO Auto-generated constructor stub
	}


	public MovieDto(int movieId, String title, String director, String genre, int runningTime, boolean released) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
		this.released = released;
	}


	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getRunningTime() {
		return runningTime;
	}


	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}


	public boolean isReleased() {
		return released;
	}


	public void setReleased(boolean released) {
		this.released = released;
	}


	@Override
	public String toString() {
		return "MovieDto [movieId=" + movieId + ", title=" + title + ", director=" + director + ", genre=" + genre
				+ ", runningTime=" + runningTime + ", released=" + released + "]";
	}
	


}


