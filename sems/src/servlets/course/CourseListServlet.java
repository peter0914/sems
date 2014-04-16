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
    out.println("<html><head><title>과정 목록</title></head><body>");
    out.println("<h1>과정 목록</h1>");
    try{
      CourseDao dao = (CourseDao)this.getServletContext()
            .getAttribute("courseDao");
      
      int pageNo = Integer.parseInt(request.getParameter("pageNo"));
      int pageSize = Integer.parseInt(request.getParameter("pageSize"));
      List<CourseVo> list = dao.list(pageNo, pageSize);
      
      out.println("<a href='form.html'>새과정</a><br>");
      out.println("<table border='1'");
      out.println("<tr>");
      out.println("<th>번호</th>");
      out.println("<th>과정명</th>");
      out.println("<th>교육시간</th>");
      out.println("</tr>");
      
      for(CourseVo course : list){
        out.println("<tr><td>");
        out.println(course.getNo());
        out.println("</td>");
				out.println("	<td><a href='detail.bit?no="
						+ course.getNo()
						+ "'>" + course.getTitle() + "</a></td>");
        
        out.println("<td>");
        out.println( course.getTime());
        out.println("</td></tr>");
      }
      out.println("</table>");
    }catch(Throwable e){
      out.println(e);
      out.println("오류 발생");
      e.printStackTrace();
    }
    out.println("</body></html>");
  }
  
}
