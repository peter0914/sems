package vo;

public class CourseVo {
  private int no;
  private String title;
  private String description;
  private int time;
  
  public CourseVo setNo(int no){
    this.no = no;
    return this;
  }
  
  public int getNo(){
    return no;
  }
  
  public String getTitle() {
    return title;
  }

  public CourseVo setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public CourseVo setDescription(String description) {
    this.description = description;
    return this;
  }

  public int getTime() {
    return time;
  }

  public CourseVo setTime(int time) {
    this.time = time;
    return this;
  }
  
  
}
