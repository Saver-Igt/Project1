<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="database.User"
    %>
<%
	if(session.getAttribute("role") != User.ROLE.ADMIN){
		response.sendRedirect("login.jsp");
	
	//	request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello admin!
</body>
</html>