package servlets.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;

@SuppressWarnings("serial")
@WebServlet("/course/delete.bit")
public class CourseDeleteServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>과정변경</title>");
    out.println("<meta http-equiv='refresh'");
    out.println(" content='2;url=http://192.168.200.27:9999/sems/course'>");
    out.println("<style>");
    out.println("body{background-color:#E3F4E3}");
    out.println("div{width:500px;margin:auto}");
    out.println("</style>");
    out.println("</head><body>");
    out.println("<h1>과정 삭제 결과</h1>");
    try{
      CourseDao dao = (CourseDao)this.getServletContext()
          .getAttribute("courseDao");
      
      int no = Integer.parseInt(request.getParameter("no"));
      
      dao.delete(no);
      
      out.println("삭제 성공!<br>");
    }catch(Throwable e){
      out.println("오류 발생<br>");
    }
    out.println("<br>잠시 후 메인 페이지로 이동합니다.");
    out.println("</body></html>");
  }
  
}
