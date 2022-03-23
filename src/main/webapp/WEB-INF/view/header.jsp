<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java" %>
<%@ page import="java.io.*,java.util.*" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="pagecontent" />

<!--HEADER-->
<div class="header">
    <div class="logo">
        <a href="main">conferences</a>
    </div>
    <div class="icons-container">
        <div class="lang">
            <%--      <a href="?lang=ru">RU</a>--%>
            <%--      <a href="?lang=en">EN</a>--%>
            <%--      <a href="?lang=by">BY</a>--%>
            <%--      <a href="#"><img src="static/img/globe-32.png"></a>--%>
            <form>
                <select id="language" name="language" onchange="submit()">
                    <option value="ru" ${language == 'ru' ? 'selected' : ''}>RU</option>
                    <option value="en" ${language == 'en' ? 'selected' : ''}>EN</option>
                    <option value="by" ${language == 'by' ? 'selected' : ''}>BY</option>
                </select>
            </form>
        </div>

        <div class="logout">
            <a href="logout"><img src="static/img/logout-24.png"></a>
        </div>
    </div>
</div>
<!--END HEADER-->