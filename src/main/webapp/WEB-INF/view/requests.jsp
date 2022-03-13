<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java" %>
<%@ page import="java.io.*,java.util.*" %>

<c:set var="usersRequests" value='<%= request.getAttribute("usersRequests")%>'/>

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
    <div class="requests-content">
        <c:forEach var="item" items="${usersRequests}">
            <div class="request">
                <p>Request from USER.NAME USER.SURNAME</p>
                <p>CONFERENCE topic: </p>
                <c:choose>
                    <c:when test="${isAdmin}">
                        <div class="btn btn-request accept" type="submit" action="controller?command=accept">Accept
                        </div>
                        <div class="btn btn-request cancel" type="submit" action="controller?command=decline">Decline
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="btn btn-request cancel" type="submit" action="controller?command=cancel">Cancel
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>
    </div>

    <!--FOOTER-->
    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>
