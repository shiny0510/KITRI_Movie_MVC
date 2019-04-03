package Review;

import java.util.ArrayList;

public interface ReviewService {
	void addReview(Review r);

	void editReview(Review r);

	void delReview(int rno);

	Review getMovie(int rno); 

	Review getAvgScore(int num);

	ArrayList<Review> getAll();
	
	int makeReviewNum();
}
