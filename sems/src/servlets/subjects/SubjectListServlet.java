package servlets.subjects;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.SubjectVo;
import dao.SubjectDao;


/*
 * View(JSP) 적용
 *  - 이 클래스가 하던 일 중에서 출력 부분을 JSP에 위임함.
 *  - MVC 구조의 완성
 */

@SuppressWarnings("serial")
@WebServlet("/subject/list.bit")
public class SubjectListServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try{
      SubjectDao dao = (SubjectDao)this.getServletContext()
            .getAttribute("subjectDao");
      
      int pageNo = Integer.parseInt(request.getParameter("pageNo"));
      int pageSize = Integer.parseInt(request.getParameter("pageSize"));
      List<SubjectVo> list = dao.list(pageNo, pageSize);
      
      // ServletRequest 보관소에 DAO 리턴 결과를 보관한다. => JSP가 사용하도록
      request.setAttribute("list", list);
      
      // JSP에게 실행을 위임한다. => RequestDespatcher를 얻는다.
      //  - parameter는 반드시 현재 컨텍스트(웹 앱 루트)를 기준으로 할 것.
      RequestDispatcher rd = 
          request.getRequestDispatcher("/subject/list.jsp");
      rd.forward(request, response);
    }catch(Throwable e){
      e.printStackTrace();
    }
  }
  
}
