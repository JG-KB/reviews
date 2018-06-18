package org.wecancodeit.reviews;

public class Review {
	private long id;
	private String title;
	private String imageUrl;
	private String reviewCategory;
	private String content;

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

	public Review(Long id, String title, String imageUrl, String reviewCategory, String content) {
		super();
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.reviewCategory = reviewCategory;
		this.content = content;
	}
}
