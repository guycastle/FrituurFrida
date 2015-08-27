<%-- 
    Document   : boyorgirl
    Created on : 30-Jun-2015, 15:45:01
    Author     : guillaume.vandecasteele
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<%@ page contentType='text/html' pageEncoding='utf-8'%>
<fmt:setBundle basename="resourceBundles.text"/>
<!DOCTYPE html>
<html>
    <head>
        <vdab:head title="gender"/>
    </head>
    <body>
        <vdab:menu/>
        <div class="content">
            <h1><fmt:message key="gender"/></h1>
            <form method="post">
                <label><fmt:message key="genderMale"/></label><input type="range" min="0" max="100" name="gender" value="${gender}" placeholder="50"/><Label><fmt:message key="genderFemale"/></label><br><br>
                <label><input type="checkbox" name="gender" value="agender"/><fmt:message key="genderNA"/></label><br><br>
                <input type="submit" value="<fmt:message key="genderSend"/>">
            </form>
        </div>
    </body>
</html>
