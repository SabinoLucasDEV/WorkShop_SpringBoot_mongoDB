package com.sabino.WorkShop.DTO;

import java.util.Date;

public class ComentDTO {
	
	private String text;
	private Date date;
	private AuthorDTO author;
	
	
	public ComentDTO() {}


	public ComentDTO(String text, Date date, AuthorDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public AuthorDTO getAuthor() {
		return author;
	}


	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	

}
