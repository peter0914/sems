package servlets.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import vo.SubjectVo;
import vo.UserVo;
import dao.CourseDao;
import dao.SubjectDao;
import dao.UserDao;

@WebServlet("/test/test.bit")
public class test extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int pageNo = Integer.parseInt(request.getParameter("pageNo"));
      int pageSize = Integer.parseInt(request.getParameter("pageSize"));
      SubjectDao subdao = (SubjectDao) this.getServletContext().getAttribute(
          "subjectDao");
      List<SubjectVo> sublist = subdao.list(pageNo, pageSize);
      request.setAttribute("sublist", sublist);
      UserDao userdao = (UserDao) this.getServletContext().getAttribute(
          "userDao");
      List<UserVo> userlist = userdao.list(pageNo, pageSize);
      request.setAttribute("userlist", userlist);
      CourseDao courdao = (CourseDao) this.getServletContext().getAttribute(
          "courseDao");
      List<CourseVo> courlist = courdao.list(pageNo, pageSize);
      
      request.setAttribute("courlist", courlist);
      RequestDispatcher rd = request.getRequestDispatcher("/test/test.jsp");
      rd.forward(request, response);
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }

}
