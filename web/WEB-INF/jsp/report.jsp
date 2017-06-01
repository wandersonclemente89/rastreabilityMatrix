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
        <link rel="stylesheet" href="<c:url value="/css/admin.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/font-awesome.min.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
        <script src="<c:url value="/javascript/jquery-3.2.1.min.js"/>" type="text/javascript"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/javascript/bootstrap-select.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/javascript/chart.js"/>"></script>
        
    </head>
    <body>
        <%@ include file="/templates/menu.jsp" %>
        <div class="content">
            <div class="content-limit">
                <div class="row">
                <div class="col-md-4">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class=""><h3>${BUC.name}<h3></div>
                                                <div><h4>80% Covered</h4></div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                    </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> User Stories
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="panel-group " role="tablist">
                                <c:forEach items="${businessRequirements}" var="businessRequirement">
                                    <div class="panel panel-default">
                                        <div class="panel-heading" role="tab" id="collapseListGroupHeading1">
                                            <h4 class="panel-title"> <a href="#collapse-${businessRequirement.id}" class="" role="button" data-toggle="collapse" aria-expanded="true" aria-controls="collapseListGroup1"> ${businessRequirement.name}  <span class="qt-tcs label label-success">14</span></a></h4>
                                        </div>
                                        <div class="panel-collapse collapse" role="tabpanel" id="collapse-${businessRequirement.id}" aria-labelledby="collapseListGroupHeading1"
                                             aria-expanded="true">
                                            <ul class="list-group">
                                                <li class="list-group-item bg-danger">Bootply</li>
                                                <li class="list-group-item">One itmus ac facilin</li>
                                                <li class="list-group-item">Second eros</li>
                                            </ul>
                                        </div>
                                    </div>
                                   
                                </c:forEach>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                        
                        
                    </div>
                    <div class="col-md-6">
                        test
                        <canvas id="myChart" width="400" height="400"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<script type="text/javascript" src="<c:url value="/javascript/script.js"/>"></script>
