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
        <link rel="stylesheet" href="<c:url value="/css/bootstrap-select.min.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
        <script src="<c:url value="/javascript/jquery-3.2.1.min.js"/>" type="text/javascript"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/javascript/bootstrap-select.min.js"/>"></script>
        <script>
            $(document).ready(function () {
                $('#brTable').DataTable();
                $('#trTable').DataTable();
                $('#tcTable').DataTable();
            });
        </script>

    </head>
    <body>
        <%@ include file="/templates/menu.jsp" %>
        <div class="content">
            <div class="content-limit">
                <div>
                    <div class="col-md-12">
                        <div class="col-md-10">
                            <h3>${BUC.name}</h3>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Business Requirements</a></li>
                            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Technical Requirements</a></li>
                            <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Test Cases</a></li>
                            <a href="<c:url value="/report?bucId=${BUC.id}"/>">
                            <button type="button" class="btn btn-primary generate-report" >
                                Generate Report
                            </button>
                            </a>
                        </ul>


                        <!-- Tab panes -->
                        <div class="tab-content col-md-12">
                            <div role="tabpanel" class="tab-pane active" id="home">
                                <div class="content-tab">
                                    <%@ include file="/templates/brContentTab.jsp" %>
                                </div>
                            </div>
                            <div role="tabpanel2" class="tab-pane" id="profile">
                                <div class="content-tab">
                                    <%@ include file="/templates/trContentTab.jsp"  %>
                                </div>
                            </div>
                            <div role="tabpane3" class="tab-pane" id="messages">
                                <div class="content-tab">
                                    <%@ include file="/templates/tcContentTab.jsp" %>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>
