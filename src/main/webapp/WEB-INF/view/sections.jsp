<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java" %>
<%@ page import="java.io.*,java.util.*" %>

<c:set var="sections" value='<%= request.getAttribute("sections")%>'/>

<!DOCTYPE html>
<html lang="en">
<title>Conference</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="static/styles/reset.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="static/styles/main.css">

<body>

<div class="container">

    <!--HEADER-->
    <jsp:include page="header.jsp"/>

    <!--NAVBAR-->
    <jsp:include page="navbar.jsp"/>

    <!--CONTENT-->
    <div class="content">
        <div class="conferences-content">
            <c:forEach var="item" items="${sections}">
                <c:choose>
                    <c:when test="${isAdmin}">
                        <div class="section">
                            <p>SECTION topic:<c:out value="${item.topic}"/></p>
                            <p>ID:<c:out value="${item.id}"/></p>
                            <form method="post"
                                  action="main?command=delete&id=${item.id}">
                                <button class="btn btn-request cancel" type="submit">Delete</button>
                            </form>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="section">
                            <p>SECTION topic:<c:out value="${item.topic}"/></p>
                            <p>ID:<c:out value="${item.id}"/></p>
                            <form method="post"
                                  action="main?command=apply&section-id=${item.id}">
                                <button class="btn btn-request apply" type="submit">Apply</button>
                            </form>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </div>

    <!--FOOTER-->
    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>
