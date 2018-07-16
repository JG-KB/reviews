package org.wecancodeit.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Lob
	private String userComment;
	
	@ManyToOne
	private Review review;
	
	
	public Comment() {
		
	}
	public Comment(String userComment, Review review) {
		this.userComment=userComment;
		this.review=review;
	}
	public String getUserComment() {
		return userComment;
	}
	
	@Override
	public String toString() {
		return userComment;
	}
	public Review getReview() {
		return review;
	}
	public Long getid() {
		return id;
	}
	
}
