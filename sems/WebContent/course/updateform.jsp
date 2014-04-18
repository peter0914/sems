<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%
	CourseVo course = (CourseVo) request.getAttribute("course");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목변경폼</title>
<%@include file="../header.inc"%>
</head>
<body>
<%@include file="../body.inc"%>
  <h1>과목 변경폼(by JSP)</h1>
  <form action='update.bit' method='post'>
    번호: <input type='text' name='no' value='<%=course.getNo()%>' readonly><br>
    과목명: <input type='text' name='title' value='<%=course.getTitle()%>'>
    수강시간: <input type='text' name='time' value='<%=course.getTime()%>'><br>
    설명:
    <textarea name='description' rows='10' cols='80'><%=course.getDescription()%></textarea>
    <br> <input type='submit' value='변경'> <input type='button'
      value='취소' onclick="location.href='detail.bit?no=<%=course.getNo()%>'">
  </form>
  <%@include file="../footer.inc"%>
</body>
</html>












