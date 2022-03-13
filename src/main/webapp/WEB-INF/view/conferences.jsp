<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java" %>
<%@ page import="java.io.*,java.util.*" %>

<c:set var="conferences" value='<%= request.getAttribute("conferences")%>'/>

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
            <c:forEach var="item" items="${conferences}">
                <c:choose>
                    <c:when test="${isAdmin}">
                        <div class="conference">
                            <p>CONFERENCE topic:<c:out value="${item.topic}"/></p>
                            <p>PLACE:<c:out value="${item.place}"/></p>
                            <form method="post"
                                  action="main?command=sections&id=${item.id}">
                                <button class="btn btn-request accept" type="submit">Sections</button>
                            </form>
                            <form method="post"
                                  action="main?command=delete&id=${item.id}">
                                <button class="btn btn-request cancel" type="submit">Delete</button>
                            </form>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="conference">
                            <p>CONFERENCE topic:<c:out value="${item.topic}"/></p>
                            <p>PLACE:<c:out value="${item.place}"/></p>
                            <form method="post"
                                  action="main?command=sections&id=${item.id}">
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
