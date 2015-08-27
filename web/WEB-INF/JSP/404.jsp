<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
    Created by guillaume.vandecasteele on 27/08/2015 at 12:55.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<fmt:setBundle basename="resourceBundles.text"/>
<html lang="nl">
    <head>
        <vdab:head title="404ErrorTitle"/>
    </head>
    <body>
        <vdab:menu/>
        <h1><fmt:message key="404H1"/></h1>
        <p><fmt:message key="404P"/></p>
    </body>
</html>
