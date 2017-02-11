<%--
  Created by IntelliJ IDEA.
  User: jingz
  Date: 2017/2/9
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>个人信息 - 景氏家谱</title>
    <%@ include file="support/style.jsp" %>
</head>
<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper" id="post_body">
    <%@ include file="support/header_top.jsp" %>
    <div class="content-wrapper">
        <div class="container" id="detailinfo">
            <!-- Main content -->
            <section class="content">

                <div class="row">
                    <div class="col-md-4">
                        <!-- Widget: user widget style 1 -->
                        <div class="box box-widget widget-user">
                            <!-- Add the bg color to the header using any of the bg-* classes -->
                            <div class="widget-user-header bg-green">
                                <h3 class="widget-user-username" v-text="person.name"></h3>
                                <h5 class="widget-user-desc">字<span v-text="person.styleName"></span><br>号<span v-text="person.selfName"></span></h5>
                            </div>
                            <div class="widget-user-image">
                                <img class="img-circle" :src=person.portrait alt="User Avatar">
                            </div>
                            <div class="box-footer">
                                <div class="row">
                                    <div class="col-xs-4 border-right">
                                        <div class="description-block">
                                            <h5 class="description-header" v-text="person.branch"></h5>
                                            <span class="description-text">所属分支</span>
                                        </div>
                                        <!-- /.description-block -->
                                    </div>
                                    <!-- /.col -->
                                    <div class="col-xs-4 border-right">
                                        <div class="description-block">
                                            <h5 class="description-header" v-text="person.ancestralSeq"></h5>
                                            <span class="description-text">家族世序</span>
                                        </div>
                                        <!-- /.description-block -->
                                    </div>
                                    <!-- /.col -->
                                    <div class="col-xs-4">
                                        <div class="description-block">
                                            <h5 class="description-header" v-text="person.rank"></h5>
                                            <span class="description-text">兄弟排行</span>
                                        </div>
                                        <!-- /.description-block -->
                                    </div>
                                    <!-- /.col -->
                                </div>
                                <!-- /.row -->
                                <div class="row">
                                    <div class="col-sm-12">
                                        <ul class="nav nav-stacked">
                                            <li><a v-text="person.personMemo"></a></li>
                                            <li><a href="#"><i class="fa fa-birthday-cake"></i>生日：<span v-text="person.birthday"></span></a></li>
                                            <li><a href="#"><i class="fa fa-phone"></i>电话：<span v-text="person.cellphone"></span></a></li>
                                            <li><a href="#"><i class="fa fa-envelope"></i>邮箱：<span v-text="person.email"></span></a></li>
                                            <li><a href="#"><i class="fa fa-home"></i>住址：<span v-text="person.currentAddress"></span></a></li>
                                            <li><a href="#"><i class="fa fa-weixin"></i>微信：<span v-text="person.wechat"></span></a></li>
                                            <li><a href="#"><i class="fa fa-bank"></i>单位：<span v-text="person.profession"></span></a></li>
                                            <li><a href="#"><i class="fa fa-users"></i>职位：<span v-text="person.position"></span></a></li>
                                            <li><a href="#"><i class="fa fa-file"></i>备注：<span v-text="person.introduction"></span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.widget-user -->
                    </div>
                    <!-- /.col -->

                    <div class="col-md-8">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="box box-widget widget-user-2" style="margin-bottom: 0">
                                <div class="widget-user-header ">
                                    <b>人物关系</b>
                                </div>
                            </div>
                            <ul class="nav nav-tabs nav-relation">
                                <li class="active"><a href="#tab_1" data-toggle="tab">&nbsp;&nbsp;父母&nbsp;&nbsp;</a></li>
                                <li><a href="#tab_2" data-toggle="tab">&nbsp;&nbsp;同胞&nbsp;&nbsp;</a></li>
                                <li><a href="#tab_3" data-toggle="tab">&nbsp;&nbsp;配偶&nbsp;&nbsp;</a></li>
                                <li><a href="#tab_4" data-toggle="tab">&nbsp;&nbsp;子女&nbsp;&nbsp;</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tab_1">
                                    <%-- 亲生父母 --%>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="#">
                                                <div class="info-box bg-green">
                                                <span class="info-box-icon">
                                                    <img src="/assets/images/jing.jpg"alt="jing">
                                                </span>

                                                    <div class="info-box-content">
                                                        <span class="info-box-text">父</span>
                                                        <span class="info-box-number">月明</span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">70% Increase in 30 Days</span>
                                                    </div>
                                                    <!-- /.info-box-content -->
                                                </div>
                                                <!-- /.info-box -->
                                            </a>
                                        </div>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="#">
                                                <div class="info-box bg-yellow">
                                                <span class="info-box-icon">
                                                    <img src="/assets/images/women.jpg"alt="jing">
                                                </span>

                                                    <div class="info-box-content">
                                                        <span class="info-box-text">母</span>
                                                        <span class="info-box-number">纪长乐</span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">70% Increase in 30 Days</span>
                                                    </div>
                                                    <!-- /.info-box-content -->
                                                </div>
                                                <!-- /.info-box -->
                                            </a>
                                        </div>
                                    </div>
                                    <%-- 分割线 --%>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="box" style="margin-bottom: 15px"></div>
                                        </div>
                                    </div>
                                    <%-- 嗣父 --%>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="#">
                                                <div class="info-box bg-aqua">
                                                <span class="info-box-icon">
                                                    <img src="/assets/images/jing.jpg"alt="jing">
                                                </span>

                                                    <div class="info-box-content">
                                                        <span class="info-box-text">嗣父</span>
                                                        <span class="info-box-number">月华</span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">嗣胞叔月华公</span>
                                                    </div>
                                                    <!-- /.info-box-content -->
                                                </div>
                                                <!-- /.info-box -->
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="tab_2">
                                    <%-- 兄弟 --%>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="#">
                                                <div class="info-box bg-green">
                                                    <span class="info-box-icon">
                                                        <img src="/assets/images/jing.jpg"alt="jing">
                                                    </span>
                                                    <div class="info-box-content">
                                                        <span class="info-box-text">行一</span>
                                                        <span class="info-box-number">世清</span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">70% Increase in 30 Days</span>
                                                    </div>
                                                    <!-- /.info-box-content -->
                                                </div>
                                                <!-- /.info-box -->
                                            </a>
                                        </div>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="#">
                                                <div class="info-box bg-green">
                                                    <span class="info-box-icon">
                                                        <img src="/assets/images/jing.jpg"alt="jing">
                                                    </span>
                                                    <div class="info-box-content">
                                                        <span class="info-box-text">行三</span>
                                                        <span class="info-box-number">世明</span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">70% Increase in 30 Days</span>
                                                    </div>
                                                    <!-- /.info-box-content -->
                                                </div>
                                                <!-- /.info-box -->
                                            </a>
                                        </div>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="#">
                                                <div class="info-box bg-green">
                                                    <span class="info-box-icon">
                                                        <img src="/assets/images/jing.jpg"alt="jing">
                                                    </span>
                                                    <div class="info-box-content">
                                                        <span class="info-box-text">行四</span>
                                                        <span class="info-box-number">世强</span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">70% Increase in 30 Days</span>
                                                    </div>
                                                    <!-- /.info-box-content -->
                                                </div>
                                                <!-- /.info-box -->
                                            </a>
                                        </div>
                                    </div>
                                    <%-- 分割线 --%>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="box" style="margin-bottom: 15px"></div>
                                        </div>
                                    </div>
                                    <%-- 姐妹 --%>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="#">
                                                <div class="info-box bg-yellow">
                                                <span class="info-box-icon">
                                                    <img src="/assets/images/jing.jpg"alt="jing">
                                                </span>

                                                    <div class="info-box-content">
                                                        <span class="info-box-text">女一</span>
                                                        <span class="info-box-number">菲</span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">70% Increase in 30 Days</span>
                                                    </div>
                                                    <!-- /.info-box-content -->
                                                </div>
                                                <!-- /.info-box -->
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="tab_3">
                                    <%-- 配偶 --%>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="#">
                                                <div class="info-box bg-yellow">
                                                <span class="info-box-icon">
                                                    <img src="/assets/images/women.jpg"alt="jing">
                                                </span>

                                                    <div class="info-box-content">
                                                        <span class="info-box-text">配</span>
                                                        <span class="info-box-number">刘亦菲</span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">70% Increase in 30 Days</span>
                                                    </div>
                                                    <!-- /.info-box-content -->
                                                </div>
                                                <!-- /.info-box -->
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="tab_4">
                                    <%-- 子 --%>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="#">
                                                <div class="info-box bg-green">
                                                    <span class="info-box-icon">
                                                        <img src="/assets/images/jing.jpg"alt="jing">
                                                    </span>
                                                    <div class="info-box-content">
                                                        <span class="info-box-text">行一</span>
                                                        <span class="info-box-number">世清</span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">70% Increase in 30 Days</span>
                                                    </div>
                                                    <!-- /.info-box-content -->
                                                </div>
                                                <!-- /.info-box -->
                                            </a>
                                        </div>
                                    </div>
                                    <%-- 分割线 --%>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="box" style="margin-bottom: 15px"></div>
                                        </div>
                                    </div>
                                    <%-- 女 --%>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="#">
                                                <div class="info-box bg-yellow">
                                                <span class="info-box-icon">
                                                    <img src="/assets/images/jing.jpg"alt="jing">
                                                </span>

                                                    <div class="info-box-content">
                                                        <span class="info-box-text">女一</span>
                                                        <span class="info-box-number">菲</span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">70% Increase in 30 Days</span>
                                                    </div>
                                                    <!-- /.info-box-content -->
                                                </div>
                                                <!-- /.info-box -->
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.tab-pane -->
                            </div>
                            <!-- /.tab-content -->
                        </div>
                        <!-- nav-tabs-custom -->
                    </div>
                    <!-- /.col -->
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
        InitPersonData();
    });
</script>
</div>
</body>
</html>
