/**
 * Created by jingz on 2017/2/8.
 */
/**
 * 实现路径用POST传值并且打开新页面
 */
$.extend({
    StandardPost:function(url,args){
        var body = $(document.body),
            form = $("<form method='post'></form>"),
            input;
        form.attr({"action":url});
        $.each(args,function(key,value){
            input = $("<input type='hidden'>");
            input.attr({"name":key});
            input.val(value);
            form.append(input);
        });

        form.appendTo(body);
        form.submit();
        document.body.removeChild(form[0]);
    }
});

var redirectByPost = function (url, urlName) {
    $.StandardPost(url,{urlName: urlName});
};

/**
 * url重定向,get方式
 * @param url
 */
var redirect = function (url) {
    if(url && url != '#' && url != 'null') {

        // 判断如果是外链地址，则直接转向，如果是本站地址，则重定向
        var regx=/^(http:\/\/)/;
        var regxs = /^(https:\/\/)/;
        if (regx.test(url) || regxs.test(url)) {
            window.open(url);
        } else {
            // window.location.href = "redirect?url="+url;
            redirectByPost('app', url);
        }
    }
};

/**
 * 初始化菜单
 * @param url 后台请求json的url
 * @parentid parentid 菜单ul的父标签id
 * @constructor
 */
var InitMenu = function (url, parentid) {

    // 从url获取json
    $.getJSON(url, function (result) {
        var showlist = $('<ul class="nav navbar-nav"></ul>');
        showMenu(result, showlist);

        var $parent = $("#"+parentid);
        if ($parent.length === 0) {
            $parent = $('<div class="collapse navbar-collapse pull-right" id="navbar-collapse"></div>');
        }
        $parent.append(showlist);
    });

    var showMenu = function (menus, parent) {
        $.each(menus, function (k, v) {
            if (v.submenu.length > 0) {
                var $li = createLi(v);
                $li.append('<ul class="dropdown-menu" role="menu"></ul>');
                $li.appendTo(parent);

                // 递归调用本方法
                showMenu(v.submenu, $li.children().eq(1));
            } else {
                //如果该节点没有子节点，则直接将该节点li以及文本创建好直接添加到父亲节点中
                var $li = createLi(v);
                $li.appendTo(parent);
            }
        });
        return parent;
    };

    var createLi = function (v) {
        var $span_name = $('<span class="nav-label"></span>').append(v.mname);

        if (!v.url) {
            v.url = "'#'";
        } else {
            v.url = "'" + v.url + "'";
        }
        var $a = "";
        var $li = "";
        if (v.submenu.length > 0) {
            $a = $('<a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0);" onclick="redirect(' + v.url + ')"></a>').append($span_name);
            $a.append($('<span class="caret"></span>'));
            $li = $('<li class="dropdown"></li>').append($a);
        } else {
            $a = $('<a href="javascript:void(0);" onclick="redirect(' + v.url + ')"></a>').append($span_name);
            if (v.tag) {
                var $span_tag = $('<span class="label label-success pull-right"></span>').append(v.tag);
                $a.append($span_tag);
            }
            $li = $('<li></li>').append($a);
        }

        return $li;
    };
};