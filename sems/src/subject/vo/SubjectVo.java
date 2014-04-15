package subject.vo;

/*
 * setter/getter 적용 <= encapsulation
 */
public class SubjectVo {
  private int no;
  private String title;
  private String description;
  
  public SubjectVo setNo(int no){
    this.no = no;
    return this;
  }
  
  public int getNo(){
    return no;
  }
  
  public String getTitle() {
    return title;
  }

  public SubjectVo setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public SubjectVo setDescription(String description) {
    this.description = description;
    return this;
  }
}
