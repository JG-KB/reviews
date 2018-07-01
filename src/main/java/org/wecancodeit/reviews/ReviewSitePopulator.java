package org.wecancodeit.reviews;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewSitePopulator implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ReviewRepository reviewRepo;
	

	@Override
	public void run(String... args) throws Exception {
		Category sports = categoryRepo.save(new Category("sports"));
		Category animals = categoryRepo.save(new Category("animals"));
		Category myLife= categoryRepo.save(new Category("myLife"));
		
		
		Review jaylenReviewOne = reviewRepo.save(new Review("Lebron the Free Agent", "/img/lebron.jpg", "Is Lebron going to join the L.A Lakers? I'm not too sure but it would be pretty raw if he did. I have been reading that it might be possible for a superteam to form in L.A for the Lakers. It is possible that Lebron, Kawhi Lenorad and Paul George can all land in L.A over the summer and wear the purple and gold. If those three linked up and have a good amount of role players on the team, I know that maybe a new team from the west will be going to the finals. In the NBA today, it is neccessary to have more than one superstar or  a team of guys who know how to play together in order to win the NBA championship. Lebron does not have enough help in Cleveland to win the championship again as the roster is now. The Cavs have alot of roster moves to make in order to frighten the Warriors and stay the Kings of the East. I hope the best for Lebron where ever he goes. I am a fan of players more than teams. If my favorite player is on that team then I am going to hope that team wins unless they are playing the Cavs or Browns or the Eagles, or Team USA for that matter. If the superteam in L.A has a chance to form I would love to see it, but if it doesn't have a chance then I hope Lebron stays in Cleveland. Regardless the Cavs have to move some people and get a better group of guys around Lebron if he stays.", sports));
		Review jaylenReviewTwo= reviewRepo.save(new Review("We Can Code It:", "/img/jaylen-can-code-it.jpg", " I am happy I am enrolled. I am learning alot and I am hopeful that everything sticks and I am able to create full stack websites. Overall I give the bootcamp life an A+. I wish I would have done this first instead of going to college. But anyways I have to build from the past in the present for the future!", myLife));
		Review jaylenReviewThree = reviewRepo.save(new Review("SnakeHead Fish:", "/img/snakeHead.jpg", "These things are invasive to the USA. Quite vicious too, real apex predators in these rivers and streams of North America. They can crawl on land and breath on land, I guess they can survive for a few days as long as there skin is wet. I heard that they are quite tasty. I'm a vegetarian but I would try this fish. I would try the fish because I heard it is good and tender, it has scales and fins and also because it is invasive to the USA. The snakehead fish doesn't have many natural predators in the USA beside humans and if it would come across a croc or gator or a bullshark. Look these fish up if your bored one day, they are quite the animal!",animals));
	}
}
