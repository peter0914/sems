package cours;

import java.util.List;

public interface CoursDao {
	public void insert(CoursVo cours) throws Throwable;
	public List<CoursVo> list (int pageNo, int pageSize) throws Throwable;
	public CoursVo detail(int no) throws Throwable;
	public int update(CoursVo cours) throws Throwable;
	public int delete(int no) throws Throwable;
}
