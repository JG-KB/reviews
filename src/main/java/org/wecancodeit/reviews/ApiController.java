package org.wecancodeit.reviews;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	ReviewRepository reviewRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	TagRepository tagRepo;
	
	
	@RequestMapping("/reviews")
	public Collection<Review> getReviews() {
		return(Collection<Review>) reviewRepo.findAll();
	}
	@RequestMapping("/reviews/{title")
	public Review getReview (@PathVariable(name="title")String title) {
		return reviewRepo.findByTitle(title);
	}
	@RequestMapping("/reviews/{id}/comments")
		public Collection<Comment> getReviewComments(@PathVariable(name="id")Long id) {
			return (Collection<Comment>) reviewRepo.findOne(id).getComments();
	}
	@RequestMapping(value = "/reviews/{title}/{name}", method = RequestMethod.DELETE)
	public Collection<Tag> tagToDeleteFromReview(@PathVariable(name="title")String title, @PathVariable(value="name")String name) {
			Tag tagToBeDeleted = tagRepo.findByName(name);
			reviewRepo.findAll().forEach(review ->review.getTags().remove(tagToBeDeleted));
			tagRepo.delete(tagToBeDeleted.getId());
			return reviewRepo.findByTitle(title).getTags();
	}
	@RequestMapping(value = "/tags/{name}", method = RequestMethod.DELETE)
		public Collection<Tag> deleteTag(@PathVariable(value = "name") String name) {
			Tag tagToDelete = tagRepo.findByName(name);
			for (Review review : reviewRepo.findAll()) {
				if (review.getTags().contains(tagToDelete)) {
					review.getTags().remove(tagToDelete);
				}
			}
			tagRepo.delete(tagToDelete.getId());
			return (Collection<Tag>) tagRepo.findAll();
		}
//	@RequestMapping(value="/reviews/{id}", method= RequestMethod.POST)
//	public String addTag(@PathVariable(name="id") Long id, String name) {
//		if (tagRepo.findByName(name) == null) {
//			tagRepo.save(new Tag(name));
//		}else {
//			tagRepo.findByName(name);
//		}
//		return "redirect:/reviews/{id}";
//}
	
}
