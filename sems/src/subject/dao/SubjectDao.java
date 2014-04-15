package subject.dao;

import java.util.List;

import subject.vo.SubjectVo;

public interface SubjectDao {
  public void insert(SubjectVo subject) throws Throwable;
  public List<SubjectVo> list(int pageNo, int pageSize) throws Throwable;
  public SubjectVo detail(int no) throws Throwable;
  public int update(SubjectVo subject) throws Throwable;
  public int delete(int no) throws Throwable;
}
