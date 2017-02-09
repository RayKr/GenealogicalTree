/**
 * Created by jingz on 2017/2/8.
 */
/**
 * 实现路径用POST传值并且打开新页面
 */
$.extend({
    StandardPost: function (url, args) {
        var body = $(document.body),
            form = $("<form method='post'></form>"),
            input;
        form.attr({"action": url});
        $.each(args, function (key, value) {
            input = $("<input type='hidden'>");
            input.attr({"name": key});
            input.val(value);
            form.append(input);
        });

        form.appendTo(body);
        form.submit();
        document.body.removeChild(form[0]);
    }
});

var redirectByPost = function (url, urlName) {
    $.StandardPost(url, {urlName: urlName});
};

/**
 * url重定向,get方式
 * @param url
 */
var redirect = function (url) {
    if (url && url != '#' && url != 'null') {

        // 判断如果是外链地址，则直接转向，如果是本站地址，则重定向
        var regx = /^(http:\/\/)/;
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
 * 成员链接转向
 * @param url
 */
var openLink = function (url) {

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

        var $parent = $("#" + parentid);
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

/**
 * 初始化站点信息
 * @param url
 * @param id
 * @constructor
 */
var InitSite = function (url, id) {
    $.getJSON(url, function (data) {
        new Vue({
            el: '#' + id,
            data: {
                site: data
            }
        });
    });
};

/**
 * 执行查询方法
 * @param e
 */
var doSearch = function (input) {
    if ($("#pname").val()) {
        $.ajax({
            url: '/person/search',
            type: 'POST',
            dataType: 'json',
            data: {
                name: input
            },
            error: function () {
                toastr.error("查无此人！");
            },
            success: function (json) {
                clearNode("result-card");
                if (json.success) {
                    // 显示查询结果
                    DisplayCardList(json.result);

                    $("#index-tip").css('display', '');
                } else {
                    toastr.error(json.msg);
                }
            }
        });
    }
};

/**
 * 显示查询结果
 * @param json
 * @constructor
 */
var BindJson = function (jsonObj) {
    for (var o in jsonObj) {
        var domObj = document.getElementById(o.toString());
        if (domObj) {
            if (jsonObj[o]) {
                // 判断tagName，分别赋值
                var tag = domObj.tagName.toUpperCase();
                if (tag === "A" || tag === "SPAN") {
                    domObj.innerText = jsonObj[o].toString();
                } else {
                    domObj.value = jsonObj[o].toString();
                }
            }
            // 判断为true，则更改label显示效果
            if (jsonObj[o] === true) {
                // 更改label样式
                var $label = $('#label-' + o.toString());
                if ($label.length > 0) {
                    $label.removeClass('label-default').addClass('label-warning');

                    // 封装数据
                    $label.empty();
                    var $a = $('<a href="javascript:void(0);" onclick="openLink(\'' + o.toString() + '\');">' + labelenu[o].toString() + '</a>');
                    $label.append($a);
                }

            } else if (jsonObj[o] === false) {
                var $label = $('#label-' + o.toString());
                if ($label.length > 0) {
                    $label.removeClass('label-warning').addClass('label-default');

                    // 封装数据
                    $label.empty();
                    $label.append(labelenu[o].toString());
                }

            }
        }
        if (typeof(jsonObj[o]) == "object") {
            BindJson(jsonObj[o]);
        }
    }
};

/**
 * 后台查询结果显示在页面列表上
 * @param json
 * @constructor
 */
var BindPeople = function (json) {
    // 删除所有匹配的li节点
    $(".person-li").remove();
    var $ul = $("#result-list");
    for (var o in json) {
        var $a = $('<a href="javascript:void(0);" onclick="openLink(' + json[o].pid + ');"></a>');
        $a.append(json[o].name);
        var $li = $('<li class="person-li"></li>');
        $li.append($a);
        $ul.append($li);
    }
};

/**
 * 展示表格数据
 * @param data
 */
var displayTable = function (data) {
    $('#ptable').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": false,
        "ordering": true,
        "info": true,
        "autoWidth": false,
        "bDestroy": true,
        "data": data,
        "columns": [
            {
                "data": "name",
                "render": function (data, type, full, meta) {
                    return '<a href="#">' + data + '</a>';

                }
            }, {
                "data": "styleName"
            }, {
                "data": "selfName"
            }
        ],
        "oLanguage": {
            "sLengthMenu": "每页 _MENU_ 条数据",
            "sZeroRecords": "没有数据",
            "sInfo": "_START_ - _END_ 总(_TOTAL_)",
            "sInfoEmpty": "0 - 0 总数： 0",
            "oPaginate": {
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
            }
        },
    });
}

/**
 * 组织CardList数据
 * @param json
 * @constructor
 */
var DisplayCardList = function (json) {
    var $card = $("#card-list");

    for (var o in json) {
        var data = json[o];

        // 性别不同，显示卡片颜色不同，男-green，女-yellow
        var $bg;
        console.info(data.sex);
        if (data.sex == 1) {
            $bg = $('<div class="info-box bg-green"></div>');
        } else {
            $bg = $('<div class="info-box bg-yellow"></div>');
        }

        // 头像图片
        var url = (data.portraitUrl) ? data.portraitUrl : "/assets/images/portrait.jpg";
        var $portrait = $('<span class="info-box-icon"><img src="' + url + '" alt="profile"></span>');

        // 名
        var $name = $('<span class="info-box-text">景</span><span class="info-box-number">' + data.name + '</span>');
        // 分割线
        var $line = $('<div class="progress"><div class="progress-bar" style="width: 100%"></div></div>');
        // 字、号
        var $ext_name = $('<span class="progress-description">字' + (data.styleName ? data.styleName : "无") + '&nbsp;号' + (data.selfName ? data.selfName : "无")  + '</span>"');
        // box-content
        var $box = $('<div class="info-box-content"></div>');

        $box.append($name);
        $box.append($line);
        $box.append($ext_name);

        $bg.append($portrait);
        $bg.append($box);

        // a
        var $a = $('<a href="javascript:void(0);" onclick="openLink(' + data.pid + ')"></a>');
        // card
        var $div = $('<div class="col-md-3 col-sm-6 col-xs-12 result-card"></div>');

        // 组织DOM
        $a.append($bg);
        $div.append($a);

        $card.append($div);
    }

};

var clearNode = function (c) {
    // 删除所有匹配的div节点
    $("."+c).remove();
};