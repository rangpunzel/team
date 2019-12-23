package VO;

public class BookVO {

    private String name;//책이름
    private String authorName;//작가이름
    private String categoryName;//카테고리
    private String regDate;//책등록일자
    private static int management = 0;//관리 번호
    private int countOfbook = 0;//재고
    private String publishCompanyName;//출판사 이름
    public BookVO() {
        management++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getRegDate() { return regDate;  }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public static int getManagement() {
        return management;
    }

    public static void setManagement(int management) {
        BookVO.management = management;
    }

    public int getCountOfbook() { return countOfbook; }

    public void setCountOfbook(int countOfbook) {   this.countOfbook = countOfbook;    }

    public String getPublishCompanyName() {  return publishCompanyName;  }

    public void setPublishCompanyName(String publishCompanyName) {     this.publishCompanyName = publishCompanyName;   }
}
