/*package org.wecancodeit.reviews;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

public class ReviewRepositoryTest {
	ReviewRepository testRepo = new ReviewRepository();

	@Test
	public void addReviewsShouldAddReviewsToMap() {
		Review review = new Review(null, 999L, " ", " ", " ", " ");

		int reviewRepoSizeBeforeAdding = testRepo.getReviews().size();
		testRepo.addReview(review);
		int reviewRepoSizeAfterAdding = testRepo.getReviews().size();

		assertThat(reviewRepoSizeAfterAdding, is(equalTo(reviewRepoSizeBeforeAdding + 1)));
	}

	@Test
	public void findAllShouldReturnAllValues() {
		Collection<Review> underTest = testRepo.findAll();
		assertThat(underTest.size(), is(equalTo(3)));
	}

	@Test
	public void findAllShouldReturnReviews() {
		Collection<Review> underTest = testRepo.findAll();

		for (Review review : underTest) {
			assertTrue(review instanceof Review);
		}
	}

	@Test
	public void findOneShouldReturnReviewById() {
		Review underTest = testRepo.findById(0101L);
		assertThat(underTest.getTitle(), is(equalTo("Los Angeles Lakers")));
	}

}*/