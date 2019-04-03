package Review;

import java.util.ArrayList;

public interface ReviewDao {
	void insert(Review r);

	void update(Review r);

	void delete(int rno);

	Review select(int rno); //����

	void deleteBypwd(String pwd, int rno); // �ڽ��� ���� ����

	Review getAvgScore(int num);
	
	ArrayList<Review> selectBynum(int num); // ��ȭ���̺� ���� ����Ʈ3

	ArrayList<Review> selectAll();
	
	int makeReviewNum();
}
