package Review;

import java.util.ArrayList;

public interface ReviewDao {
	void insert(Review r);

	void update(Review r);

	void delete(int rno);

	Review select(int rno); //평점

	void deleteBypwd(String pwd, int rno); // 자신의 리뷰 삭제

	Review getAvgScore(int num);
	
	ArrayList<Review> selectBynum(int num); // 영화테이블 종속 셀렉트3

	ArrayList<Review> selectAll();
	
	int makeReviewNum();
}
