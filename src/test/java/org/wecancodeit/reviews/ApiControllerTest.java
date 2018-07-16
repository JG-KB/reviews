package org.wecancodeit.reviews;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiControllerTest {

	@Resource
	TestRestTemplate restTemplate;
	
	@Test
	public void canary() {
		ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test
	public void shouldBeOkForReviews() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/reviews", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test
	public void shouldBeOkForCategories() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/categories", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
	@Test
	public void shouldBeOkForTags() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/tags", String.class);
		HttpStatus status = response.getStatusCode();
		assertThat(status, is(HttpStatus.OK));
	}
}