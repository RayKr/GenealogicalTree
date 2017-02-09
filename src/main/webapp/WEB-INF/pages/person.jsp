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
            <section class="content" id="search-section">
                <%-- 搜索 --%>
                <div class="alert alert-success">
                    <div class="box-body site-header" style="text-align: center; margin-bottom: 10px">
                        <h1>景氏家谱</h1>
                        <p>山东省莱芜市寨里镇水北街景氏家谱<br><span>共收录了 <strong>{{ site.personCount }}</strong> 条家族成员信息</span>
                        </p>
                        <div class="input-group input-group-lg">
                            <input id="pname" class="form-control input-lg" type="text" placeholder="输入名开始搜索...">
                            <span class="input-group-btn">
                                <button type="button" name="search" id="search-btn" class="btn btn-info btn-flat"
                                        onclick="doSearch($('#pname').val());"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </div>
                </div>
                <%-- 提示 --%>
                <div id="index-tip" class="alert alert-info alert-dismissible" style="display: none">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <i class="icon fa fa-hand-o-down"></i>点击搜索结果以查看详细个人信息！
                </div>
                <%-- 卡片形式信息显示 --%>
                <div class="row" id="card-list"></div>
                <!-- /.row -->
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

