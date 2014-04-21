<%@page import="vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%UserVo vo = (UserVo)request.getAttribute("user");%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>사용자 수정</title>
  <%@include file="../header.inc"%>
</head>
<body>
<%@include file="../body.inc"%>
<h1>사용자 변경 by JSP</h1>
<form action="update.bit" method="post">
번호 : <input type="text" name="no" value="<%=vo.getNo()%>" readonly><br>
이름 : <input type="text" name="name" value="<%=vo.getName()%>"><br>
전화 : <input type="text" name="tel" value="<%=vo.getTel()%>"><br>
이메일 : <input type="text" name="email" value="<%=vo.getEmail()%>"><br>
팩스 : <input type="text" name="fax" value="<%=vo.getFax()%>"><br>
우편번호 : <input type="text" name="postno" value="<%=vo.getPostno()%>"><br>
주소 : <input type="text" name="addr" value="<%=vo.getAddr()%>"><br>
<input type="submit" value="변경">
<input type="button" value="취소" onclick="location.href='detail.bit?no=<%=vo.getNo()%>'">
</form>
<%@include file="../footer.inc"%>
</body></html>