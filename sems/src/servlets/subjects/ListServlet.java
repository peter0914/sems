package servlets.subjects;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subject/list.bit")
public class ListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  SubjectDao dao = null;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    DBConnectionPool dbConnectionPool = new DBConnectionPool();
    dao = new MysqlSubjectDao();
    ((MysqlSubjectDao)dao).setDBConnectionPool(dbConnectionPool);
    List<SubjectVo> list = null;
    try {
      list = dao.list(Integer.parseInt(request.getParameter("pageNo")),
          Integer.parseInt(request.getParameter("pageSize")));
    } catch (Throwable e) {
      e.printStackTrace();
    }
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>ListServlet</title>");
    out.println("<style>table{border:1px solid black; text-align: center}");
    out.println("body{text-align: center}");
    out.println("body{background-color:#7FFFD4}");
    out.println(".box{margin:auto;width:270px}");
    out.println("th{border:1px solid black}");
    out.println("td{border:1px solid black}");
    out.println("#no{width: 50; height: 30}");
    out.println("#name{width:200}");
    out.println("td:hover{background-color : gold}");
    out.println("th:hover{background-color : pink}");
    out.println("</style></head>");
    out.println("<body><h1>Subject Information</h1>");
    out.println("<div class=box>");
    out.println("<table><tr><th id='no'>No.</th><th id='name'>Subject Name</th><tr>");
    for(SubjectVo subject : list){
      out.println("<tr><td>" + subject.getNo() + "</td>"
          + "<td>"+ subject.getTitle() + "</td></tr>");
    }
    out.println("</table></div></body></htaml>");
  }
}
