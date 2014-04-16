package servlets.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import dao.CourseDao;

@SuppressWarnings("serial")
@WebServlet("/course/list.bit")
public class CourseListServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>과정 목록</title>");
    out.println("<style>");
    out.println("body{text-align:center;background-color:#E3F4E3}");
    out.println("div{width:500px;margin:auto}");
    out.println("</style>");
    try{
      CourseDao dao = (CourseDao)this.getServletContext()
            .getAttribute("courseDao");
      
      int pageNo = Integer.parseInt(request.getParameter("pageNo"));
      int pageSize = Integer.parseInt(request.getParameter("pageSize"));
      List<CourseVo> list = dao.list(pageNo, pageSize);
      
      out.println("</head><body>");
      out.println("<h1>과정 목록</h1>");
      out.println("<a href='index.html'>메인화면으로</a>");
      out.println("<div><table border='1' width=490px>");
      out.println("<tr>");
      out.println("<th>번호</th>");
      out.println("<th>과목명</th>");
      out.println("</tr>");
      
      for(CourseVo course : list){
        out.println("<tr><td>");
        out.println(course.getNo());
        out.println("</td>");
        out.println("<td>");
        out.println(course.getTitle());
        out.println("</td></tr>");
      }
      out.println("</table></div>");
    }catch(Throwable e){
      out.println("<meta http-equiv='refresh'");
      out.println(" content='2;url=http://192.168.200.27:9999/sems/course'>");
      out.println("</head><body>");
      out.println("<h1>과정 목록</h1>");
      out.println("오류 발생");
    }
    out.println("</body></html>");
  }
  
}
