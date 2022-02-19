<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ page import = "java.io.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<title>Conference</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="static/styles/reset.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="static/styles/main.css">

<%
   boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
%>

<body>

  <div class="container">

    <!--HEADER-->
    <jsp:include page="header.jsp" />

    <!--NAVBAR-->
      <c:if test="${isAdmin}">
        <jsp:include page="admin-navbar.jsp" />
      </c:if>
      <c:if test="${!isAdmin}">
        <jsp:include page="user-navbar.jsp" />
      </c:if>

    <!--CONTENT-->
    <div class="content">
      <form method="post" action="controller?command=create">
        <input class="data-input" type="text" name="topic" placeholder="topic" required/>
        <input class="data-input" type="date" name="start-date" placeholder="" required />
        <input class="data-input" type="date" name="end-date" placeholder="" required/>
        <input class="data-input" type="text" name="place" placeholder="place" required/>
        <button class="btn apply" type="submit">Create</button>
      </form>
    </div>
    <!--END CONTENT-->

    <!--FOOTER-->
    <jsp:include page="footer.jsp" />

  </div>

</body>
</html>
