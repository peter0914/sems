package servlets.course;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import dao.CourseDao;

@WebServlet("/course/list.bit")
@SuppressWarnings("serial")
public class CourseListServlet extends HttpServlet{

  @Override
  protected void doGet(
  		HttpServletRequest request, HttpServletResponse response)
  		    throws ServletException, IOException {
    try{
      CourseDao dao = (CourseDao)this.getServletContext()
            										.getAttribute("courseDao");
      
      int pageNo = Integer.parseInt(request.getParameter("pageNo"));
      int pageSize = Integer.parseInt(request.getParameter("pageSize"));
      
    List<CourseVo> list = dao.list(pageNo, pageSize);
      
      request.setAttribute("list", list);
      
			RequestDispatcher rd = 
					request.getRequestDispatcher("/course/list.jsp");
			rd.forward(request, response);
      
    }catch(Throwable e){
      e.printStackTrace();
    }
  }
  
}
