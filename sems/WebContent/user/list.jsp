<%@page import="vo.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<UserVo> list = (List<UserVo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>사용자 목록</title>
</head>
<body>
<h1>사용자 목록 by JSP</h1>
<a href='form.html'>새사용자</a><br>
<table border='1'>
<tr>
<th>번호</th>
<th>이름</th>
<th>전화</th>
<th>이메일</th>
</tr>
<%for(UserVo vo : list){%>
<tr>
<td><%=vo.getNo()%></td>
<td><a href='detail.bit?no=<%=vo.getNo()%>'><%=vo.getName()%></a></td>
<td><%=vo.getTel()%></td>
<td><%=vo.getEmail()%></td>
</tr>
<%}%>
</table>
</body></html>