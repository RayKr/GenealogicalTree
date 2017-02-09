<%--
  Created by IntelliJ IDEA.
  User: jingz
  Date: 2017/2/9
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>备份用代码片段</title>
</head>
<body>
<%-- data table 显示--%>
<div class="box">
    <div class="box-header with-border">
        <h3 class="box-title"><i class="fa fa-users" style="padding: 0 5px"></i>搜索结果</h3>
    </div>
    <div class="box-body">
        <table id="ptable" class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>名</th>
                <th>字</th>
                <th>号</th>
            </tr>
            </thead>
        </table>
    </div>
    <!-- /.box-body -->
</div>

<%-- list --%>
<div class="box box-success">
    <div class="box-header with-border">
        <h3 class="box-title">搜索结果</h3>
    </div>
    <div class="box-body" id="search-result">
        <%-- 结果列表 --%>
        <ul class="nav nav-stacked" id="result-list">
        </ul>
    </div>
</div>

</body>
</html>
