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
    out.println("<html><head><title>과정변경</title></head><body>");
    out.println("<h1>과정 삭제 결과</h1>");
    try{
      CourseDao dao = (CourseDao)this.getServletContext()
          .getAttribute("courseDao");
      
      int no = Integer.parseInt(request.getParameter("no"));
      
      dao.delete(no);
      
      out.println("삭제 성공!");
      
      
      response.sendRedirect("list.bit?pageNo=1&pageSize=10");
    }catch(Throwable e){
      out.println(e);
      out.println("오류 발생");
    }
    out.println("</body></html>");
  }
  
}
