package org.wecancodeit.reviews;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="tags")
	private Collection <Review> reviews;
	
	public Tag() {
		
	}
	public Tag(String name, Review...reviews) {
		this.name=name;
		this.reviews=Arrays.asList(reviews);
	}

	public String getName() {
		return name;
	}
	
	public Long getId() {
		return id;
	}
	@JsonIgnore
	public Collection<Review> getReviews() {
		return reviews;
	}
	@Override
	public String toString() {
		return name;
	}

	
	
}
