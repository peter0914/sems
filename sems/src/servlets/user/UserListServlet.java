package servlets.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UserVo;
import dao.UserDao;

@SuppressWarnings("serial")
@WebServlet("/user/list.bit")
public class UserListServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try{
      UserDao dao = (UserDao)this.getServletContext()
            .getAttribute("userDao");
      
      int pageNo = Integer.parseInt(request.getParameter("pageNo"));
      int pageSize = Integer.parseInt(request.getParameter("pageSize"));
      List<UserVo> list = dao.list(pageNo, pageSize);
      
      request.setAttribute("list", list);
      
      RequestDispatcher rd = 
          request.getRequestDispatcher("/user/list.jsp");
      rd.forward(request, response);
    }catch(Throwable e){
      e.printStackTrace();
    }
  }
  
}
