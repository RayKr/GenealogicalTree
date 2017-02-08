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

                <div class="alert alert-success">
                    <div class="box-body site-header" style="text-align: center; margin-bottom: 10px">
                        <h1>景氏家谱</h1>
                        <p>山东省莱芜市寨里镇水北街景氏家谱<br><span>共收录了 <strong>{{ site.personCount }}</strong> 条家族成员信息</span>
                        </p>
                        <div class="input-group input-group-lg">
                            <input id="pname" class="form-control input-lg" type="text" placeholder="输入名开始搜索...">
                            <span class="input-group-btn">
                                <button type="button" name="search" id="search-btn" class="btn btn-info btn-flat" onclick="submit();"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="box box-success">
                    <div class="box-header with-border">
                        <h3 class="box-title">搜索结果</h3>
                    </div>
                    <div class="box-body" id="search-result">
                        <%-- 结果列表 --%>
                        <ul class="nav nav-stacked" id="result-list">
                            <%--<li class="info-box">--%>
                                <%--<span class="info-box-icon bg-gray info-box-icon-sm"><i class="fa fa-user"></i></span>--%>

                                <%--<div class="info-box-content">--%>
                                    <%--<span class="info-box-text">景</span>--%>
                                    <%--<span class="info-box-number"><a href="http://ihave.news">汝和</a></span>--%>
                                <%--</div>--%>
                            <%--</li>--%>
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

    var submit = function () {
        console.info($("#pname").val());
        if ($("#pname").val()) {
            $.ajax({
                url: '/person/search',
                type: 'POST',
                dataType: 'json',
                data: {
                    name: $('#pname').val()
                },
                success: showResponse
            });
        }
    };
    var showResponse = function (responseText, statusText, xhr, $form) {
        console.info(responseText);
        if (responseText.success) {
            // 绑定json数据到页面
            BindPeople(responseText.result);
            // 展开结果列表
            $('.btn-box-tool').trigger('click');
        } else {
            toastr.error(responseText.msg);
        }
    };
</script>
</body>
</html>

