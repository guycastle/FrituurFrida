<%-- 
    Document   : menu
    Created on : 25-Jun-2015, 15:12:06
    Author     : guillaume.vandecasteele
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType='text/html' pageEncoding='utf-8'%>
<fmt:setBundle basename="resourceBundles.text"/>
<header>
    <nav class="topmenu">
        <ul>
            <li><a href="<c:url value='/index.htm'/>"><fmt:message key="welcome"/></a></li><!--
            --><li><a href="<c:url value='/sauzen.htm'/>"><fmt:message key="sauces"/></a></li><!--
            --><li><a href='<c:url value="/sauzen/sauzenperingredient.htm"/>'><fmt:message key="saucesByIngredient"/></a></li><!--
            --><li><a href="<c:url value="/gender.htm"/>"><fmt:message key="gender"/></a></li><!--
            --><li><a href="<c:url value='/games/zoekdefriet.htm'/>"><fmt:message key="findTheFry"/></a></li><!--
            --><li><a href="<c:url value='/games/raaddesaus.htm'/>"><fmt:message key="guessTheSauce"/></a></li><!--
            --><li><a href="<c:url value='/statistieken.htm'/>"><fmt:message key="stats"/></a></li>
        </ul>
    </nav>
</header>