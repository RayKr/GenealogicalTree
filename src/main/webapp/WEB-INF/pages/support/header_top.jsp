<%--
  Created by IntelliJ IDEA.
  User: jingz
  Date: 2017/2/8
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header">
    <nav class="navbar navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <a href="/person/" class="navbar-brand">景氏家谱</a>
                <%-- 自适应开关 --%>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#navbar-collapse">
                    <i class="fa fa-bars"></i>
                </button>
            </div>

            <!-- 可折叠菜单 -->
            <div class="collapse navbar-collapse pull-right" id="navbar-collapse">
                <%-- 菜单 --%>
                <span id="navbar-menu"></span>

                <%-- 搜索框 --%>
                <form class="navbar-form navbar-left" role="search">
                    <div class="input-group">
                        <input type="text" class="form-control" id="navbar-search-input" placeholder="Search">
                        <span class="input-group-btn">
                            <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
                        </span>
                    </div>
                </form>
            </div>
        </div>
    </nav>
</header>
