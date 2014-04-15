package subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * SubjectVo의 setter/getter 사용
 */
public class MysqlSubjectDao implements SubjectDao{
  DBConnectionPool dbConnectionPool;
  
  public void setDBConnectionPool(DBConnectionPool dbConnectionPool){
    this.dbConnectionPool = dbConnectionPool;
  }
  
  public void insert(SubjectVo subject) throws Throwable{
    Connection con = null;
    PreparedStatement stmt = null;
    try{
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement(
          "insert SE_SUBJS(TITLE, DEST) values(?, ?)");
      stmt.setString(1, subject.getTitle());
      stmt.setString(2, subject.getDescription());
      stmt.executeUpdate();
    }catch(Throwable e){
      throw e;
    } finally{
      try{stmt.close();}catch(Throwable e2){}
      dbConnectionPool.returnConnection(con);
    }
  }
  
  public List<SubjectVo> list(int pageNo, int pageSize) throws Throwable{
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try{
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement("select SNO, TITLE from SE_SUBJS"
          + " order by SNO asc limit ?, ?");
      stmt.setInt(1, (pageNo-1)*pageSize);
      stmt.setInt(2, pageSize);
      rs = stmt.executeQuery();
      ArrayList<SubjectVo> list = new ArrayList<SubjectVo>();
      while(rs.next()){
        list.add(new SubjectVo()
            .setNo(rs.getInt("SNO")).setTitle(rs.getString("TITLE")));
      }
      return list;
    }catch(Throwable e){
      throw e;
    } finally{
      try{rs.close();}catch(Throwable e1){}
      try{stmt.close();}catch(Throwable e2){}
      dbConnectionPool.returnConnection(con);
    }
  }
  
  public SubjectVo detail(int no) throws Throwable{
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try{
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement("select SNO, TITLE, DEST from SE_SUBJS"
          + " where SNO=?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();
      if(rs.next()){
        return new SubjectVo()
                    .setNo(rs.getInt("SNO"))
                    .setTitle(rs.getString("TITLE"))
                    .setDescription(rs.getString("DEST"));
      }else{
        throw new Exception("Can't find subject");
      }
    }catch(Throwable e){
      throw e;
    } finally{
      try{rs.close();}catch(Throwable e1){}
      try{stmt.close();}catch(Throwable e2){}
      dbConnectionPool.returnConnection(con);
    }
  }
  
  public int update(SubjectVo subject) throws Throwable{
    Connection con = null;
    PreparedStatement stmt = null;
    try{
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement("update SE_SUBJS"
          + " set TITLE=?"
          + ", DEST=?"
          + " where SNO=?");
      stmt.setString(1, subject.getTitle());
      stmt.setString(2, subject.getDescription());
      stmt.setInt(3, subject.getNo());
      return stmt.executeUpdate();
    }catch(Throwable e){
      throw e;
    } finally{
      try{stmt.close();}catch(Throwable e2){}
    }
  }
  
  public int delete(int no) throws Throwable{
    Connection con = null;
    PreparedStatement stmt = null;
    try{
      con = dbConnectionPool.getConnection();
      stmt = con.prepareStatement("delete from SE_SUBJS where SNO=?");
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    }catch(Throwable e){
      throw e;
    } finally{
      try{stmt.close();}catch(Throwable e2){}
      dbConnectionPool.returnConnection(con);
    }
  }
}
