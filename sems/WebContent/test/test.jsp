<%@page import="vo.UserVo"%>
<%@page import="java.util.List"%>
<%@page import="vo.CourseVo"%>
<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<SubjectVo> sublist = (List<SubjectVo>)request.getAttribute("sublist");
List<CourseVo> courlist = (List<CourseVo>) request.getAttribute("courlist"); 
List<UserVo> userlist = (List<UserVo>)request.getAttribute("userlist");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Multiple Servlet</title>
</head>
<body>
<div>
<h1>과목 목록 by JSP</h1>
<a href='form.html'>새과목</a><br>
<table>
<tr>
<th>번호</th>
<th>과목명</th>
</tr>
<%for(SubjectVo sub : sublist){%>
<tr>
<td><%=sub.getNo()%></td>
<td><a href='detail.bit?no=<%=sub.getNo()%>'><%=sub.getTitle()%></a></td>
</tr>
<%}%>
</table>
</div>
<div>
<h1>과정 목록(byJSP)</h1>
<a href='form.html'>새과정</a><br>
<table>
<tr>
<th>번호</th>
<th>과정명</th>
<th>교육시간</th>
</tr>
<%for(CourseVo course : courlist) {%>
<tr>
  <td><%=course.getNo()%></td>
  <td><a href='detail.bit?no=<%=course.getNo()%>'><%=course.getTitle()%></a></td>
  <td><%=course.getTime()%></td>
</tr>
<%}%>
</table>
</div>
<div>
<h1>사용자 목록 by JSP</h1>
<a href='form.html'>새사용자</a><br>
<table border='1'>
<tr>
<th>번호</th>
<th>이름</th>
<th>전화</th>
<th>이메일</th>
</tr>
<%for(UserVo user : userlist){%>
<tr>
<td><%=user.getNo()%></td>
<td><a href='detail.bit?no=<%=user.getNo()%>'><%=user.getName()%></a></td>
<td><%=user.getTel()%></td>
<td><%=user.getEmail()%></td>
</tr>
<%}%>
</table>
</div>
</body>
</html>