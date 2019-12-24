package Service;

import java.io.PrintStream;
import java.util.Scanner;

import Dao.BookDao;
import Dao.LoginDao;

public class DisPlayMenu {
    private PrintStream printStream = new PrintStream(System.out);
    private BookSeviceImpl bookSeviceImpl=new BookSeviceImpl();
    private LoginServiceImpl loginServiceImpl = new LoginServiceImpl();//login  체크를 위해서 필요
    //시작메뉴
    public void defaultMenu() {
        printStream.println("종료라고 입력하시면 첫 화면으로  이동합니다..");
        printStream.println("1.도서검색");
        printStream.println("2.베스트 셀러 목록 보기 ");
        printStream.println("3.로그인하기 ");
        printStream.println("4.회원가입 ");
        printStream.println("5.탈퇴 ");
        printStream.println("6.회원목록 ");
        selectedDefaultMenu();

    }
    public void selectedDefaultMenu() {

        Scanner scanner = new Scanner(System.in);
        String selectedNum;
        while (true) {
            System.out.print("번호를 입력해주세요.");
            selectedNum = scanner.nextLine();
            if (selectedNum.equals("1")) {
                System.out.println("도서검색");
                bookSeviceImpl.searchBook();
            } else if (selectedNum.equals("2")) {
                System.out.println("베스트셀러 목록을 보여주는 함수");
                
            } 

            
            else if (selectedNum.equals("3")) {
                while(true) {
                    if (LoginDao.loginSessionVO == null) {
                        loginServiceImpl.login();
                    }
                    if (LoginDao.loginSessionVO.getRoll().equals("admin")) {
                        adminLoginMenu();
                        break;
                    } else if (LoginDao.loginSessionVO.getRoll().equals("user")) {
                        userSelectedMenu();
                        break;
                    }
                }
            }             
            //테스트
            else if (selectedNum.equals("4")) {
            	UserServieImpl usi = new UserServieImpl();
            	usi.addUser();
            } 
            else if (selectedNum.equals("5")) {
            	UserServieImpl usi = new UserServieImpl();
            	usi.deleteUser();
            } 
            else if (selectedNum.equals("6")) {
            	UserServieImpl usi = new UserServieImpl();
            	usi.ListUser();
            } 
            //
            
            
            else if (selectedNum.equals("종료")) {
                defaultMenu();
                LoginDao.loginSessionVO = null;
                break;

            }
        }
    }

    public void userSelectedMenu() {
        Scanner scanner = new Scanner(System.in);
        String selectedNum;
        while (true) {
            System.out.print("번호를 입력해주세요.");
            selectedNum = scanner.nextLine();
            if (selectedNum.equals("1")) {
                System.out.println("도서검색");
            } else if (selectedNum.equals("2")) {
                System.out.println("베스트셀러 목록을 보여주는 함수");
            } else if (selectedNum.equals("3")) {
                System.out.println("로그인 확인 후 구매 화면으로 돌아가기 ");
            } else if (selectedNum.equals("종료")) {
                defaultMenu();
                //세션 반납 로그아웃
                break;
            }
        }
    }

    public void adminLoginMenu() {
        printStream.println("종료라고 첫 화면으로 돌아 갑니다.");
        printStream.println("1.새로운 책 등록");
        printStream.println("2.도서 재고 관리");
        printStream.println("3.협력사 등록하기");
        printStream.println("4.협력사 삭제하기");
        adminSelectedMenu();
    }

    public void adminSelectedMenu() {
        Scanner scanner = new Scanner(System.in);
        String selectedNum;
        while (true) {
            System.out.print("번호를 입력해주세요.");
            selectedNum = scanner.nextLine();
            if (selectedNum.equals("1")) {
                bookSeviceImpl.registBook();
                break;
            } else if (selectedNum.equals("2")) {
                System.out.println("도서재고관리");
            } else if (selectedNum.equals("3")) {
                System.out.println("협력사  등록하기  ");
            }else if(selectedNum.equals("4")){
                System.out.println("협력사 삭제하기");
            }
            else if (selectedNum.equals("종료")) {
                defaultMenu();
                break;

            }
        }
    }
}
