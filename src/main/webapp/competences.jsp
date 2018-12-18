<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- header contains MetaData -->
<%@ include file="components/header.jspf"%>

<!-- Navigation -->
<%@ include file="components/navigation.jspf"%>

<!-- Page Content -->
<main>
    <h2>
        Hier vind je alle tenten terug!
    </h2>
    <article>
        <ul>
            <c:forEach items="${competences}" var="competence">
                <!--<img src="static/images/tentIcon2" alt="tent icon">-->
                <li>${competence.name}</li>
            </c:forEach>
        </ul>
    </article>
    <article>

        <a id="start" href="test">Start jouw test!</a>



    </article>
</main>