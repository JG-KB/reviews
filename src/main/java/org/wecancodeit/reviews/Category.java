package org.wecancodeit.reviews;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="category")
	Collection<Review>reviews;

	public Category() {}
	
	public Category (String name, Review... reviews) {
		this.name=name;
		this.reviews=Arrays.asList(reviews);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
