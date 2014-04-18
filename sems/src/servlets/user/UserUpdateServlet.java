package servlets.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UserVo;
import dao.UserDao;

@SuppressWarnings("serial")
@WebServlet("/user/update.bit")
public class UserUpdateServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try{
      int no = Integer.parseInt(request.getParameter("no"));
      UserDao dao = (UserDao)this.getServletContext()
          .getAttribute("userDao");
      UserVo vo = dao.detail(no);
      request.setAttribute("user", vo);
      
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
      UserDao dao = (UserDao)this.getServletContext()
          .getAttribute("userDao");
      
      UserVo vo = new UserVo();
      vo.setNo(Integer.parseInt(request.getParameter("no")));
      vo.setName(request.getParameter("name"));
      vo.setEmail(request.getParameter("email"));
      vo.setFax(request.getParameter("fax"));
      vo.setTel(request.getParameter("tel"));
      vo.setPostno(request.getParameter("postno"));
      vo.setAddr(request.getParameter("addr"));
      
      dao.update(vo);
      
      
      response.sendRedirect("detail.bit?no="+vo.getNo());
      
    }catch(Throwable e){
      e.printStackTrace();
    }
  }
  
}
