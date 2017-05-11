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
            <a class="navbar-brand navbar-brand-custom" href="<c:url value='/'/>"><img class="logo-img" src="<c:url value="/images/ericssonLogo.png"/>" /></a>

        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Team <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/team/add"/>">Add</a></li>
                    </ul>
                </li>
                <li class="active"><a class="active" href="#">Sprints <span class="sr-only">(current)</span></a></li>
                <li><a href="#">BUCs</a></li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>