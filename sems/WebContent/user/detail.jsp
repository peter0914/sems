<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%SubjectVo vo = (SubjectVo)request.getAttribute("detail");%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목 상세정보 by JSP</title>
</head>
<body>
<h1>과목 상세정보 by JSP</h1>
<table border='1'>
<tr>
<th>번호</th>
<td><%=vo.getNo()%></td>
</tr>
<tr>
<th>과목명</th>
<td><%=vo.getTitle()%></td>
</tr>
<tr>
<th>내용</th>
<td><textarea rows='5' cols='60' readonly><%=vo.getDescription()%></textarea></td>
</tr>
</table>
<a href='list.bit?pageNo=1&pageSize=10'>목록</a><br>
<a href='delete.bit?no=<%=vo.getNo()%>'>삭제</a> 
<a href='update.bit?no=<%=vo.getNo()%>'>변경</a><br>
</body></html>