package subject;
// 주석 테스트
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

// 오호라... ㅎㅎㅎㅎㅎ

// 응답하라 오바

//주석을 테스트 하는 것
// 성호 힘내라 앞으로 각자 편집해야되면 정신 차려라

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
      System.out.println("안녕!-태희");
    }
  }
}
