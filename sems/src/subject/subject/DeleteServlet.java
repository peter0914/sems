package subject.subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import subject.dao.MysqlSubjectDao;
import subject.dao.SubjectDao;
import subject.util.DBConnectionPool;


@WebServlet("/subject/delete.bit")
public class DeleteServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  static SubjectDao dao;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    DBConnectionPool dbConnectionPool = new DBConnectionPool();
    dao = new MysqlSubjectDao();
    ((MysqlSubjectDao)dao).setDBConnectionPool(dbConnectionPool);
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      if(dao.delete(Integer.parseInt(request.getParameter("no")))==1){
      out.println("<html><head><title>InsertServlet</title>");
      out.println("<style>");
      out.println("body{background-color:#FFF8DC}");
      out.println("</style>");
      out.println("</head><body><h1>Delete Success!!</h1>");
      out.println("</body></htaml>");
      }else{
        out.println("<html><head><title>InsertServlet</title>");
        out.println("<style>");
        out.println("body{background-color:#FFF8DC}");
        out.println("</style>");
        out.println("</head><body><h1>Delete Failed!!</h1>");
        out.println("</body></htaml>");
      }
    } catch (Throwable e) {
      out.println("<html><head><title>InsertServlet</title>");
      out.println("<style>");
      out.println("body{background-color:#FFF8DC}");
      out.println("</style>");
      out.println("</head><body><h1>Delete Failed!!</h1>");
      out.println("</body></htaml>");
      e.printStackTrace();
    }
  }
}
