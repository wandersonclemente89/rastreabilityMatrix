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
                $('#memberTable').DataTable();
            });
        </script>

    </head>
    <body>
        <%@ include file="/templates/menu.jsp" %>
        <div class="content">
            <div class="content-limit">
                <h3 class="form-title">Members</h3>
                <hr>
                <table id="memberTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>Signum</th>
                            <th>Name</th>
                            <th>Role</th>
                            <th>Team</th>
                            <th>Project</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${members}" var="member">
                            <tr>
                                <td>${member.signum}</td>
                                <td>${member.name}</td>
                                <td>${member.role}</td>
                                <td>${member.employeeTeamName}</td>
                                <td>${member.employeeProject}</td>
                                <td>
                                    <a href="<c:url value="/member/update?id=${member.signum}"/>">   
                                    <button type="button" class="btn btn-default" aria-label="Left Align">
                                        <span class="glyphicon glyphicon-pencil"/>
                                    </button>
                                    </a>
                                    <a href="<c:url value="/member/delete?id=${member.signum}"/>">
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
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>
