package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;

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
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사용자 등록</title></head><body>");
    out.println("<h1>사용자 등록 결과</h1>");
    try{
      UserDao dao = (UserDao)this.getServletContext()
          .getAttribute("userDao");
      out.println("chk");
      
      UserVo vo = new UserVo();
      vo.setEmail(request.getParameter("email"));
      out.println(request.getParameter("password"));
      vo.setPwd(request.getParameter("password"));
      vo.setName(request.getParameter("name"));
      vo.setTel(request.getParameter("tel"));
      vo.setFax(request.getParameter("fax"));
      vo.setPostno(request.getParameter("postno"));
      vo.setAddr(request.getParameter("addr"));
      
      dao.insert(vo);
      
      out.println("등록 성공!");
      
      response.setHeader("Refresh", "1;url=list.bit?pageNo=1&pageSize=10");
    }catch(Throwable e){
      out.println(e);
      out.println("오류 발생");
    }
    out.println("</body></html>");
  }
  
}
