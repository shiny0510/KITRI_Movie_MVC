package Review;

import java.util.ArrayList;

public class ReviewServiceImpl implements ReviewService {
private ReviewDao dao;
	
	public ReviewServiceImpl(ReviewDao dao) {
		this.dao = dao;
	}
	@Override
	public void addReview(Review r) {
		// TODO Auto-generated method stub
		dao.insert(r);
	}

	@Override
	public void editReview(Review r) {
		// TODO Auto-generated method stub
		dao.update(r);
	}

	@Override
	public void delReview(int rno) {
		// TODO Auto-generated method stub
		dao.delete(rno);
	}

	@Override
	public Review getMovie(int rno) {
		// TODO Auto-generated method stub
		return dao.select(rno);
	}

	@Override
	public Review getAvgScore(int num) {
		// TODO Auto-generated method stub
		return dao.getAvgScore(num);
	}

	@Override
	public ArrayList<Review> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
	@Override
	public int makeReviewNum() {
		// TODO Auto-generated method stub
		return dao.makeReviewNum();
	}

}
