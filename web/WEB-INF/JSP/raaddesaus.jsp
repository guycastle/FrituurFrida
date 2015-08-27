<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<%--
    Created by guillaume.vandecasteele on 17/08/2015 at 22:20.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="resourceBundles.text"/>
<fmt:message key="guessTheSauceWon" var="won"/>
<fmt:message key="guessTheSauceLost" var="lost"/>
<html>
    <head>
        <vdab:head title="guessTheSauce"/>
    </head>
    <body>
        <vdab:menu/>
        <div class="content">
            <h1><fmt:message key="guessTheSauce"/></h1>
            <c:choose>
                <c:when test="${guessGame.won}">
                    <fmt:message key="guessTheSauceEndGame">
                        <fmt:param value="${won}"/>
                        <fmt:param value="${guessGame.solution}"/>
                    </fmt:message>
                </c:when>
                <c:when test="${guessGame.attempts >= 10}">
                    <fmt:message key="guessTheSauceEndGame">
                        <fmt:param value="${lost}"/>
                        <fmt:param value="${guessGame.solution}"/>
                    </fmt:message>
                </c:when>
                <c:otherwise>

                    <fmt:message key="guessTheSauceSauce">
                        <fmt:param value="${guessGame.progress}"/>
                    </fmt:message>
                    <form method="post">
                        <label><fmt:message key="guessTheSauceLetter"/>
                            <input type="text" name="guess" autofocus required maxlength="1" size="1"/>
                        </label><br>
                        <input type="submit" value="<fmt:message key="guessTheSauceGuess"/>"/>
                    </form>
                </c:otherwise>
            </c:choose>
            <br>
            <br>
            <form method="post">
                <input type="submit" name="newGame" value="<fmt:message key="newGame"/>">
            </form>
            <br>
            <br>
            <c:if test="${guessGame.attempts <= 10}">
                <img src="<c:url value='/img/${guessGame.attempts}.png'/>" alt="${guessGame.attempts} pogingen">
            </c:if>
        </div>
    </body>
</html>
