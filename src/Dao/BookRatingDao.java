package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VO.BookRatingVO;
import VO.LoginSessionVO;

public class BookRatingDao {
	public static List<BookRatingVO> BookRatingList=new ArrayList<>();
    static {
    	
    	BookRatingVO bookRating = new BookRatingVO();
    	bookRating.setScore(10);
    	bookRating.setComment("유익하네요!");
    	bookRating.setBookName("자바의 정석");
    	bookRating.setUserId("a");
    	BookRatingList.add(bookRating);
    	
    	BookRatingVO bookRating1 = new BookRatingVO();
    	bookRating1.setScore(1);
    	bookRating1.setComment("너무 어려워 ㄷㄷㄷ");
    	bookRating1.setBookName("자바의 정석");
    	bookRating1.setUserId("a");
    	BookRatingList.add(bookRating1);
    	
    	BookRatingVO bookRating2 = new BookRatingVO();
    	bookRating2.setScore(7);
    	bookRating2.setComment("유용하네요!");
    	bookRating2.setBookName("옥스토비의 일반화학");
    	bookRating2.setUserId("a");
    	BookRatingList.add(bookRating2);
 
    }
	public void bookRating() {
		//평점 실행하는 메서드
	String bookName = "";
	int sum=0;
	int cnt=0;
	int searchIdx=-1;
	double startRating=0;
	
	
		for(int i=0;i<BookRatingList.size();i++){
			for(int j=0;j<BookDao.BookList.size();j++){
				if(BookRatingList.get(i).getBookName().equals(BookDao.BookList.get(j).getName())){
				   sum +=	BookRatingList.get(i).getScore();
				   cnt++;
				   searchIdx=i;
				}
			  }	bookName = BookRatingList.get(i).getBookName();	
		}
		System.out.println(sum);
		System.out.println(cnt);
		double avg = (double)sum/cnt;
		System.out.println("==================================");

		System.out.println(bookName);
		System.out.print("총평점 : "+(double)sum/cnt + "  ");
		for(int i =0;i<sum/cnt/2;i++){
			System.out.print("★");
		}
		if((sum/cnt)%2 == 1){
			System.out.print("☆");
		}System.out.println();

		
		/*startRating= ((int)(sum/(double)cnt*10+0.5))/10.0;
		for(int i=0;i<BookRatingList.size();i++){
			BookRatingVO bookRating = new BookRatingVO();
	    	bookRating.setScore(startRating);
	    	bookRating.setComment("재밌어요");
	    	bookRating.setBookName("자바의 정석");
          BookRatingList.set(i, bookRating);
          System.out.println(BookRatingList.get(i).getScore());
          break;
		}*/
		
		
	}
	
	public void userRating() { //유저가 한줄평을 작성하는 메서드
		
        String bookName = "";
		int score;
        String comment;
        boolean b = true;

        
        Scanner s = new Scanner(System.in);

        
        
        do{
        	if(b==false){
        		System.out.println("책 제목을 확인해주세요");
        	}
        for(int i = 0; i < BookDao.BookList.size(); i++){
            System.out.print("책 제목 : ");
            bookName = s.nextLine();  //수정 요. 구매목록에서 책정보를 가져와야함.!
            b = BookDao.BookList.get(i).getName().toLowerCase().replace(" ", "").equals(bookName.replace(" ", "").toLowerCase());  
            bookName = BookDao.BookList.get(i).getName();
            break;
            }
         
        }while(b != true);
        	
        
        do{
        b = false;
        System.out.print("점수(1~10): ");
        score = Integer.parseInt(s.nextLine());
        if(score <= 0 || score >= 11){
        	System.out.println("점수는 1에서 10까지 가능합니다.");
        }else{
        	b=true;
        }
        }while(b!=true);
        
        
        
        System.out.print("한줄평: ");
        comment = s.nextLine();
        
        BookRatingVO bookRatingVO=new BookRatingVO();
        bookRatingVO.setBookName(bookName);
        bookRatingVO.setScore(score);
        bookRatingVO.setComment(comment);
    	bookRatingVO.setUserId(LoginDao.loginSessionVO.getId());
        
        BookRatingList.add(bookRatingVO);
	
	}

	public void ratingList() { //책의 한줄평 조회
		Scanner s = new Scanner(System.in);
		int sum = 0;
		int cnt = 0;
		System.out.println("책 한줄평 조회");
		System.out.print("조회 할 책 이름을 입력해주세요>");
		String bookName = s.nextLine();
		
		
		for(int i = 0 ; i < BookRatingList.size();i++){
			if(bookName.replace(" ", "").toLowerCase().equals(BookRatingList.get(i).getBookName().toLowerCase().replace(" ", ""))){
			System.out.println("----------------------------------------------");
			System.out.println("책제목 : "+BookRatingList.get(i).getBookName());
			System.out.println("점수 : "+BookRatingList.get(i).getScore());
			System.out.println("한줄평 : "+BookRatingList.get(i).getComment());
			System.out.println("아이디 : "+BookRatingList.get(i).getUserId());
			sum += BookRatingList.get(i).getScore();
			cnt++;
			bookName = BookRatingList.get(i).getBookName();
		  }
		}		
		System.out.println("=====================================");
		System.out.print(bookName);
		System.out.print(" 총평점 : "+((int)(sum/(double)cnt*10+0.5))/10.0 + "  ");
		for(int i =0;i<sum/cnt/2;i++){
			System.out.print("★");
		}
		if((sum/cnt)%2 == 1){
			System.out.print("☆");
		}System.out.println();
		System.out.println("=====================================");
	}
}