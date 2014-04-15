package subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subject/detail.bit")
public class DetailServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  SubjectDao dao = null;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    DBConnectionPool dbConnectionPool = new DBConnectionPool();
    dao = new MysqlSubjectDao();
    ((MysqlSubjectDao)dao).setDBConnectionPool(dbConnectionPool);
    SubjectVo subject = null;
    try {
      subject = dao.detail(Integer.parseInt(request.getParameter("no")));
    } catch (Throwable e) {
      e.printStackTrace();
    }
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>DetailServlet</title>");
    out.println("<style>table{border:1px solid black}");
    out.println("body{background-color:#FFF8DC;text-align:center}");
    out.println("th{border:1px solid black; text-align: center}");
    out.println("td{border:1px solid black}");
    out.println(".box{margin:auto;width:300px}");
    out.println("</style></head>");
    out.println("<body><h1>Subject Detail Information</h1>");
    out.println("<div class=box><table><tr><th>No.</th><td>"+subject.getNo()+"</td></tr>");
    out.println("<tr><th>SubjectName</th><td>"+subject.getTitle()+"</td></tr>");
    out.println("<tr><th>Info</th><td>");
    out.println("<textarea rows='5' cols='30' readonly>");
    out.println(subject.getDescription()+"</textarea></td></tr>");
    out.println("</div></table></body></htaml>");
  }

}
