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
    out.println("<html><head><title>상세정보</title>");
    out.println("<style>");
    out.println("body{text-align:center;background-color:#E3F4E3}");
    out.println("div{width:500px;margin:auto}");
    out.println("</style>");
    try{
      CourseDao dao = (CourseDao)this.getServletContext()
          .getAttribute("courseDao");
      
      int no = Integer.parseInt(request.getParameter("no"));
      CourseVo course = dao.detail(no);
      
      out.println("</head><body>");
      out.println("<h1>과정 상세정보</h1>");
      out.println("<a href='index.html'>메인화면으로</a>");
      out.println("<div><table border='1' width=490px>");
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
      
      out.println("</table></div>");
    }catch(Throwable e){
      out.println("<meta http-equiv='refresh'");
      out.println(" content='2;url=http://192.168.200.27:9999/sems/course'>");
      out.println("</head><body>");
      out.println("<h1>과정 상세정보</h1>");
      out.println("오류 발생<br>");
    }
    out.println("</body></html>");
  }
  
}
