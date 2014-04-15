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
@WebServlet("/course/update.bit")
public class CourseUpdateServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>과정변경</title></head><body>");
    out.println("<h1>과정 변경</h1>");
    try{
      CourseDao dao = (CourseDao)this.getServletContext()
          .getAttribute("courseDao");
      
      CourseVo vo = new CourseVo();
      vo.setNo(Integer.parseInt(request.getParameter("no")));
      vo.setTitle(request.getParameter("title"));
      vo.setDescription(request.getParameter("description"));
      vo.setTime(Integer.parseInt(request.getParameter("time")));
      
      dao.update(vo);
      
      out.println("등록 성공!");
    }catch(Throwable e){
      out.println(e);
      out.println("오류 발생");
    }
    out.println("</body></html>");
  }
  
}
