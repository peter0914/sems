package servlets.course;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  doGet(request, response);
	}
	
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try{
      CourseDao dao = (CourseDao)this.getServletContext()
          .getAttribute("courseDao");
      
      CourseVo vo = new CourseVo();
      vo.setTitle(request.getParameter("title"));
      vo.setDescription(request.getParameter("description"));
      vo.setTime(Integer.parseInt(request.getParameter("time")));
      
      dao.insert(vo);
      
			RequestDispatcher rd = 
					request.getRequestDispatcher("/course/insert.jsp");
			rd.forward(request, response);
      
      
    }catch(Throwable e){
    	e.printStackTrace();
    }
  }
  
}
