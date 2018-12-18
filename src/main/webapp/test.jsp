<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- header contains MetaData -->
<%@ include file="components/header.jspf"%>

<!-- Navigation -->
<%@ include file="components/navigation.jspf"%>

<!-- Page Content -->
<main>
    <article>
        <c:out value="${tent.name}" />
        <div class="container">
            <form method="post" action="test">
                <c:forEach items="${tent.questions}" var="question">
                    <p>
                            ${question.value}
                    </p>
                    <c:forEach items="${question.answers}" var="answer">
                        <input type="radio" name="${answer.value}">${answer.value} <br>
                    </c:forEach>
                </c:forEach>
                <input type="hidden" value="${tent.placeNumber}">
                <input type="submit" value="KNOP">
            </form>

        </div>
    </article>
</main>