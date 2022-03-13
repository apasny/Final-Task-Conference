<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java"%>
<%@ page import = "java.io.*,java.util.*" %>

<fmt:setLocale value="<%= request.getLocale().getLanguage() %>" />
<fmt:setBundle basename="pagecontent" />

<!DOCTYPE html>
<html lang="<%= request.getLocale().getLanguage() %>">
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
    <jsp:include page="header.jsp" />

    <!--NAVBAR-->
    <jsp:include page="navbar.jsp" />

    <!--CONTENT-->

    <!--FOOTER-->
    <jsp:include page="footer.jsp" />

  </div>

</body>
</html>
