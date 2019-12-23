package Dao;


import Service.BookSeviceImpl;
import VO.BookVO;
import VO.LoginSessionVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDao {
    public static List<BookVO> BookList = new ArrayList<>();
  //  public BookSeviceImpl bookSeviceImpl = new BookSeviceImpl();

    static {
        BookVO[] bookVO = new BookVO[5];
        BookVO bookVO1 = new BookVO();
        bookVO1.setAuthorName("남궁성");
        bookVO1.setCategoryName("기술");
        bookVO1.setName("자바의 정석");
        bookVO1.setRegDate("2019-12-19");
        bookVO1.setPublishCompanyName("도우출판사");
        bookVO1.setCountOfbook(10);
        BookVO bookVO2 = new BookVO();
        bookVO2.setAuthorName("옥스토비");
        bookVO2.setCategoryName("자연과학");
        bookVO2.setName("옥스토비의 일반화학");
        bookVO2.setRegDate("2019-12-19");
        bookVO2.setCountOfbook(10);
        BookVO bookVO3 = new BookVO();
        bookVO3.setAuthorName("맨큐");
        bookVO3.setCategoryName("사회과학");
        bookVO3.setName("맨큐의 경제학");
        bookVO3.setRegDate("2019-12-19");
        bookVO3.setCountOfbook(10);
        BookVO bookVO4 = new BookVO();
        bookVO4.setAuthorName("Jearl Walker, David Halliday, Robert Resnick");
        bookVO4.setCategoryName("자연과학");
        bookVO4.setName("일반물리학 제 1권");
        bookVO4.setRegDate("2019-12-19");
        bookVO3.setPublishCompanyName("법한서적");
        bookVO4.setCountOfbook(10);
        BookVO bookVO5 = new BookVO();
        bookVO5.setAuthorName("Jearl Walker, David Halliday, Robert Resnick");
        bookVO5.setCategoryName("자연과학");
        bookVO5.setName("일반물리학 제 2권");
        bookVO5.setRegDate("2019-12-19");
        bookVO3.setPublishCompanyName("법한서적");
        bookVO5.setCountOfbook(10);
        bookVO[0] = bookVO1;
        bookVO[1] = bookVO2;
        bookVO[2] = bookVO3;
        bookVO[3] = bookVO4;
        bookVO[4] = bookVO5;
        BookList.add(bookVO[0]);
        BookList.add(bookVO[1]);
        BookList.add(bookVO[2]);
        BookList.add(bookVO[3]);
        BookList.add(bookVO[4]);
    }


    public void registBook() {
        String name;
        String categoryName;
        String  publishCompanyName;
        String  authorName;
        int  countOfbook;
        Scanner scanner=new Scanner(System.in);
        System.out.print("책이름 입력: ");
        name=scanner.nextLine();
        System.out.print("카테고리 입력: ");
        categoryName=scanner.nextLine();
        System.out.print("출판사 이름:");
        publishCompanyName=scanner.nextLine();
        System.out.print("저자 이름 :");
        authorName=scanner.nextLine();
        System.out.println("등록할 잭의갯수");
        countOfbook=Integer.parseInt(scanner.nextLine());
        BookVO bookVO=new BookVO();
        bookVO.setName(name);
        bookVO.setCategoryName(categoryName);
        bookVO.setPublishCompanyName(publishCompanyName);
        bookVO.setAuthorName(authorName);
        bookVO.setCountOfbook(countOfbook);
        BookList.add(bookVO);
    }

    public void rentalBook() {
    }

    public void returnBook() {

    }

    public void searchBook() {
    }

    public void searchBuyBook() {
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("구매를 위한 검색을 시작합니다.");
        System.out.print("책이름을 입력해주세요");
        name = scanner.nextLine();
        if (LoginDao.loginSessionVO.getRoll().equals("admin")) {
            //System.out.println("관리자용 구매 페이지");
            int searchIdx = -1;
            for (int i = 0; i < BookDao.BookList.size(); i++) {
                if (BookDao.BookList.get(i).getName().equals(name)) {
                    searchIdx = i;
                }
                if (searchIdx == -1) {
                    System.out.println("해당도서는 우리 서점에 없습니다. 이 도서를 등록할까요");
                    registBook();
                }
                System.out.println(BookDao.BookList.get(searchIdx).getName());
                System.out.println(BookDao.BookList.get(searchIdx).getCountOfbook());
                System.out.println(BookDao.BookList.get(searchIdx).getPublishCompanyName());
                if (BookDao.BookList.get(searchIdx).getCountOfbook() == 0) {
                    int bookInsert;
                    System.out.println("해당 출판사의 도서를 몇권을 더 주문할까요?");
                    bookInsert = Integer.parseInt(scanner.nextLine());
                    System.out.println("알겠습니다. 도서를 주문하였습니다. 해당 협력사에게 주문을 요청하였습니다.");
                }


            }
        } else if (LoginDao.loginSessionVO.getRoll().equals("user")) {
            //System.out.println("일반유저용 구매 페이지");
        }
    }
}
