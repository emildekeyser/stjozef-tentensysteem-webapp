<%--
  Created by IntelliJ IDEA.
  User: Jpelgrims
  Date: 18/12/2018
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solve a test</title>
</head>
<body>
<!-- header contains MetaData -->
<%@ include file="components/header.jspf"%>

<!-- Navigation -->
<%@ include file="components/navigation.jspf"%>

<!-- Page Content -->

<div class="container">

    <form method="post">
        <c:forEach items="${questions}" var="question">
            <p>
                ${question.question}
            </p>
            <c:forEach items="${question.vragen}" var="vraag">
                <input type="radio" name="">${vraag} <br>
            </c:forEach>
        </c:forEach>
    </form>

</div>


<%@ include file="components/footer.jspf"%>
</body>
</html>
