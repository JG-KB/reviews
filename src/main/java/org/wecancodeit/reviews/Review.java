package org.wecancodeit.reviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String imageUrl;
	@Lob
	private String content;
	
	
	@ManyToOne
	private Category category;
	
	public Review() {}
	
	public Review( String title, String imageUrl, String content, Category category) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.content = content;
		this.category=category;
		
	}


	public Category getCategory() {
		return category;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getContent() {
		return content;
	}

}	

