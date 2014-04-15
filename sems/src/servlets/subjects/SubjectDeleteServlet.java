package servlets.subjects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDao;

@SuppressWarnings("serial")
@WebServlet("/subject/delete.bit")
public class SubjectDeleteServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>과목변경</title></head><body>");
    out.println("<h1>과목 삭제 결과</h1>");
    try{
      SubjectDao dao = (SubjectDao)this.getServletContext()
          .getAttribute("subjectDao");
      
      int no = Integer.parseInt(request.getParameter("no"));
      
      dao.delete(no);
      
      out.println("삭제 성공!");
    }catch(Throwable e){
      out.println(e);
      out.println("오류 발생");
    }
    out.println("</body></html>");
  }
  
}
