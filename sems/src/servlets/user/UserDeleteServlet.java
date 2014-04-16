package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@SuppressWarnings("serial")
@WebServlet("/user/delete.bit")
public class UserDeleteServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사용자 삭제</title></head><body>");
    out.println("<h1>사용자 삭제 결과</h1>");
    try{
      UserDao dao = (UserDao)this.getServletContext()
          .getAttribute("userDao");
      
      int no = Integer.parseInt(request.getParameter("no"));
      
      dao.delete(no);
      
      out.println("삭제 성공!");
      
      // 3) Redirect 처리
      //  - contents를 출력하지 않기 때문에 이전의 출력은 취소된다.
      response.sendRedirect("list.bit?pageNo=1&pageSize=10");
    }catch(Throwable e){
      out.println(e);
      out.println("오류 발생");
    }
    out.println("</body></html>");
  }
  
}
