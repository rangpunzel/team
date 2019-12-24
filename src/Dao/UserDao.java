package Dao;

import java.util.ArrayList;
import java.util.List;

import Service.UserServieImpl;
import VO.BookVO;
import VO.UserVO;

public class UserDao {
public static List<UserVO> userList=new ArrayList<>();
    static {
        UserVO admin=new UserVO();
        admin.setId("admin");
        admin.setPassword("admin");
        admin.setAddress("admin");
        admin.setPhonNumber("admin");
        admin.setRoll("admin");
        userList.add(admin);
        
        UserVO user=new UserVO();
        user.setId("a");
        user.setPassword("a");
        user.setName("지선");
        user.setAddress("대전");
        user.setPhonNumber("010");
        user.setRoll("user");
        userList.add(user);
        
    }

    public void insertUser(UserVO vo) {
    	int a = 0;
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getId().equals(vo.getId())){
                System.out.println("이미 가입된 계정입니다.");
                break;
            }else{        
            	a++;
            } 
        }
        if(a == userList.size()){
        System.out.println("가입됨");
        UserVO user=new UserVO();
        user.setId(vo.getId());
        user.setName(vo.getName());
        user.setAddress(vo.getAddress());
        user.setPhonNumber(vo.getPhonNumber());
        user.setPassword(vo.getPassword());
        user.setPoint(vo.getPoint());
        user.setRoll(vo.getRoll());
        userList.add(user);
        }

    }
    
    

    public void login() {
    	
    	
    }
    
    public void userList() {
    	System.out.println("아이디 \t" + "이름\t"+"주소\t"+"전화번호\t"+"포인트\t"+"분류");
        for(int i=0;i<userList.size();i++){
          System.out.println(userList.get(i).getId()+"\t"+userList.get(i).getName()+"\t"+
        		  userList.get(i).getAddress()+"\t"+userList.get(i).getPhonNumber()
        		  +"\t"+userList.get(i).getPoint()+"\t"+userList.get(i).getRoll());
        }

    }
    
    public void userDelete(String deleteId) {
    	
        for(int i=0;i<userList.size();i++){
        	if(userList.get(i).getId().equals(deleteId)){
        		userList.remove(i);
        		System.out.println(deleteId+"가 삭제되었습니다.");
        	}
          }
    	
    }
}
