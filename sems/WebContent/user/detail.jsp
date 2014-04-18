<%@page import="vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%UserVo vo = (UserVo)request.getAttribute("detail");%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>사용자 상세정보 by JSP</title>
  <%@include file="../header.inc"%>
</head>
<body>
<%@include file="../body.inc"%>
<h1>사용자 상세정보 by JSP</h1>
<table border='1'>
<tr>
<th>번호</th>
<td><%=vo.getNo()%></td>
</tr>
<tr>
<th>이름</th>
<td><%=vo.getName()%></td>
</tr>
<tr>
<th>전화번호</th>
<td><%=vo.getTel()%></td>
</tr>
<tr>
<th>이메일</th>
<td><%=vo.getEmail()%></td>
</tr>
<tr>
<th>팩스</th>
<td><%=vo.getFax()%></td>
</tr>
<tr>
<th>우편번호</th>
<td><%=vo.getPostno()%></td>
</tr>
<tr>
<th>주소</th>
<td><%=vo.getAddr()%></td>
</tr>
</table>
<a href='list.bit?pageNo=1&pageSize=10'>목록</a><br>
<a href='delete.bit?no=<%=vo.getNo()%>'>삭제</a> 
<a href='update.bit?no=<%=vo.getNo()%>'>변경</a><br>
<%@include file="../footer.inc"%>
</body></html>