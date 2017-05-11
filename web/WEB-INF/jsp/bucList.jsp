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
                $('#teamTable').DataTable();
            });
        </script>

    </head>
    <body>
        <%@ include file="/templates/menu.jsp" %>
        <div class="content">
            <div class="content-limit">
                <h3 class="form-title">BUCs</h3>
                <hr>
                <table id="teamTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Tiger Nixon</td>
                            <td>System Architect</td>
                            <td>
                                <button type="button" class="btn btn-default" aria-label="Left Align">
                                    <span class="glyphicon glyphicon-pencil"/>
                                </button>
                                <button type="button" class="btn btn-danger" aria-label="Left Align">
                                    <span class="glyphicon glyphicon glyphicon-trash"/>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>Garrett Winters</td>
                            <td>Accountant</td>
                            <td>
                                 <button type="button" class="btn btn-default" aria-label="Left Align">
                                    <span class="glyphicon glyphicon-pencil"/>
                                </button>
                                <button type="button" class="btn btn-danger" aria-label="Left Align">
                                    <span class="glyphicon glyphicon glyphicon-trash"/>
                                </button>
                            </td>
                        </tr>

                        <tr>
                            <td>Doris Wilder</td>
                            <td>Sales Assistant</td>
                            <td>
                                 <button type="button" class="btn btn-default" aria-label="Left Align">
                                    <span class="glyphicon glyphicon-pencil"/>
                                </button>
                                <button type="button" class="btn btn-danger" aria-label="Left Align">
                                    <span class="glyphicon glyphicon glyphicon-trash"/>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>Angelica Ramos</td>
                            <td>Chief Executive Officer (CEO)</td>
                            <td>
                                 <button type="button" class="btn btn-default" aria-label="Left Align">
                                    <span class="glyphicon glyphicon-pencil"/>
                                </button>
                                <button type="button" class="btn btn-danger" aria-label="Left Align">
                                    <span class="glyphicon glyphicon glyphicon-trash"/>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>Gavin Joyce</td>
                            <td>Developer</td>
                            <td>
                                 <button type="button" class="btn btn-default" aria-label="Left Align">
                                    <span class="glyphicon glyphicon-pencil"/>
                                </button>
                                <button type="button" class="btn btn-danger" aria-label="Left Align">
                                    <span class="glyphicon glyphicon glyphicon-trash"/>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>Donna Snider</td>
                            <td>Customer Support</td>
                            <td>
                                 <button type="button" class="btn btn-default" aria-label="Left Align">
                                    <span class="glyphicon glyphicon-pencil"/>
                                </button>
                                <button type="button" class="btn btn-danger" aria-label="Left Align">
                                    <span class="glyphicon glyphicon glyphicon-trash"/>
                                </button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
