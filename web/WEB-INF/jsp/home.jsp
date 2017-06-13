
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <%@ include file="/templates/menuHome.jsp" %>
        <div class="content">
            <div class="content-limit">
                
                <div class="row ">
                    <div class="align-center">
                        <h3 class="title-home">Quality Tools</h3>
                        <hr>
                        <a href="<c:url value="/rastreabilityMatrix"/>">
                            <div class="col-md-2 tool-box rastr-box">
                                <img class="" src="<c:url value="/images/rastreability.png"/>" />
                                <h4>Rastreability Matrix</h4>
                            </div>
                        </a>
                        <div class="col-md-2 tool-box eda-box">
                            <img class="" src="<c:url value="/images/eda-icon.png"/>" />
                            <h4>EDA</h4>
                        </div>
                        <div class="col-md-2 tool-box gerrit-box">
                            <img class="" src="<c:url value="/images/gerrit-icon.png"/>" />
                            <h4>Gerrit Metrics</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>
