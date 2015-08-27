<%-- 
    Document   : sauzen
    Created on : 25-Jun-2015, 10:59:16
    Author     : guillaume.vandecasteele
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<%@ page contentType='text/html' pageEncoding='utf-8' session='false'%>
<fmt:setBundle basename="resourceBundles.text"/>
<!DOCTYPE html>
<html>
	<head>
        <vdab:head title="sauces"/>
	</head>
	<body>
        <vdab:menu/>
        <div class="content">
            <h1><fmt:message key="sauces"/></h1>
            <ul class="zebra">
                <form method="post" id="removeform">
                    <c:forEach var='sauce' items="${sauzen}">
                        <li><input type="checkbox" name="sauce" value="${sauce.nummer}"><img src="<c:url value='/img/${sauce.imageName}.png'/>" alt="${sauce.naam}">${sauce.nummer}: ${sauce.naam} (<%--
                        --%><c:forEach var="ingredient" items="${sauce.ingredienten}" varStatus="status"><%--
                            --%>${ingredient}<c:if test="${!status.last}">, </c:if><%--
                        --%></c:forEach><%--
                        --%>)</li>
                    </c:forEach><span>${errors.sauce}</span>
                    <input type="submit" value="<fmt:message key="saucesDelete"/>" id="removebutton">
                </form>
            </ul>
        </div>
	</body>
</html>
