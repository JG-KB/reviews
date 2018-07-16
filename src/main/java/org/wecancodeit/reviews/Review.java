package org.wecancodeit.reviews;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String imageUrl;
	@Lob
	private String content;
	
	@ManyToMany
	private Collection <Tag> tags;
	
	@ManyToOne
	private Category category;
	
	@JsonIgnore
	@OneToMany(mappedBy="review")
	private Collection<Comment> comments;
	
	public Review() {}
	
	public Review( String title, String imageUrl, String content, Category category, Tag...tags) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.content = content;
		this.category=category;
		this.tags = Arrays.asList(tags);
	
		
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
	
	public Collection<Tag> getTags() {
		return tags;
	}
	
	public Collection<Comment> getComments() {
		return comments;
	}

	@Override
	public String toString() {
		return "Review:" + title;
	}
	
}	

