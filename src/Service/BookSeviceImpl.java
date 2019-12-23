package Service;

import Dao.BookDao;

public class BookSeviceImpl  implements  BookService{
    public BookDao bookDao=new BookDao();
    @Override
    public void registBook() {   bookDao.registBook();    }

    @Override
    public void rentalBook() {
    }

    @Override
    public void returnBook() {

    }

    @Override
    public void searchBuyBook() {
       bookDao.searchBuyBook();
    }
}
