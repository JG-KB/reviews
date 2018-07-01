package org.wecancodeit.reviews;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewSitePopulatorTest {

	@Autowired
	CategoryRepository cRepoTest;
	
	@Test
	public void populatorShouldSaveAndLoadCategory() {
		Category testCategory = cRepoTest.save(new Category("test"));
		Category underTest = cRepoTest.findOne(1L);
		assertThat(underTest, is(equalTo(testCategory)));
	}
	
}
