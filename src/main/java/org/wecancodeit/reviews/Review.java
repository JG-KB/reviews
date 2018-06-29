package org.wecancodeit.reviews;

import java.util.ArrayList;

public class Review {
	private long id;
	private String title;
	private String imageUrl;
	private String reviewCategory;
	private String content;
	private ArrayList<Tag> tags;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getReviewCategory() {
		return reviewCategory;
	}

	public String getContent() {
		return content;
	}

	public Review(ArrayList<Tag> tags, Long id, String title, String imageUrl, String reviewCategory, String content) {
		super();
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.reviewCategory = reviewCategory;
		this.content = content;
		this.tags=tags;
	}
}
