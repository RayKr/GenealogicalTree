<%--
  Created by IntelliJ IDEA.
  User: jingz
  Date: 2017/2/7
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Flat UI - Free Bootstrap Framework and Theme</title>
    <meta name="description" content="Flat UI"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="/assets/vendor/flat-ui/dist/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Loading Flat UI -->
    <link href="/assets/vendor/flat-ui/dist/css/flat-ui.css" rel="stylesheet">
    <link href="/assets/vendor/flat-ui/docs/assets/css/demo.css" rel="stylesheet">
    <link rel="shortcut icon" href="/assets/vendor/flat-ui/img/favicon.ico">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="/assets/vendor/flat-ui/dist/js/vendor/html5shiv.js"></script>
    <script src="/assets/vendor/flat-ui/dist/js/vendor/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="row demo-row">
    <div class="col-xs-12">
        <nav class="navbar navbar-inverse navbar-embossed" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-01">
                    <span class="sr-only">Toggle navigation</span>
                </button>
                <%--<a class="navbar-brand" href="#">Jing Genealogy</a>--%>
                <form class="navbar-form navbar-right" action="#" role="search">
                    <div class="form-group">
                        <div class="input-group">
                            <input class="form-control" id="navbarInput-01" type="search" placeholder="Search">
                            <span class="input-group-btn">
                      <button type="submit" class="btn"><span class="fui-search"></span></button>
                    </span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse-01">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#fakelink">Menu Item<span class="navbar-unread">1</span></a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Messages <b class="caret"></b></a>
                        <span class="dropdown-arrow"></span>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>
                    <li><a href="#fakelink">About Us</a></li>
                </ul>

            </div><!-- /.navbar-collapse -->
        </nav><!-- /navbar -->
    </div>
</div> <!-- /row -->


<script src="/assets/vendor/flat-ui/dist/js/vendor/jquery.min.js"></script>
<script src="/assets/vendor/flat-ui/dist/js/vendor/video.js"></script>
<script src="/assets/vendor/flat-ui/dist/js/flat-ui.min.js"></script>
<script src="/assets/vendor/flat-ui/docs/assets/js/application.js"></script>

<script>
    videojs.options.flash.swf = "dist/js/vendors/video-js.swf"
</script>
</body>
</html>

