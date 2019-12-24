package Dao;

import java.util.ArrayList;
import java.util.List;

import VO.BookRatingVO;

public class BookRatingDao {
	public static List<BookRatingVO> BookRatingList=new ArrayList<>();
    static {
    	
    	BookRatingVO bookRating = new BookRatingVO();
    	bookRating.setScore(10);
    	bookRating.setComment("유익하네요!");
    	bookRating.setBookName("자바의 정석");
    	BookRatingList.add(bookRating);
    	
    	BookRatingVO bookRating1 = new BookRatingVO();
    	bookRating1.setScore(1);
    	bookRating1.setComment("너무 어려워 ㄷㄷㄷ");
    	bookRating1.setBookName("자바의 정석");
    	BookRatingList.add(bookRating1);
 
    }
	public void bookRating() {
		//평점 실행하는 메서드
	int sum=0;
	int cnt=0;
	int searchIdx=-1;
	double startRating=0;
		for(int i=0;i<BookRatingList.size();i++){
			for(int j=0;j<BookDao.BookList.size();j++){
				if(BookRatingList.get(i).getBookName().equals(BookDao.BookList.get(j).getName())){
				   sum+=	BookRatingList.get(i).getScore();
				   cnt++;
				   searchIdx=i;
				   System.out.println(BookRatingList.get(i).getBookName());
				}
			  }			
		}
		/*double avg = (double)sum/cnt;
		System.out.println("평점 : "+(double)sum/cnt);
		
		for(int i =0;i<sum/cnt/2;i++){
			System.out.print("★");
		}
		if((sum/cnt)%2 == 1){
			System.out.print("☆");
		}System.out.println();*/
		
		startRating=sum/(double)cnt;
		for(int i=0;i<BookRatingList.size();i++){
			BookRatingVO bookRating = new BookRatingVO();
	    	bookRating.setScore(startRating);
	    /*	bookRating.setComment("재밌어요");
	    	bookRating.setBookName("자바의 정석");
        */  BookRatingList.set(i, bookRating);
          System.out.println(BookRatingList.get(i).getScore());
		}
		
		
	}
	

}