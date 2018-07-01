package org.wecancodeit.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewSiteController {

	@Autowired
	ReviewRepository reviewRepo;
	
	@Autowired
	CategoryRepository categoryRepo;

	@RequestMapping("/reviews")
	public String getReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/reviews/{id}")
	public String getReview(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		return "review";
	}
	
	@RequestMapping("/categories")
	public String getCategories(Model model ) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
}
	@RequestMapping("/categories/{id}")
	public String getCategory(@PathVariable(name= "id") Long id, Model model) {
		model.addAttribute("category", categoryRepo.findOne(id));
		return "categories";
	}
}
