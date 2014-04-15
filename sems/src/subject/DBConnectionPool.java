package subject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


public class DBConnectionPool {
  ArrayList<Connection> list = new ArrayList<Connection>();
  public Connection getConnection() throws Exception{
    if (list.size()>0){
      return list.remove(0);
    }else{
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb","study","study");
    }
  }
  
  public void returnConnection(Connection con){
    try{
      if(!con.isClosed()){
        list.add(con);
      }
    } catch(Exception e){
    }
  }
  public void closeAll(){
    for (Connection con : list){
      try{con.close();}catch(Exception e){}
    }
  }
}
