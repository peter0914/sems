package servlets.subjects;

import java.util.List;
import java.util.Scanner;

/*
 * 1. DBConnectionPool 준비
 * 2. MysqlSubjectDao에 커넥션풀을 주입한다.
 */

public class SubjectMgt {
  
  static Scanner sc = new Scanner(System.in);
  static SubjectDao dao;

  public static void testInsert() throws Throwable {
    dao.insert(new SubjectVo().setTitle("Java의 신")
        .setDescription("자바의 신을 존경할 수 있을 정도의 실력으로 향상시킴."));
    System.out.println("Insert Success");
  }
  
  public static void testList() throws Throwable {
    int pageNo = 1, pageSize = 10;
    List<SubjectVo> list;
    do{
      list = dao.list(pageNo, pageSize);
      System.out.println("["+pageNo+"]----------------------------------------------");
      for(SubjectVo subject : list){
        System.out.print(subject.getNo() + ",");
        System.out.println(subject.getTitle());
      }
      pageNo = Integer.parseInt(sc.nextLine());
    }while(pageNo>0);
  }
  
  public static void testUpdate() throws Throwable {
    dao.update(new SubjectVo().setNo(106).setTitle("변경변경")
        .setDescription("내용도 변경"));
    System.out.println("Update Success");
  }
  
  public static void testDetail() throws Throwable {
    System.out.print("Which subject do you want to know detail?:");
    
    SubjectVo subject = dao.detail(Integer.parseInt(sc.nextLine()));
    
    System.out.println(subject.getNo());
    System.out.println(subject.getTitle());
    System.out.println(subject.getDescription());
  }
  
  public static void testDelete() throws Throwable {
    System.out.print("Which data no. do you want to delete?:");
    
    dao.delete(Integer.parseInt(sc.nextLine()));
    
    System.out.println("Delete Success");
    sc.close();
  }
  
  public static void main(String[] args) throws Throwable {
    DBConnectionPool dbConnectionPool = new DBConnectionPool();
    dao = new MysqlSubjectDao();
    // 의존 객체 주입하기
    ((MysqlSubjectDao)dao).setDBConnectionPool(dbConnectionPool);
    String comm = null;
    do{
      try{ // 블록 안에서 예외가 발생하더라도 시스템을 멈추지 않는다.
        System.out.print("COMMAND>");
        comm = sc.nextLine();
        switch(comm){
        case "insert" : 
          testInsert();
          break;
        case "list" :
          testList();
          break;
        case "update" :
          testUpdate();
          break;
        case "detail" :
          testDetail();
          break;
        case "delete" :
          testDelete();
          break;
        }
      }catch(Throwable e){
        
      }
    }while(!"q".equals(comm));
    sc.close();
    dbConnectionPool.closeAll();
  }

}
