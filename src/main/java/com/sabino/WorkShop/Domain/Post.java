package com.sabino.WorkShop.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sabino.WorkShop.DTO.AuthorDTO;
import com.sabino.WorkShop.DTO.ComentDTO;

@Document
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private AuthorDTO author;
	private Date date;
	private String title;
	private String body;
	
	List<ComentDTO> coments = new ArrayList<>();
	
	
	public Post() {}

	public Post(String id, AuthorDTO author, Date date, String title, String body) {
		super();
		this.id = id;
		this.author = author;
		this.date = date;
		this.title = title;
		this.body = body;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	

	public List<ComentDTO> getComents() {
		return coments;
	}

	public void setComents(List<ComentDTO> coments) {
		this.coments = coments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

	
}
