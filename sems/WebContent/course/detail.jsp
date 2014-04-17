<%@page import="vo.CourseVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
CourseVo course = (CourseVo) request.getAttribute("course"); 
%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목상세정보</title>
</head>
<title>상세정보</title>
<body>
<h1>과목 상세정보(by JSP)</h1>
<table border='1'>
<tr>
<th>번호</th>
<td><%=course.getNo()%></td>
</tr>
<tr>
<th>과정명</th>
<td><%=course.getTitle()%></td>
</tr>
<tr>
<th>내용</th>
<td><textarea row='5' cols='60' readonly><%=course.getDescription()%></textarea></td>
</tr>
<tr>
<th>수강시간</th>
<td><%=course.getTime() %></td>
</tr>
</table>
<a href='list.bit?pageNo=1&pageSize=10'>목록</a> 
<a href='delete.bit?no=<%=course.getNo()%>'>삭제</a> 
<a href='update.bit?no=<%=course.getNo()%>'>변경</a><br>
</body></html>
