<%-- 
    Document   : teamAdd
    Created on : 10/05/2017, 15:46:11
    Author     : flavio.henrique
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rastreability Matrix</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap.css"/>" />
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
        <script src="<c:url value="/javascript/jquery-3.2.1.min.js"/>" type="text/javascript"></script>
        <script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
    </head>
    <body>
        <%@ include file="/templates/menu.jsp" %>

        <div class="content">
            <div class="content-limit">
                <h3 class="form-title">Member Register</h3>
                <hr>
                <form method="post">
                    <div class="form-group">
                        <label>Signum</label>
                        <input class="form-control" name="signum" placeholder="Enter Signum" required maxlength="7">
                    </div>
                    <div class="form-group">
                        <label>Name</label>
                        <input class="form-control" name="name" placeholder="Enter Name" required>
                    </div>
                    <div class="form-group">
                        <label>Role</label>
                        <select class="form-control" name="role">
                            <option>Developer</option>
                            <option>QA</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Team</label>
                        <select class="form-control" name="team">
                            <c:forEach items="${teams}" var="team">
                                <option value="${team.id}">${team.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
