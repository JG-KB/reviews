package org.wecancodeit.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewSiteController {
	
	
	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	ReviewRepository reviewRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	TagRepository tagRepo;

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
		return "category";
	}
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		return "index";
	}
	@RequestMapping("/tags")
	public String getTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}
	@RequestMapping("/tags/{name}")
	public String getTitleFromTag(@PathVariable(name = "name")String name, Model model) {
		model.addAttribute("tag", tagRepo.findByName(name));
		return "tag";
	}
	
	@RequestMapping(value="/reviews/{id}", method= RequestMethod.POST)
	public String addComment(@PathVariable(name="id")Long id,String userComment) {
		commentRepo.save(new Comment(userComment, reviewRepo.findOne(id)));
		return "redirect:/reviews/{id}";
	}
	
	
}
