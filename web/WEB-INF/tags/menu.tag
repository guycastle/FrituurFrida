<%--
    Created by guillaume.vandecasteele on 27/08/2015 at 18:57.
 --%>
<%@ tag description='banner menu for site' pageEncoding='UTF-8' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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