package dao;

import java.util.List;

import vo.SubjectVo;

public interface SubjectDao {
  public void insert(SubjectVo subject) throws Throwable;
  public List<SubjectVo> list(int pageNo, int pageSize) throws Throwable;
  public SubjectVo detail(int no) throws Throwable;
  public void update(SubjectVo subject) throws Throwable;
  public void delete(int no) throws Throwable;
}
