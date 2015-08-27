<%-- 
    Document   : sauzenperingredient
    Created on : 29-Jun-2015, 13:16:28
    Author     : guillaume.vandecasteele
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<fmt:setBundle basename="resourceBundles.text"/>
<!DOCTYPE html>
<html>
	<head>
        <vdab:head title="saucesByIngredient"/>
	</head>
	<body>
        <vdab:menu/>
        <div class="content">
            <h1><fmt:message key="saucesByIngredient"/></h1>
            <form>
                <label><fmt:message key="saucesBIIngredient"/>:
                    <input name="ingredient" value="${param.ingredient}" autofocus type="search" placeholder="<fmt:message key="saucesBIRequired"/>" required>
                </label>
                <input type="submit" value="<fmt:message key="saucesBISearch"/>">
            </form>
            <c:choose>
                <c:when test="${not empty sauzen}">
                    <ul><br><br><br>
                        <c:forEach var="entry" items="${sauzen}">
                            <li><img src="<c:url value='/img/${entry.value.naam}.png'/>" alt="${entry.value.naam}">${entry.key}: ${entry.value.naam} (<%--
                            --%><c:forEach var="ingredient" items="${entry.value.ingredienten}" varStatus="status"><%--
                            --%>${ingredient}<c:if test="${!status.last}">, </c:if><%--
                            --%></c:forEach><%--
                            --%>)</li><br><br><br><br><br>
                        </c:forEach>
                    </ul>
                </c:when>
                <c:when test="${empty sauzen and not errors}">
                    <fmt:message key="saucesBINotFound"/>
                </c:when>
            </c:choose>
        </div>
	</body>
</html>
