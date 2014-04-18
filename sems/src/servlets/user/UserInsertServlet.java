package servlets.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UserVo;
import dao.UserDao;

@SuppressWarnings("serial")
@WebServlet("/user/insert.bit")
public class UserInsertServlet extends HttpServlet{

  
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try{
      UserDao dao = (UserDao)this.getServletContext()
          .getAttribute("userDao");
      
      UserVo vo = new UserVo();
      vo.setEmail(request.getParameter("email"));
      vo.setPwd(request.getParameter("password"));
      vo.setName(request.getParameter("name"));
      vo.setTel(request.getParameter("tel"));
      vo.setFax(request.getParameter("fax"));
      vo.setPostno(request.getParameter("postno"));
      vo.setAddr(request.getParameter("addr"));
      
      dao.insert(vo);
      
      request.setAttribute("user", vo);
      
      response.setHeader("Refresh", "1;url=list.bit?pageNo=1&pageSize=10");
    }catch(Throwable e){
      e.printStackTrace();
    }
  }
  
}
