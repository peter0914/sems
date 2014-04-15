package servlets.subjects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.SubjectVo;
import dao.SubjectDao;

@SuppressWarnings("serial")
@WebServlet("/subject/update.bit")
public class SubjectUpdateServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    /*
     * GET방식 요청의 URL문자집합 설정은
     *  - servlet container 안내에 따라 설정한다. 
     *  - getParameter()를 호출하기 전에 실행해야 한다.
     *  - 단 한번이라도 getParameter()를 호출했다면 적용 안됨
     */
    
    
    // POST 요청의 값에 대해 적용.
    request.setCharacterEncoding("UTF-8");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>과목변경</title></head><body>");
    out.println("<h1>과목 변경</h1>");
    try{
      SubjectDao dao = (SubjectDao)this.getServletContext()
          .getAttribute("subjectDao");
      
      SubjectVo vo = new SubjectVo();
      vo.setNo(Integer.parseInt(request.getParameter("no")));
      vo.setTitle(request.getParameter("title"));
      vo.setDescription(request.getParameter("description"));
      
      dao.update(vo);
      
      out.println("등록 성공!");
    }catch(Throwable e){
      out.println(e);
      out.println("오류 발생");
    }
    out.println("</body></html>");
  }
  
}
