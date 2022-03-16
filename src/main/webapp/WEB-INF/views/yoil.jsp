<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>year=<%=request.getParameter("year") %></h1>
<p>${year }년 ${month }월 ${day }일은 ${yoil }요일 입니다.
<p>${myDate.year }년 ${myDate.month }월 ${myDate.day }일은 ${yoil }요일 입니다.
</body>
</html>