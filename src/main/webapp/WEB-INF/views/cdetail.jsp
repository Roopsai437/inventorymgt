<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>List of Computers </title>
</head>
<body>

<h1>List of Computers </h1>

id is <c:out value="${computer.id}"  />
<br>
name is <c:out value="${computer.name}"  />
<br>
disk size is <c:out value="${computer.diskSize}"  />
<br>

</body>
</html>