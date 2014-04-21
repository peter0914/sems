<%@page import="vo.SubjectVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<SubjectVo> sublist = (List<SubjectVo>)request.getAttribute("sublist");
%>
<h1>과목 목록 by JSP</h1>
<a href='form.html'>새과목</a><br>
<table>
<tr>
<th>번호</th>
<th>과목명</th>
</tr>
<%for(SubjectVo vo : sublist){%>
<tr>
<td><%=vo.getNo()%></td>
<td><a href='detail.bit?no=<%=vo.getNo()%>'><%=vo.getTitle()%></a></td>
</tr>
<%}%>
</table>
