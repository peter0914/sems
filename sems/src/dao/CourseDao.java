package dao;

import java.util.List;

import vo.CourseVo;

public interface CourseDao {
  public void insert(CourseVo course) throws Throwable;
  public List<CourseVo> list(int pageNo, int pageSize) throws Throwable;
  public CourseVo detail(int no) throws Throwable;
  public void update(CourseVo subject) throws Throwable;
  public void delete(int no) throws Throwable;
}
