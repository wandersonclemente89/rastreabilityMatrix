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
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>  
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
        <script src="<c:url value="/javascript/jquery-3.2.1.min.js"/>" type="text/javascript"></script>
        <script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid content-limit">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand navbar-brand-custom" href="<c:url value="/index.html"/>"><img class="logo-img" src="<c:url value="/images/ericssonLogo.png"/>" /></a>

                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Team <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Add</a></li>
                            </ul>
                        </li>
                        <li class="active"><a class="active" href="#">Sprints <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">BUCs</a></li>

                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="content">
            <div class="content-limit">
                <form>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Name</label>
                        <input class="form-control" name="name" placeholder="Enter name">
                    </div>
                    <div class="form-group">
                        <label for="project">Project</label>
                        <select class="form-control" name="project">
                            <option>RM OM</option>
                            <option>CBIO</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
