<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java"%>
<%@ page import = "java.io.*,java.util.*" %>

<c:set var="usersRequests" value='<%= request.getAttribute("usersRequests")%>'/>
  <c:set var="conferences" value='<%= request.getAttribute("conferences")%>'/>

    <div class="content">
      <c:if test='<%= request.getServletPath().equals("/WEB-INF/view/conferences.jsp") %>'>
        <div class="conferences-content">
          <c:forEach var="item" items="${conferences}">
            <c:choose>
              <c:when test="${isAdmin}">
                <div class="conference">
                  <p>CONFERENCE topic:<c:out value="${item.topic}"/></p>
                  <p>ID:<c:out value="${item.id}"/>, PLACE:<c:out value="${item.place}"/></p>
                  <div class="btn btn-request cancel" type="submit" action="main?command=delete&id=${item.id}">Delete</div>
                </div>
              </c:when>
              <c:otherwise>
                <div class="conference">
                  <p>CONFERENCE topic:<c:out value="${item.topic}"/></p>
                  <p>ID:<c:out value="${item.id}"/>, PLACE:<c:out value="${item.place}"/></p>
                  <div class="btn btn-request apply" type="submit">Apply</div>
                </div>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </div>
      </c:if>


      <c:if test='<%= request.getServletPath().equals("/WEB-INF/view/requests.jsp") %>'>
        <div class="requests-content">
          <c:forEach var="item" items="${usersRequests}">
            <div class="request">
              <p>Request from USER.NAME USER.SURNAME</p>
              <p>CONFERENCE topic: <c:out value="${item.topic}"/>, ID:<c:out value="${item.id}"/></p>
              <c:choose>
               <c:when test = "${isAdmin}">
                <div class="btn btn-request accept" type="submit" action="controller?command=accept">Accept</div>
                <div class="btn btn-request cancel" type="submit" action="controller?command=decline">Decline</div>
              </c:when>
              <c:otherwise>
                <div class="btn btn-request cancel" type="submit" action="controller?command=cancel">Cancel</div>
              </c:otherwise>
            </c:choose>
          </div>
        </c:forEach>
      </div>
    </c:if>

    <c:if test='<%= request.getServletPath().equals("/WEB-INF/view/create-conference.jsp") %>'>
      <div class="create-content">  
        <form method="post" action="controller?command=create-conference">
          <input class="data-input" type="text" name="topic" placeholder="topic" required/>
          <input class="data-input" type="date" name="start-date" placeholder="" required />
          <input class="data-input" type="date" name="end-date" placeholder="" required/>
          <input class="data-input" type="text" name="place" placeholder="place" required/>
          <button class="btn apply" type="submit">Create</button>
        </form>
      </div>
    </c:if>

    <c:if test='<%= request.getServletPath().equals("/WEB-INF/view/create-section.jsp") %>'>
      <div class="create-content">
        <form method="post" action="controller?command=create-section">
          <input class="data-input" type="text" name="topic" placeholder="topic" required/>
          <input class="data-input" type="date" name="start-date" placeholder="" required />
          <input class="data-input" type="date" name="end-date" placeholder="" required/>
          <input class="data-input" type="text" name="place" placeholder="place" required/>
          <button class="btn apply" type="submit">Create</button>
        </form>
      </div>
    </c:if>

  </div>