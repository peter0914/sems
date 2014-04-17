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
@WebServlet("/subject/detail.bit")
public class SubjectDetailServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try{
      SubjectDao dao = (SubjectDao)this.getServletContext()
          .getAttribute("subjectDao");
      
      int no = Integer.parseInt(request.getParameter("no"));
      SubjectVo subject = dao.detail(no);
      
      request.setAttribute("detail", subject);
      RequestDispatcher rd = 
          request.getRequestDispatcher("/subject/detail.jsp");
      rd.forward(request, response);
    }catch(Throwable e){
      e.printStackTrace();
    }
  }
  
}
