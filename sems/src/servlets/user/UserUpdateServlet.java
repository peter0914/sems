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
@WebServlet("/user/update.bit")
public class UserUpdateServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사용자변경</title></head><body>");
    try{
      int no = Integer.parseInt(request.getParameter("no"));
      UserDao dao = (UserDao)this.getServletContext()
          .getAttribute("userDao");
      UserVo vo = dao.detail(no);
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>사용자변경폼</title>");
      out.println("<link rel='stylesheet' type='text/css' href='../sems.css'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>사용자 변경</h1>");
      out.println("<form action='update.bit' method='post'>");
      out.println("번호 : <input type='text' name='no' value='" 
          + vo.getNo() 
          + "' readonly><br>");
      out.println("이름 : <input type='text' name='name' value='"
          + vo.getName()
          + "'><br>");
      out.println("전화번호 : <input type='text' name='tel' value='"
          + vo.getTel()
          + "'><br>");
      out.println("이메일 : <input type='text' name='email' value='"
          + vo.getEmail()
          + "'><br>");
      out.println("팩스 : <input type='text' name='fax' value='"
          + vo.getFax()
          + "'><br>");
      out.println("우편번호 : <input type='text' name='postno' value='"
          + vo.getPostno()
          + "'><br>");
      out.println("주소 : <input type='text' name='addr' value='"
          + vo.getAddr()
          + "'><br>");
      out.println("<input type='submit' value='변경'>");
      out.println("<input type='button' value='취소'"); 
      out.println("onclick='location.href=\"detail.bit?no="
          + vo.getNo()
          + "\"'>");
      out.println("</form>");
      out.println("</body>");
      out.println("</html>");
      
    }catch(Throwable e){
      out.println("오류 발생");
    }
    out.println("</body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사용자변경</title>");
    out.println("<link rel='stylesheet' type='text/css' href='../sems.css'>");
    out.println("</head><body>");
    out.println("<h1>사용자 변경</h1>");
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
      
      out.println("변경 성공!");
      
      response.sendRedirect("detail.bit?no="+vo.getNo());
      
    }catch(Throwable e){
      out.println("오류 발생");
    }
    out.println("</body></html>");
  }
  
}
