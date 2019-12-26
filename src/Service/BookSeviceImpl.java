package Service;

import Dao.BookDao;
import Dao.BookRatingDao;

public class BookSeviceImpl  implements  BookService{
    public BookDao bookDao=new BookDao();
    public BookRatingDao bookRatingDao=new BookRatingDao();
    @Override
    public void registBook() {   bookDao.registBook();    }


	@Override
	public void searchBook() {
	  bookDao.searchBook();
		
	}

    @Override
    public void searchBuyBook() {
       bookDao.searchBuyBook();
    }


	@Override
	public void bookRating() {
	  bookRatingDao.bookRating();
		
	}


	@Override
	public void userRating() {
	  bookRatingDao.userRating();
		
	}


	@Override
	public void ratingList() {
		  bookRatingDao.ratingList();
		
	}




}
