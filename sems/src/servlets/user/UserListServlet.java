package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사용자 목록</title></head><body>");
    out.println("<h1>사용자 목록</h1>");
    try{
      UserDao dao = (UserDao)this.getServletContext()
            .getAttribute("userDao");
      
      int pageNo = Integer.parseInt(request.getParameter("pageNo"));
      int pageSize = Integer.parseInt(request.getParameter("pageSize"));
      List<UserVo> list = dao.list(pageNo, pageSize);
      
      out.println("<a href='form.html'>새 사용자</a><br>");
      out.println("<table border='1'");
      out.println("<tr>");
      out.println("<th>번호</th>");
      out.println("<th>이름</th>");
      out.println("<th>전화</th>");
      out.println("<th>이메일</th>");
      out.println("</tr>");
      
      for(UserVo user : list){
        out.println("<tr><td>");
        out.println(user.getNo());
        out.println("</td>");
        out.println("<td><a href='detail.bit?no="
            + user.getNo()
            + "'>");
        out.println(user.getName());
        out.println("</a></td>");
        out.println("<td>"+user.getTel()+"</td>");
        out.println("<td>"+user.getEmail()+"</td>");
        out.println("</tr>");
      }
      out.println("</table>");
    }catch(Throwable e){
      out.println(e);
      out.println("오류 발생");
    }
    out.println("</body></html>");
  }
  
}
