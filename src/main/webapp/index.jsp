<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ page import = "java.io.*,java.util.*,com.epam.conference.entity.*" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="pagecontent" />

<html lang="${param.lang}">
<head>
    <link rel="stylesheet" href="static/styles/login.css"/>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script type="text/javascript" src="static/scripts/login.js"></script>
</head>
<body>
<div class="lang">
    <form class="language">
        <select id="language" name="language" onchange="submit()">
            <option value="ru" ${language == 'ru' ? 'selected' : ''}>RU</option>
            <option value="en" ${language == 'en' ? 'selected' : ''}>EN</option>
            <option value="by" ${language == 'by' ? 'selected' : ''}>BY</option>
        </select>
    </form>
</div>
<div class="login-page">
    <main class="form">
        <form class="login-form" method="post" action="login">
            <h1 class=""><fmt:message key="login.welcome" /></h1>
            <input name="login" type="text" class="form-control" id="floatingInput" placeholder="<fmt:message key="login.login" />">
            <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="<fmt:message key="login.password" />">
            <button class="" type="submit"><fmt:message key="login.signin" /></button>
            <p class="message"><fmt:message key="login.notregistered" />? <a href="#"><fmt:message key="login.create-account" /></a></p>
        </form>
        <form class="register-form">
            <h1 class="">Registration</h1>
            <input type="text" placeholder="name"/>
            <input type="password" placeholder="password"/>
            <input type="text" placeholder="email address"/>
            <button>create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
    </main>
</div>
</body>
</html>



