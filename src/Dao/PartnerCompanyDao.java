package Dao;
import VO.PartnerCompanyVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartnerCompanyDao {
    public static List<PartnerCompanyVO> partnerCompanies =new ArrayList<>();
public void addPartnerCompany(){
    Scanner scanner=new Scanner(System.in);
    String companyName;//회사이름
    String agentName;//대표이름
    //List<BookVO> publishingBooks= new ArrayList<>();//출판된 책 목록
    String directorName;//담당자이름
    String directPhoneNumber;//담당자 번호
    System.out.println("협력사 추가 기능");
    System.out.println("출판사 이름:");
    companyName=scanner.nextLine();
    System.out.println("대표자 이름:");
    agentName=scanner.nextLine();
    System.out.println("담당자 이름:");
    directorName=scanner.nextLine();
    System.out.println("담담자 연락처:");
    directPhoneNumber=scanner.nextLine();
    PartnerCompanyVO partnerCompanyVO=new PartnerCompanyVO();
    partnerCompanyVO.setAgentName(agentName);
    partnerCompanyVO.setCompanyName(companyName);
    partnerCompanyVO.setDirectorName(directorName);
    partnerCompanyVO.setDirectPhoneNumber(directPhoneNumber);
    for(int i=0;i<BookDao.BookList.size();i++) {//입력한 출판사 이름이랑 북리스트에 있는 출판사 이름이랑 같으면  서적의 이름만 추가하는 로직 
        if (BookDao.BookList.get(i).getPublishCompanyName().equals(companyName)){
            PartnerCompanyDao.partnerCompanies.get(i).setPublishingBook(BookDao.BookList);
        }
        for (PartnerCompanyVO vo:partnerCompanies  ) {
            System.out.println(vo.getPublishingBook().get(0).getPublishCompanyName());
        }
    }
}
public void deletePaterCompany(){}
}
