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
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#BRTable').DataTable();
            });
        </script>

    </head>
    <body>
        <%@ include file="/templates/menu.jsp" %>
        <div class="content">
            <div class="content-limit">
                <div>
                    <h3>${BUC.name}</h3>
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Business Requirements</a></li>
                        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Technical Requirements</a></li>
                        <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Test Case</a></li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <div>
                                <table id="BRTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sprints}" var="sprint">
                                            <tr>
                                                <td>${sprint.id}</td>
                                                <td>${sprint.name}</td>
                                                <td>

                                                    <button type="button" class="btn btn-default" aria-label="Left Align">
                                                        <span class="glyphicon glyphicon-pencil"/>
                                                    </button>
                                                    <a href="<c:url value="/team/delete?id=${sprint.id}"/>">
                                                        <button type="button" class="btn btn-danger" aria-label="Left Align">
                                                            <span class="glyphicon glyphicon glyphicon-trash"/>
                                                        </button>
                                                    </a>

                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="profile">...</div>
                        <div role="tabpanel" class="tab-pane" id="messages">...</div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>