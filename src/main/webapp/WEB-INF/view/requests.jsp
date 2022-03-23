<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java" %>
<%@ page import="java.io.*,java.util.*" %>

<c:set var="dtos" value='<%= request.getAttribute("dtos")%>'/>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="pagecontent" />

<!DOCTYPE html>
<html lang="${param.lang}">
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
        <c:forEach var="item" items="${dtos}">
            <div class="request">
                <c:choose>
                    <c:when test="${isAdmin}">
                        <p>Request from user ${item.getUser().getName()} ${item.getUser().getSurname()}</p>
                        <p>CONFERENCE topic: ${item.getConference().getTopics()} SECTION: ${item.getSection().getTopic()}</p>
                        <div class="btn btn-request accept" type="submit" action="controller?command=accept">Accept
                        </div>
                        <div class="btn btn-request cancel" type="submit" action="controller?command=decline">Decline
                        </div>
                    </c:when>
                    <c:otherwise>
                        <p>Request for SECTION: ${item.getSection().getTopic()} on time ${item.getSection().getStartTime()}</p>
                        <p>CONFERENCE topic: ${item.getConference().getTopics()} on date ${item.getConference().getStartDate()}</p>
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
