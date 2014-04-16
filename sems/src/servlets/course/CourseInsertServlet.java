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
@WebServlet("/course/insert.bit")
public class CourseInsertServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>과정등록</title>");
    out.println("<meta http-equiv='refresh'");
    out.println(" content='1;url=http://192.168.200.27:9999/sems/course'>");
    out.println("</head><body>");
    out.println("<h1>과정 등록 결과</h1>");
    try{
      CourseDao dao = (CourseDao)this.getServletContext()
          .getAttribute("courseDao");
      
      CourseVo vo = new CourseVo();
      vo.setTitle(request.getParameter("title"));
      vo.setDescription(request.getParameter("description"));
      vo.setTime(Integer.parseInt(request.getParameter("time")));
      
      dao.insert(vo);
      
      out.println("등록 성공!");
    }catch(Throwable e){
      out.println(e);
      out.println("오류 발생");
    }
    out.println("<br><br>잠시 후 메인 페이지로 이동합니다.");
    out.println("</body></html>");
  }
  
}
