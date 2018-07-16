package org.wecancodeit.reviews;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


public interface ReviewRepository extends CrudRepository <Review, Long> {
	Review findByTitle(String title);

}

	