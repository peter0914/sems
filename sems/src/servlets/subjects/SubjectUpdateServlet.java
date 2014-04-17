package servlets.subjects;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
    try{
      // 1) DB에서 과목 상세 정보를 가져온다. 
      int no = Integer.parseInt(request.getParameter("no"));
      SubjectDao dao = (SubjectDao)this.getServletContext()
          .getAttribute("subjectDao");
      SubjectVo vo = dao.detail(no);
      
      request.setAttribute("subject", vo);
      
      RequestDispatcher rd = 
          request.getRequestDispatcher("/subject/updateform.jsp");
      
      rd.forward(request, response);
    }catch(Throwable e){
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try{
      SubjectDao dao = (SubjectDao)this.getServletContext()
          .getAttribute("subjectDao");
      SubjectVo vo = new SubjectVo();
      vo.setNo(Integer.parseInt(request.getParameter("no")));
      System.out.println("chk1");
      vo.setTitle(request.getParameter("title"));
      System.out.println("chk2");
      vo.setDescription(request.getParameter("description"));
      dao.update(vo);
      response.sendRedirect("detail.bit?no="+vo.getNo());
    }catch(Throwable e){
      e.printStackTrace();
    }
  }
  
}
