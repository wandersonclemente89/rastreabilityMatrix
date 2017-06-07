
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<html>
    <head>
        <title>Rastreability Matrix</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>  
        <link rel="stylesheet" href="css/style.css"/>
        <script src="javascript/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@ include file="/templates/menu.jsp" %>
        <div class="content">
            <div class="content-limit">
                <div class="row">
                    <c:forEach items="${teams}" var="team">
                        <div class="col-md-3">
                        <a href="<c:url value="/team?id=${team.id}"/>">
                            <div class="jumbotron jumbotron-custom">
                                <h2>${team.name}</h2>
                                <p><span class="glyphicon glyphicon-plus-sign"></span></p>
                            </div>
                        </a>
                        </div>
                    </c:forEach>
                    
                </div>
            </div>
        </div>
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>
