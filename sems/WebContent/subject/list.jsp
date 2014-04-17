<%@page import="vo.SubjectVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<SubjectVo> list = (List<SubjectVo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목 목록</title>
  <link rel="stylesheet" type="text/css" href="../sems.css">
</head>
<body>
<h1>과목 목록 by JSP</h1>
<a href='form.html'>새과목</a><br>
<table>
<tr>
<th>번호</th>
<th>과목명</th>
</tr>
<%for(SubjectVo vo : list){%>
<tr>
<td><%=vo.getNo()%></td>
<td><a href='detail.bit?no=<%=vo.getNo()%>'><%=vo.getTitle()%></a></td>
</tr>
<%}%>
</table>
</body></html>