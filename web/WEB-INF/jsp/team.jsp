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
                $('#memberTable, #bucsTable').DataTable();
            });
        </script>

    </head>
    <body>
        <%@ include file="/templates/menu.jsp" %>
        <div class="content">
            <div class="content-limit">
                <div class="col-md-12"><h3 class="">${team.name}</h3><hr></div>

                <div class="col-md-6">
                    <div class="panel panel-primary filterable">
                        <div class="panel-heading">
                            <h3 class="panel-title">Members</h3>
                        </div>
                        <table id="memberTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>Signum</th>
                                    <th>Name</th>
                                    <th>Role</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${memberList}" var="member">
                                    <tr>
                                        <td>${member.signum}</td>
                                        <td>${member.name}</td>
                                        <td>${member.role}</td>
                                        
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel panel-primary filterable">
                        <div class="panel-heading">
                            <h3 class="panel-title">BUCs</h3>
                        </div>
                        <table id="bucsTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${bucList}" var="buc">
                                    <tr>
                                        <td>${buc.id}</td>
                                        <td>${buc.name}</td>
                                        <td>
                                            <a href="<c:url value="/buc?id=${buc.id}"/>">
                                                <button type="button" class="btn btn-default" aria-label="Left Align">
                                                    <span class="glyphicon glyphicon glyphicon glyphicon-search"/>
                                                </button>
                                            </a>
                                    
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>