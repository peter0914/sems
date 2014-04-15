package servlets.subjects;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.SubjectVo;
import dao.SubjectDao;

@SuppressWarnings("serial")
@WebServlet("/subject/list.bit")
public class SubjectListServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>과목 목록</title></head><body>");
    out.println("<h1>과목 목록</h1>");
    try{
      SubjectDao dao = (SubjectDao)this.getServletContext()
            .getAttribute("subjectDao");
      
      int pageNo = Integer.parseInt(request.getParameter("pageNo"));
      int pageSize = Integer.parseInt(request.getParameter("pageSize"));
      List<SubjectVo> list = dao.list(pageNo, pageSize);
      
      out.println("<table border='1'");
      out.println("<tr>");
      out.println("<th>번호</th>");
      out.println("<th>과목명</th>");
      out.println("</tr>");
      
      for(SubjectVo subject : list){
        out.println("<tr><td>");
        out.println(subject.getNo());
        out.println("</td>");
        out.println("<td>");
        out.println(subject.getTitle());
        out.println("</td></tr>");
      }
      out.println("</table>");
    }catch(Throwable e){
      out.println(e);
      out.println("오류 발생");
    }
    out.println("</body></html>");
  }
  
}
