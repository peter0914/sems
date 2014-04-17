<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%SubjectVo vo = (SubjectVo)request.getAttribute("subject");%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목 수정</title>
  <link rel="stylesheet" type="text/css" href="../sems.css">
</head>
<body>
<h1>과목 변경 by JSP</h1>
<form action="update.bit" method="post">
번호 : <input type="text" name="no" value="<%=vo.getNo()%>" readonly><br>
과목명 : <input type="text" name="title" value="<%=vo.getTitle()%>"><br>
설명 : <textarea rows="10" cols="80" name="description"><%=vo.getDescription()%></textarea><br>
<input type="submit" value="변경">
<input type="button" value="취소" onclick="location.href='detail.bit?no=<%=vo.getNo()%>'">
</form>
</body></html>