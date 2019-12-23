package Dao;

import VO.LoginSessionVO;
import VO.UserVO;

import java.util.Scanner;

public class LoginDao {
    public static LoginSessionVO loginSessionVO; //로그인 세션
    public void login (){
        String id;
        String password;
        Scanner scanner=new Scanner(System.in);


    	//아이디와 패스워드를 입력받음
            System.out.print("아이디를 입력해주세요");
            id = scanner.nextLine();
            System.out.print("비밀번호를 입력해주세요");
            password = scanner.nextLine();
        // 입력된 아이디와 패스워드를 vo에 저장
            UserVO vo = new UserVO();
            vo.setId(id);
            vo.setPassword(password);
        //loginCheck에 유저 정보를 넘김
            boolean isLogin = loginCheck(vo);

    }
    public boolean loginCheck(UserVO vo) {
        while (true) {
            for (int i = 0; i < UserDao.userList.size(); i++) {
                if (UserDao.userList.get(i).getId().equals(vo.getId())) {
                    if (UserDao.userList.get(i).getPassword().equals(vo.getPassword())) {
                        if (UserDao.userList.get(i).getRoll().equals("user")) {
                            loginSessionVO = new LoginSessionVO();
                            loginSessionVO.setId(vo.getId());
                            loginSessionVO.setRoll("user");
                            System.out.println("로그인 되었습니다.");
                            return true;
                        } else if (UserDao.userList.get(i).getRoll().equals("admin")) {
                            loginSessionVO = new LoginSessionVO();
                            loginSessionVO.setId(vo.getId());
                            loginSessionVO.setRoll("admin");
                            return true;
                        }
                    } else {
                        System.out.println("비밀번호 오류 입니다. 로그인을 다시 한번 시도 해주세요");
                        return false;
                    }
                }
            }
        }
    }
}
