package servlets.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import dao.CourseDao;

@SuppressWarnings("serial")
@WebServlet("/course/detail.bit")
public class CourseDetailServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>상세정보</title></head><body>");
    out.println("<h1>과정 상세정보</h1>");
    try{
      CourseDao dao = (CourseDao)this.getServletContext()
          .getAttribute("courseDao");
      
      int no = Integer.parseInt(request.getParameter("no"));
      CourseVo course = dao.detail(no);
      
      out.println("<table border='1'");
      out.println("<tr>");
      out.println("<th>번호</th>");
      out.println("<td>"+course.getNo()+"</td>");
      out.println("</tr>");
      out.println("<tr>");
      out.println("<th>과정명</th>");
      out.println("<td>"+course.getTitle()+"</td>");
      out.println("</tr>");
      out.println("<tr>");
      out.println("<th>내용</th>");
      out.println("<td><textarea row='5' cols'60' readonly>"
          +course.getDescription()
          +"</textarea></td>");
      out.println("</tr>");
      out.println("<tr>");
      out.println("<th>수강시간</th>");
      out.println("<td>"+course.getTime()+"</td>");
      out.println("</tr>");
      
      out.println("</table>");
    }catch(Throwable e){
      out.println("오류 발생<br>");
    }
    out.println("</body></html>");
  }
  
}
