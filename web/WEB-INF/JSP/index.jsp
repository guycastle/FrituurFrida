<%-- 
    Document   : index
    Created on : 25-Jun-2015, 09:39:17
    Author     : guillaume.vandecasteele
--%>

<%@ page contentType='text/html' pageEncoding='utf-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<fmt:setBundle basename="resourceBundles.text"/>
<!DOCTYPE html>
<html lang='nl'>
	<head>
        <vdab:head title="welcome"/>
	</head>
	<body>
        <vdab:menu/>
        <div class="content">
		    <h1><fmt:message key='welcomeHead1'/></h1>
            <br>
		    <h2><fmt:message key='welcomeAnnouncement'/></h2>
            <br>
            <c:choose>
                <c:when test="${closed}">
                    <img src="img/<fmt:message key="welcomeClosedImage"/>.png" alt="<fmt:message key="welcomeClosed"/>">
                </c:when>
                <c:otherwise>
                    <img src="img/<fmt:message key="welcomeOpenImage"/>.png" alt="<fmt:message key="welcomeOpen"/>">
                </c:otherwise>
            </c:choose>
            <br>
            <dl>
                <dd>${address.straat} ${address.huisNr}<br>
				${address.town.postCode} ${address.town.naam}</dd>
                <dt>Code</dt><dd>${locale}</dd>
		    </dl>
        </div>
	</body>
</html>