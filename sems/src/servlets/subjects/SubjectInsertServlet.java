package servlets.subjects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.SubjectVo;
import dao.SubjectDao;

@SuppressWarnings("serial")
@WebServlet("/subject/insert.bit")
public class SubjectInsertServlet extends HttpServlet{

  
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try{
      SubjectDao dao = (SubjectDao)this.getServletContext()
          .getAttribute("subjectDao");
      SubjectVo vo = new SubjectVo();
      vo.setTitle(request.getParameter("title"));
      vo.setDescription(request.getParameter("description"));
      dao.insert(vo);
      
      RequestDispatcher rd = 
          request.getRequestDispatcher("/subject/insert.jsp");
      rd.forward(request, response);
    }catch(Throwable e){
      e.printStackTrace();
    }
  }
  
}
