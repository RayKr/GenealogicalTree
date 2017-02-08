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
    <title>成员信息 - 景氏家谱</title>
    <%@ include file="support/style.jsp" %>
</head>
<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper" id="post_body">

    <%@ include file="support/header_top.jsp" %>

    <div class="content-wrapper">
        <div class="container">

            <!-- Main content -->
            <section class="content">

                <div class="alert alert-success">
                    <div class="box-body site-header" style="text-align: center; margin-bottom: 10px">
                        <h1>景氏家谱</h1>
                        <p>山东省莱芜市寨里镇水北街景氏家谱<br><span>共收录了 <strong>{{ site.personCount }}</strong> 条家族成员信息</span>
                        </p>
                        <div class="input-group input-group-lg">
                            <input class="form-control input-lg" type="text" placeholder="输入名开始搜索...">
                            <span class="input-group-btn">
                                <button type="submit" name="search" id="search-btn" class="btn btn-info btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="box box-success collapsed-box">
                    <div class="box-header with-border">
                        <h3 class="box-title">搜索结果</h3>
                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="box-body">
                        <ul class="nav nav-stacked">
                            <li><a href="#">Projects <span class="pull-right badge bg-blue">31</span></a></li>
                            <li><a href="#">Tasks <span class="pull-right badge bg-aqua">5</span></a></li>
                            <li><a href="#">Completed Projects <span class="pull-right badge bg-green">12</span></a></li>
                            <li><a href="#">Followers <span class="pull-right badge bg-red">842</span></a></li>
                        </ul>
                    </div>

                </div>

            </section>

        </div>
    </div>

    <%@ include file="support/footer_top.jsp" %>
</div>

<%@ include file="support/script.jsp" %>
<script>
    $(function () {
        InitMenu('/initmenu', 'navbar-menu');
        InitSite('/siteinfo', 'post_body');
    });
</script>
</body>
</html>

