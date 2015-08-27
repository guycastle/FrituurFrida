<%-- 
    Document   : head
    Created on : 25-Jun-2015, 10:47:30
    Author     : guillaume.vandecasteele
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType='text/html' pageEncoding='utf-8'%>
<title><c:out value="${param.title}"/></title>
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
