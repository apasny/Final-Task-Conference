<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java"%>
<%@ page import = "java.io.*,java.util.*" %>

<div class="navbar">
  <c:choose>
   <c:when test = '<%= (boolean)session.getAttribute("role") %>'>
    <div class="ul">
        <div class="li">
            <a href="requests">Requests</a>
        </div>
        <div class="li">
            <a href="conferences">Conferences</a>
        </div>
        <div class="li dropdown">
            <a class="dropbtn">Create</a>
            <div class="dropdown-content">
              <a href="create-conference">Conference</a>
              <a href="create-section">Section</a>
          </div>
      </div>
  </div>
</c:when>

<c:otherwise>
  <div class="ul">
      <div class="li">
          <a href="conferences">Conferences</a>
      </div>
      <div class="li">
          <a href="requests">Requests</a>
      </div>
  </div>
</c:otherwise>
</c:choose>

</div>


