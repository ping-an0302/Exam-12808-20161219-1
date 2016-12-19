package com.hand.bean;

public class FilmText {

	private Long film_id;
	private String title;
	private String description;

	public FilmText() {}
	
	
	public FilmText(Long film_id, String title, String description) {
		this.film_id = film_id;
		this.title = title;
		this.description = description;
	}


	public Long getFilm_id() {
		return film_id;
	}

	public void setFilm_id(Long film_id) {
		this.film_id = film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
