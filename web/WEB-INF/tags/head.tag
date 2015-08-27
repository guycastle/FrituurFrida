<%--
    Created by guillaume.vandecasteele on 27/08/2015 at 18:57.
 --%>
<%@ tag description='head tag for every page' pageEncoding='UTF-8' %>
<%@ attribute name="title" required="true" type="java.lang.String" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:message key="${param.title}" var="suffix"/>
<fmt:message key="headTitle" var="titleContent">
    <fmt:param value="${suffix}"/>
</fmt:message>
<title><c:out value="${titleContent}"/></title>
<link rel='shortcut icon' href='<c:url value="/img/favicon.ico"/>' type='image/x-icon'/>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='<c:url value="/css/default.css"/>'>
<c:if test='${not empty colors}'>
    <style>
        body {
            background-color: #${colors.background};
            color: #${colors.textColor};
        }

        header {
            background-color: #${colors.menuBackground};
        }

        .topmenu ul li a:hover, a:active, a.actief {
            background-color: #${colors.menuBackgroundActive};
        }
    </style>
</c:if>