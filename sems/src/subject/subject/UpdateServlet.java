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
import subject.vo.SubjectVo;

@WebServlet("/subject/update.bit")
public class UpdateServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  static SubjectDao dao;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    DBConnectionPool dbConnectionPool = new DBConnectionPool();
    dao = new MysqlSubjectDao();
    ((MysqlSubjectDao)dao).setDBConnectionPool(dbConnectionPool);
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      if((dao.update(new SubjectVo()
          .setNo(Integer.parseInt(request.getParameter("no")))
          .setTitle(request.getParameter("title"))
          .setDescription(request.getParameter("description"))))==1){
        out.println("<html><head><title>InsertServlet</title>");
        out.println("<style>");
        out.println("body{background-color:#7FFFD4}");
        out.println("</style>");
        out.println("</head><body><h1>Update Success!!</h1>");
        out.println("</body></htaml>");
      }else{
        out.println("<html><head><title>InsertServlet</title>");
        out.println("<style>");
        out.println("body{background-color:#7FFFD4}");
        out.println("</style>");
        out.println("</head><body><h1>Update Failed!!</h1>");
        out.println("</body></htaml>");
      }
    } catch (Throwable e) {
      out.println("<html><head><title>InsertServlet</title>");
      out.println("<style>");
      out.println("body{background-color:#7FFFD4}");
      out.println("</style>");
      out.println("</head><body><h1>Update Failed!!</h1>");
      out.println("</body></htaml>");
    }
  }

}
