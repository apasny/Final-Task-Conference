<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java"%>
<%@ page import = "java.io.*,java.util.*" %>

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
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="static/scripts/create-section.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>

<body>

  <div class="container">

    <!--HEADER-->
    <jsp:include page="header.jsp" />

    <!--NAVBAR-->
    <jsp:include page="navbar.jsp" />

    <!--CONTENT-->
    <div class="create-content">
      <form method="post" action="main?command=create-section">
        <select name="conference" id="conference">
          <c:forEach var="item" items="${conferences}">
            <option value="${item.id}"><c:out value="${item.topic}"/></option>
          </c:forEach>
        </select>
        <input class="hidden" type="hidden" name="conference-id" value="" required/>
        <input class="data-input" type="text" name="topic" placeholder="topic" required/>
        <input class="data-input timepicker" type="text" name="start-time" placeholder="" required />
        <input class="data-input timepicker" type="text" name="end-time" placeholder="" required/>
        <input class="data-input" type="number" name="max-attendees" placeholder="attendees" min="1" value="1" required/>
        <button class="btn create" type="submit">Create</button>
      </form>
    </div>

    <!--FOOTER-->
    <jsp:include page="footer.jsp" />

  </div>

</body>
</html>
