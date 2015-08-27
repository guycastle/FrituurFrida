<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<%--
    Created by guillaume.vandecasteele on 18/08/2015 at 07:46.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="resourceBundles.text"/>
<fmt:message key="statsProcessedSingular" var="procSing"/>
<fmt:message key="statsProcessedPlural" var="procPlur"/>
<fmt:message key="statsRequestPlural" var="reqPlur"/>
<fmt:message key="statsRequestSingular" var="reqSing"/>
<html>
    <head>
        <vdab:head title="stats"/>
    </head>
    <body>
        <vdab:menu/>
        <div class="content">
            <h1>${suffix}</h1>
            <ul class="stats">
                <c:forEach var="entry" items="${aantalRequests}">
                    <li>${entry.key}: ${entry.value} ${entry.value > 1 ? reqPlur : reqSing} ${entry.value > 1 ? procPlur : procSing}</li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
