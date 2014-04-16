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
@WebServlet("/user/detail.bit")
public class UserDetailServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>상세정보</title></head><body>");
    out.println("<h1>사용자 상세정보</h1>");
    try{
      UserDao dao = (UserDao)this.getServletContext()
          .getAttribute("userDao");
      
      int no = Integer.parseInt(request.getParameter("no"));
      UserVo user = dao.detail(no);
      
      out.println("<table border='1'");
      out.println("<tr>");
      out.println("<th>번호</th>");
      out.println("<td>"+user.getNo()+"</td>");
      out.println("</tr>");
      out.println("<tr>");
      out.println("<th>사용자명</th>");
      out.println("<td>"+user.getName()+"</td>");
      out.println("</tr>");
      out.println("<tr>");
      out.println("<th>전화</th>");
      out.println("<td>"+user.getDescription()+"</textarea></td>");
      out.println("</tr>");
      
      out.println("</table>");
      out.println("<a href='list.bit?pageNo=1&pageSize=10'>목록</a><br>");
      out.println("<a href='delete.bit?no="
          + user.getNo()
          + "'>삭제</a> ");
      out.println("<a href='update.bit?no="
          + user.getNo()
          + "'>변경</a><br>");
    }catch(Throwable e){
      out.println(e);
      out.println("오류 발생");
    }
    out.println("</body></html>");
  }
  
}
