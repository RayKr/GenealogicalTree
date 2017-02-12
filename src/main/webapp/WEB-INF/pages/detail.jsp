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
                                <img v-if="person.portrait" class="img-circle" :src=person.portrait alt="User Avatar">
                                <img v-else class="img-circle" src="/assets/images/jing.jpg" alt="User Avatar">
                            </div>
                            <div class="box-footer">
                                <div class="row">
                                    <div class="col-xs-4 border-right">
                                        <div class="description-block">
                                            <h5 class="description-header" v-if="person.branch" v-text="person.branch"></h5>
                                            <h5 class="description-header" v-else>不详</h5>
                                            <span class="description-text">所属分支</span>
                                        </div>
                                        <!-- /.description-block -->
                                    </div>
                                    <!-- /.col -->
                                    <div class="col-xs-4 border-right">
                                        <div class="description-block">
                                            <h5 class="description-header" v-if="person.ancestralSeq" v-text="person.ancestralSeq"></h5>
                                            <h5 class="description-header" v-else>不详</h5>
                                            <span class="description-text">家族世序</span>
                                        </div>
                                        <!-- /.description-block -->
                                    </div>
                                    <!-- /.col -->
                                    <div class="col-xs-4">
                                        <div class="description-block">
                                            <h5 class="description-header" v-if="person.rank" v-text="person.rank"></h5>
                                            <h5 class="description-header" v-else-if="person.sex === 1">独子</h5>
                                            <h5 class="description-header" v-else=>独女</h5>
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
                                            <li><a ><i class="fa fa-birthday-cake"></i>生日：<span v-text="person.birthday"></span></a></li>
                                            <li><a ><i class="fa fa-phone"></i>电话：<span v-text="person.cellphone"></span></a></li>
                                            <li><a ><i class="fa fa-envelope"></i>邮箱：<span v-text="person.email"></span></a></li>
                                            <li><a ><i class="fa fa-home"></i>住址：<span v-text="person.currentAddress"></span></a></li>
                                            <li><a ><i class="fa fa-weixin"></i>微信：<span v-text="person.wechat"></span></a></li>
                                            <li><a ><i class="fa fa-bank"></i>单位：<span v-text="person.profession"></span></a></li>
                                            <li><a ><i class="fa fa-users"></i>职位：<span v-text="person.position"></span></a></li>
                                            <li><a ><i class="fa fa-file"></i>备注：<span v-text="person.introduction"></span></a></li>
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
                                        <%-- 父 --%>
                                        <div v-if="person.father" class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="javascript:void(0);" onclick="openCard(this)">
                                                <input class="card_id" hidden="hidden" v-model="person.father.pid">
                                                <div class="info-box bg-green">
                                                <span class="info-box-icon">
                                                    <img v-if="person.father.portraitUrl" :src=person.father.portraitUrl alt="jing">
                                                    <img v-else src="/assets/images/jing.jpg"alt="jing">
                                                </span>
                                                    <div class="info-box-content">
                                                        <span class="info-box-text">父</span>
                                                        <span class="info-box-number" v-text="person.father.name"></span>
                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">字 <span v-text="person.father.styleName"></span>&nbsp; 号 <span v-text="person.father.selfName"></span> </span>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                        <%-- 母 --%>
                                        <div v-if="person.mother" class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="javascript:void(0);" onclick="openCard(this)">
                                                <input class="card_id" hidden="hidden" v-model="person.mother.pid">
                                                <div class="info-box bg-yellow">
                                                <span class="info-box-icon">
                                                    <img v-if="person.mother.portraitUrl" :src=person.mother.portraitUrl alt="jing">
                                                    <img v-else src="/assets/images/women.jpg"alt="jing">
                                                </span>

                                                    <div class="info-box-content">
                                                        <span class="info-box-text">母</span>
                                                        <span class="info-box-number">
                                                            <span v-if="person.mother.name" v-text="person.mother.name"></span>
                                                            <span v-else>不详</span>
                                                        </span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">
                                                            <span v-if="person.mother.memo" v-text="person.mother.memo"></span>
                                                        </span>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                    <%-- 分割线 --%>
                                    <div v-if="person.heirfather" class="row">
                                        <div class="col-xs-12">
                                            <div class="box" style="margin-bottom: 15px"></div>
                                        </div>
                                    </div>
                                    <%-- 嗣父 --%>
                                    <div class="row">
                                        <div v-if="person.heirfather" class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="javascript:void(0);" onclick="openCard(this)">
                                                <input class="card_id" hidden="hidden" v-model="person.heirfather.pid">
                                                <div class="info-box bg-aqua">
                                                <span class="info-box-icon">
                                                    <img v-if="person.heirfather.portraitUrl" :src=person.heirfather.portraitUrl alt="jing">
                                                    <img v-else src="/assets/images/jing.jpg"alt="jing">
                                                </span>

                                                    <div class="info-box-content">
                                                        <span class="info-box-text">嗣父</span>
                                                        <span class="info-box-number" v-text="person.heirfather.name"></span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">
                                                            字 <span v-text="person.heirfather.styleName"></span>&nbsp;
                                                            号 <span v-text="person.heirfather.selfName"></span>&nbsp;
                                                            <span v-if="person.heirfather.memo" v-text="person.heirfather.memo"></span>
                                                        </span>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="tab_2">
                                    <%-- 兄弟 --%>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6 col-xs-12" v-for="brother in person.brothers" v-if="brother.sex === 1">
                                            <a href="javascript:void(0);" onclick="openCard(this)">
                                                <input class="card_id" hidden="hidden" v-model="brother.pid">
                                                <div class="info-box"  v-bind:class="brother.sex === 1 ? 'bg-green' : 'bg-yellow'">
                                                    <span class="info-box-icon">
                                                        <img v-if="brother.portraitUrl" :src=brother.portraitUrl alt="jing">
                                                        <img v-else src="/assets/images/jing.jpg"alt="jing">
                                                    </span>
                                                    <div class="info-box-content">
                                                        <span class="info-box-text" v-text="brother.rank"></span>
                                                        <span class="info-box-number" v-text="brother.name"></span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">
                                                            字 <span v-text="brother.styleName"></span>&nbsp;
                                                            号 <span v-text="brother.selfName"></span>&nbsp;
                                                            <span v-if="brother.memo" v-text="brother.memo"></span>
                                                        </span>
                                                    </div>
                                                </div>
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
                                        <div class="col-md-6 col-sm-6 col-xs-12" v-for="brother in person.brothers" v-if="brother.sex === 0">
                                            <a href="javascript:void(0);" onclick="openCard(this)">
                                                <input class="card_id" hidden="hidden" v-model="brother.pid">
                                                <div class="info-box"  v-bind:class="brother.sex === 1 ? 'bg-green' : 'bg-yellow'">
                                                    <span class="info-box-icon">
                                                        <img v-if="brother.portraitUrl" :src=brother.portraitUrl alt="jing">
                                                        <img v-else src="/assets/images/jing.jpg"alt="jing">
                                                    </span>
                                                    <div class="info-box-content">
                                                        <span class="info-box-text" v-text="brother.rank"></span>
                                                        <span class="info-box-number" v-text="brother.name"></span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">
                                                            字 <span v-text="brother.styleName"></span>&nbsp;
                                                            号 <span v-text="brother.selfName"></span>&nbsp;
                                                            <span v-if="brother.memo" v-text="brother.memo"></span>
                                                        </span>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="tab_3">
                                    <%-- 配偶 --%>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <a href="javascript:void(0);" onclick="openCard(this)">
                                                <input class="card_id" hidden="hidden" v-model="person.spouse.pid">
                                                <div class="info-box bg-yellow">
                                                <span class="info-box-icon">
                                                    <img v-if="person.spouse.portraitUrl" :src=person.spouse.portraitUrl alt="jing">
                                                    <img v-else src="/assets/images/women.jpg"alt="jing">
                                                </span>

                                                    <div class="info-box-content">
                                                        <span class="info-box-text">配</span>
                                                        <span class="info-box-number">
                                                            <span v-if="person.spouse.name" v-text="person.spouse.name"></span>
                                                            <span v-else>不详</span>
                                                        </span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">
                                                            <span v-if="person.spouse.memo" v-text="person.spouse.memo"></span>
                                                        </span>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="tab_4">
                                    <%-- 子 --%>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6 col-xs-12" v-for="child in person.children" v-if="child.sex === 1">
                                            <a href="javascript:void(0);" onclick="openCard(this)">
                                                <input class="card_id" hidden="hidden" v-model="child.pid">
                                                <div class="info-box"  v-bind:class="child.sex === 1 ? 'bg-green' : 'bg-yellow'">
                                                <span class="info-box-icon">
                                                    <img v-if="child.portraitUrl" :src=child.portraitUrl alt="jing">
                                                    <img v-else src="/assets/images/jing.jpg"alt="jing">
                                                </span>
                                                    <div class="info-box-content">
                                                        <span class="info-box-text" v-text="child.rank"></span>
                                                        <span class="info-box-number" v-text="child.name"></span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">
                                                        字 <span v-text="child.styleName"></span>&nbsp;
                                                        号 <span v-text="child.selfName"></span>&nbsp;
                                                        <span v-if="child.memo" v-text="child.memo"></span>
                                                    </span>
                                                    </div>
                                                </div>
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
                                        <div class="col-md-6 col-sm-6 col-xs-12" v-for="child in person.children" v-if="child.sex === 0">
                                            <a href="javascript:void(0);" onclick="openCard(this)">
                                                <input class="card_id" hidden="hidden" v-model="child.pid">
                                                <div class="info-box"  v-bind:class="child.sex === 1 ? 'bg-green' : 'bg-yellow'">
                                                <span class="info-box-icon">
                                                    <img v-if="child.portraitUrl" :src=child.portraitUrl alt="jing">
                                                    <img v-else src="/assets/images/jing.jpg"alt="jing">
                                                </span>
                                                    <div class="info-box-content">
                                                        <span class="info-box-text" v-text="child.rank"></span>
                                                        <span class="info-box-number" v-text="child.name"></span>

                                                        <div class="progress">
                                                            <div class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description">
                                                        字 <span v-text="child.styleName"></span>&nbsp;
                                                        号 <span v-text="child.selfName"></span>&nbsp;
                                                        <span v-if="child.memo" v-text="child.memo"></span>
                                                    </span>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
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
        InitPersonData();
    });
</script>
</div>
</body>
</html>
