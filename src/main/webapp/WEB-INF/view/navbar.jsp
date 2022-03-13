<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ page import = "java.io.*,java.util.*,com.epam.conference.entity.*" %>

<fmt:setLocale value="<%= request.getLocale().getLanguage() %>" scope="session"/>
<fmt:setBundle basename="pagecontent" />
<c:set var="user" value='<%= (User)session.getAttribute("user")%>' scope="session" />
<c:set var="isAdmin" value="${user.isAdmin}" scope="session" />

<div class="navbar">
  <c:choose>
   <c:when test = "${isAdmin}">
    <div class="ul">
        <div class="li">
            <a href="?command=requests"><fmt:message key="nav.requests" /></a>
        </div>
        <div class="li">
            <a href="?command=conferences"><fmt:message key="nav.conferences" /></a>
        </div>
        <div class="li dropdown">
            <a class="dropbtn"><fmt:message key="nav.create" /></a>
            <div class="dropdown-content">
              <a href="?command=conference-creation"><fmt:message key="nav.conference" /></a>
              <a href="?command=section-creation"><fmt:message key="nav.section" /></a>
          </div>
      </div>
  </div>
</c:when>

<c:otherwise>
  <div class="ul">
      <div class="li">
          <a href="?command=conferences"><fmt:message key="nav.conferences" /></a>
      </div>
      <div class="li">
          <a href="?command=requests"><fmt:message key="nav.requests" /></a>
      </div>
  </div>
</c:otherwise>
</c:choose>

</div>
