package dao;

import java.util.List;

import vo.UserVo;

public interface UserDao {
  public void insert(UserVo user) throws Throwable;
  public List<UserVo> list(int pageNo, int pageSize) throws Throwable;
  public UserVo detail(int no) throws Throwable;
  public void update(UserVo user) throws Throwable;
  public void delete(int no) throws Throwable;
}
