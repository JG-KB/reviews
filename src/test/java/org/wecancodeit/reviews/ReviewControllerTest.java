package org.wecancodeit.reviews;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)

public class ReviewControllerTest {

	@Resource
	MockMvc mvc;

	@MockBean
	ReviewRepository repo;

	@Mock
	Review review;

	@Test
	public void getReviewsShouldReturnReviewsView() throws Exception {
		mvc.perform(get("/reviews")).andExpect(view().name(is(equalTo("reviews"))));
	}

	@Test
	public void getReviewsShouldBeOk() throws Exception {
		mvc.perform(get("/reviews")).andExpect(status().is2xxSuccessful());
	}

	@Test
	public void getReviewsShouldReturnAllCourses() throws Exception {
		mvc.perform(get("reviews")).andExpect(model().attribute("reviews", is(repo.findAll())));
	}

	@Test
	public void getReviewShouldReturnReviewsView() throws Exception {
		mvc.perform(get("/reviews/0")).andExpect(view().name(is(equalTo("reviews"))));
	}

	@Test
	public void getReviewShouldBeOk() throws Exception {
		mvc.perform(get("/reviews/0")).andExpect(status().is2xxSuccessful());
	}

	@Test
	public void getReviewShouldReturnOneReview() throws Exception {
		mvc.perform(get("/reviews/0")).andExpect(model().attribute("review", is(repo.findById(0L))));
	}
}
