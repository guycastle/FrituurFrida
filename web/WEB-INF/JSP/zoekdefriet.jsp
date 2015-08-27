<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
    Created by guillaume.vandecasteele on 17/08/2015 at 14:57.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="resourceBundles.text"/>
<html>
    <head>
        <fmt:message key="findTheFry" var="suffix"/>
        <fmt:message key="headTitle" var="titleContent">
            <fmt:param value="${suffix}"/>
        </fmt:message>
        <c:import url="/WEB-INF/JSP/head.jsp">
            <c:param name='title' value='${titleContent}'/>
        </c:import>
    </head>
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp"/>
        <div class="content">
            <h1><fmt:message key="findTheFry"/></h1>
            <br>
            <c:if test="${fryGame.won}">
                <h2><fmt:message key="findTheFryCongrats"/></h2>
            </c:if>
            <c:if test="${!fryGame.won}"><form method="post" id="openForm"></c:if>
                <c:forEach var="entry" items="${fryGame.progress}">
                    <button type="submit" name="door" value="${entry.key}" class="openDoor">
                        <c:choose>
                            <c:when test="${entry.value and entry.key == fryGame.fryLocation}">
                                <img src="<c:url value='/img/gevonden.png'/>" alt="gevonden">
                            </c:when>
                            <c:when test="${entry.value and entry.key != fryGame.fryLocation}">
                                <img src="<c:url value='/img/deuropen.png'/>" alt="Open">
                            </c:when>
                            <c:otherwise>
                                <img src="<c:url value='/img/deurtoe.png'/>" alt="Toe">
                            </c:otherwise>
                        </c:choose>
                    </button>
                </c:forEach>
            <c:if test="${!fryGame.won}"></form></c:if>
            <br>
            <br>
            <form method="post">
                <input type="submit" name="newGame" value="<fmt:message key="newGame"/>"/>
            </form>
        </div>
    </body>
</html>
