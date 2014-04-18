<%@page import="vo.CourseVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
List<CourseVo> list = 
  (List<CourseVo>) request.getAttribute("list"); 
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">

<title>과정 목록</title>
<%@include file="../header.inc"%>
</head>
<body>
<%@include file="../body.inc"%>
<h1>과정 목록(byJSP)</h1>
<a href='form.html'>새과정</a><br>
<table>
<tr>
<th>번호</th>
<th>과정명</th>
<th>교육시간</th>
</tr>
<%for(CourseVo course : list) {%>
<tr>
  <td><%=course.getNo()%></td>
  <td><a href='detail.bit?no=<%=course.getNo()%>'><%=course.getTitle()%></a></td>
  <td><%=course.getTime()%></td>
</tr>
<%}%>

</table>
<%@include file="../footer.inc"%>
</body></html>


