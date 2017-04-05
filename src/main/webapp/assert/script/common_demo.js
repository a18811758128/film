var videoTimeRegx = /^\d*\d\d:[0-5]\d$/;
var registerRole = "person";
var moveNumber = 5;// 猜你喜欢默认个数
var moveStep;// 移动了几步
var remainStep;// 剩余几步
$(function() {
    var errorInput;

    $(".bank-list li").on("click", function() {
        $(this).siblings().removeClass("current");
        $(this).addClass("current");
    });

    $(".gototop").click(function() {
        $("html,body").animate({
            scrollTop : 0
        }, 500);
    });

    $(window).on("scroll", function() {
        if ($(this).scrollTop() > 50) {
            $(".common-head").addClass("common-head-lock");
        } else {
            $(".common-head").removeClass("common-head-lock");
        }
        ;
    });

    $(".video-cut li:even").css("backgroundColor", "#FFF0E2");

    remainStep = remainStep
            | $(".bigdata .data-wrap .data-main .no-limit").children().length
            - 5;
    /* 图片延迟加载插件 */
    $("img.lazy").lazyload({
        threshold : 200,
        failure_limit : 30,
        effect : "fadeIn"
    });
    /* 点击搜索框下拉菜单项 */
    $(".dropdown li").on("click", function() {
        $("#searchResultType").html($(this).html());
        var type = "";
        if ($(this).html() == "视频") {
            $("#searchResultType").attr('type', 'video');
            type = 'video';
        } else if ($(this).html() == "音频") {
            $("#searchResultType").attr('type', 'audio');
            type = 'audio';
        } else if ($(this).html() == "图片") {
            $("#searchResultType").attr('type', 'picture');
            type = 'picture';
        }
        $("#input-search-type").val(type);
        $(".dropdown").hide();
    });
    /* 搜索框下拉菜单显示 */
    $(".search-dropdown,.head-search-dropdown,.order-ly").on("mouseover",
            function() {
                $(".dropdown").show();
            });
    /* 搜索框下拉菜单隐藏 */
    $(".search-dropdown,.head-search-dropdown,.order-ly").on("mouseout",
            function() {
                $(".dropdown").hide();
            });
    /* 注册页面个人注册和公司注册切换 */
    $(".personal,.company").on("click", function() {
        if (!$(this).hasClass("selected")) {
            $(".t-c").removeClass("selected");
            $(this).addClass("selected");
            $(".p-form").toggle();
            if ($(this).hasClass("company")) {
                sessionStorage.setItem("register-form", "company");
            } else {
                sessionStorage.setItem("register-form", "personal");
            }
            
        }
        registerRole = $(this).attr("role");
    });

    /* 登录页面，用户名和密码不为空，登录按钮变成可点击的样式 */
    $(".p-input input[name=username],input[name=password]").on("keyup",
            function() {
                var userName = $(".p-input:text").val();
                var password = $(".p-input:password").val();
                if (!!userName && !!password) {
                    $(".login-btn").removeClass("l-btn-unclick");
                    $(".login-btn").addClass("l-btn-click");

                } else {
                    $(".login-btn").addClass("l-btn-unclick");
                    $(".login-btn").removeClass("l-btn-click");
                }
            });

    /* 顶部菜单栏，鼠标放到登录链接，弹出登录框 */
    $(".li-relative").on("mouseover", function() {
        $(".pop-login,.pop-user-center").show();
    });
    /* 顶部菜单栏，鼠标移开登录链接，隐藏登录框 */
    $(".li-relative").on("mouseout", function() {
        $(".pop-login,.pop-user-center").hide();
    });
    /* 搜索结果页，显示下拉菜单 */
    $(".search-result .filter .filter-order .sort-btn")
            .on(
                    "mouseover",
                    function() {
                        $(
                                ".search-result .filter .filter-order .sort-btn .sort-dropdpwn")
                                .show();
                    });
    /* 搜索结果页，鼠标移开，下拉菜单消失 */
    $(".search-result .filter .filter-order .sort-btn")
            .on(
                    "mouseout",
                    function() {
                        $(
                                ".search-result .filter .filter-order .sort-btn .sort-dropdpwn")
                                .hide();
                    });
    /* 搜索结果页，筛选项下来菜单点击修改筛选类别 */
    $(".search-result .filter .filter-order .sort-btn .sort-dropdpwn li")
            .on(
                    "click",
                    function() {
                        $(".sort-text").html($(this).html());
                        if ($(this).html() == "相关度") {
                            $(".sort-text").attr('sorttype', 'relevancy');
                        } else if ($(this).html() == "最新") {
                            $(".sort-text").attr('sorttype', 'latest');
                        } else if ($(this).html() == "最早") {
                            $(".sort-text").attr('sorttype', 'earliest');
                        }
                        $(
                                ".search-result .filter .filter-order .sort-btn .sort-dropdpwn")
                                .hide();
                        $(".sort-text").trigger('contentChange');
                    });
    /* 搜索结果页，视频-音频-图片切换 */
    $(".search-result .filter .filter-type li").on("click", function() {
        $(".search-result .filter .filter-type li").removeClass("selected");
        $(this).addClass("selected");
    });
    /* 搜索结果页，筛选按钮点击鼠标 */
    $(".search-result .filter .filter-order .filter-btn").on("mousedown",
            function() {
                $(this).addClass("filter-btn-keydown");
            });
    /* 搜索结果页，筛选按钮松开鼠标 */
    $(".search-result .filter .filter-order .filter-btn").on("mouseup",
            function() {
                $(this).removeClass("filter-btn-keydown");
            });
    /* 搜索结果页，格子视图和行视图切换 */
    $(".grid-btn,.line-btn").on(
            "click",
            function() {
                if ($(this).hasClass("grid-btn-uncheck")
                        || $(this).hasClass("line-btn-uncheck")) {
                    $(".grid-btn").toggleClass("grid-btn-uncheck");
                    $(".line-btn").toggleClass("line-btn-uncheck");
                    $(".search-result-main").toggle();
                }
                if ($(this).hasClass("grid-btn")) {
                    sessionStorage.setItem("listDisplay", "grid");
                } else if ($(this).hasClass("line-btn")) {
                    sessionStorage.setItem("listDisplay", "list");
                }

            });
    /* 点击星号图标收藏搜索结果 */
    $(
            ".result-item .r-i-text i,.search-result-main .line-result-item .l-r-i-text i")
            .on("click", function() {
                $(this).toggleClass("collect");
            });
    /* 播放器 播放-暂停 */
    $(".player .player-controller .p-c-l .play").on("click", function() {
        $(this).toggleClass("pause");
    });
    /* 播放器 收藏-取消收藏 */
    $(".player .player-controller .p-c-r .collect").on("click", function() {
        $(this).toggleClass("collected");
    });
    /* 播放器 放入购物车-取消放入购物车 */
    $(".player .player-controller .p-c-r .cart").on("click", function() {
        $(this).toggleClass("carted");
    });
    /* 推荐收藏 */
    $(".data-img-wrap .collect").on("click", function() {
        $(this).toggleClass("collected");
    });

    /* 搜索框键盘响应事件 中文转成Unicode，不会出现乱码 */
    $(".search_text,.head-search_text").on("keydown", function(e) {
        if (e.keyCode == 13) {
            e.preventDefault();
            document.getElementById("searchBtn").click();
        }
    });
    /* 筛选按钮点击事件 */
    $(".filter-btn").on("click", function() {
        $(".search-selected").toggle();
        var filterDisplay = $(".search-selected").is(":visible");
        sessionStorage.setItem("filterDisplay", filterDisplay);
    });
    $(".cut .cut-based-time .in-out .i-o-item .time").blur(function() {
        if (!videoTimeRegx.test($(this).val())) {
            alert("\u65f6\u95f4\u683c\u5f0f\u9519\u8bef");
            return;
        }
    });

    // $('.locate').click(function(){
    // var element = document.getElementById('test_video_1');
    // var minutes = element.currentTime() / 60;
    // var seconds = element.currentTime() % 60;
    // if (minutes < 10) minutes = '0' + minutes;
    // if (seconds < 10) seconds = '0' + seconds;
    // this.next().val(minutes + ':' + seconds);
    // });

    $(".m-code-btn").on("click", function() {
        var mobile = $("input[name=phone]").val();
        if (!!mobile) {
            if (!isMobile(mobile)) {
                alert("\u624b\u673a\u53f7\u7801\u683c\u5f0f\u9519\u8bef");
            }
        }
    });
    /* 个人注册按钮点击状态 */
    $(
            $("input[name=pName],input[name=pPassword],input[name=pConfirmPassword],input[name=pMail],#pCheckbox"))
            .on(
                    "keyup click",
                    function() {
                        if (!!$("input[name=pName]").val()
                                && !!$("input[name=pCPhone]").val()
                                && !!$("input[name=pRName]").val()
                                && !!$("input[name=pCNumber]").val()
                                && !!$("input[name=pPassword]").val()
                                && !!$("input[name=pConfirmPassword]").val()
                                && !!$("input[name=pMail]").val()
                                && document.getElementById("pCheckbox").checked) {
                            $("#pRegisterBtn").addClass("r-btn-click");
                            $("#pRegisterBtn").removeAttr("disabled");
                        } else {
                            $("#pRegisterBtn").removeClass("r-btn-click");
                            $("#pRegisterBtn").attr("disabled", true);
                        }
                    });
    /* 公司注册按钮点击状态 */
    $(
            $("input[name=cName],input[name=cPassword],input[name=cConfirmPassword],input[name=cMail],input[name=cCompany],input[name=cCode],input[name=cContact],input[name=cPhone],input[name=cVerify],#cCheckbox"))
            .on("keyup click",
                    function() {
                        if (!!$("input[name=cName]").val()
                                && !!$("input[name=cLocation]").val()
                                && !!$("input[name=cPassword]").val()
                                && !!$("input[name=cConfirmPassword]").val()
                                && !!$("input[name=cMail]").val()
                                && !!$("input[name=cCompany]").val()
                                && !!$("input[name=cCode]").val()
                                && !!$("input[name=cContact]").val()
                                && !!$("input[name=cPhone]").val()
                                && !!$("input[name=cVerify]").val()
                                && document.getElementById("cCheckbox").checked) {
                            $("#cRegisterBtn").addClass("r-btn-click");
                            $("#cRegisterBtn").removeAttr("disabled");
                        } else {
                            $("#cRegisterBtn").removeClass("r-btn-click");
                            $("#cRegisterBtn").attr("disabled", true);
                        }
                    });

    $(".bigdata .data-wrap .data-left")
            .on(
                    "click",
                    function() {
                        moveStep = moveStep | 0;
                        if (remainStep > 0) {
                            $(".bigdata .data-wrap .data-main .no-limit")
                                    .stop(true, true)
                                    .animate(
                                            {
                                                marginLeft : (parseInt($(
                                                        ".bigdata .data-wrap .data-main .no-limit")
                                                        .css('marginLeft')) - 210)
                                                        + "px"
                                            });
                            remainStep--;
                            moveStep++;
                        }
                    });
    $(".bigdata .data-wrap .data-right")
            .on(
                    "click",
                    function() {
                        moveStep = moveStep | 0;
                        if (moveStep > 0) {
                            $(".bigdata .data-wrap .data-main .no-limit")
                                    .stop(true, true)
                                    .animate(
                                            {
                                                marginLeft : (parseInt($(
                                                        ".bigdata .data-wrap .data-main .no-limit")
                                                        .css('marginLeft')) + 210)
                                                        + "px"
                                            });
                            remainStep++;
                            moveStep--;
                        }

                    });
    $(".result-item .r-i-img").on("click", function() {
        $(this).parent().parent(".result-item").remove();
    });
    $(".favorite-nav ul li").on("click", function() {
        $(this).siblings().removeClass("current");
        $(this).addClass("current");
    });
    // 身份证号验证
    jQuery.validator.addMethod("idcardno", function(value, element) {
        return this.optional(element) || isIdCardNo(value);
    }, "");
    // 手机号码验证
    jQuery.validator.addMethod("mobile", function(value, element) {
        var length = value.length;
        var mobile = /^1[3458]\d{9}$/
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "");

});

function isMobile(str) {
    /* if(str.length==11&&$.inArray(str.substring(0,3), mobileField)!=-1){ */
    if (/^1[3|4|5|8][0-9]{9}$/.test(str)) {
        return true;
    }
    return false;
}
function handleChildrenCut(obj, boolen) {
    console.log(obj.children("li").length);
    if (boolen) {
        obj.children("li").find(".square").each(
                function() {
                    if (!$(this).hasClass("current")) {
                        $(this).addClass("current");
                        checkboxTrue($(this));
                        addTotalMoney(parseInt(($(this).parent().find(".price")
                                .html()).replace("¥", "")));
                        addTotalTime(parseInt(($(this).parent().find(".time")
                        		.html()).replace("秒", "")));
                    }
                });
    } else {
        obj.children("li").find(".square").each(
                function() {
                    $(this).removeClass("current");
                    checkboxFalse($(this));
                    removeTotalMoney(parseInt(($(this).parent().find(".price")
                            .html()).replace("¥", "")));
                    removeTotalTime(parseInt(($(this).parent().find(".time")
                    		.html()).replace("秒", "")));
                });
    }
}
function checkboxFalse(obj) {
    obj.prev().prop("checked", false);
}
function checkboxTrue(obj) {
    obj.prev().prop("checked", true);
}
function addTotalMoney(money) {
    var total = parseInt($(".total-money b").html()) + money;
    if (total > 0) {
        $(".banlance-end .banlance-btn").addClass("avaliable");
    }
    $(".total-money b").html(parseInt($(".total-money b").html()) + money);
    if (!!$(".cart-center .fa-data .datas b").html()) {
        $(".cart-center .fa-data .datas b")
                .html(
                        "¥"
                                + (parseInt(($(".cart-center .fa-data .datas b")
                                        .html()).replace("¥", "")) + money));
    }
    if (!!$(".orders-money .number").html()) {
        $(".orders-money .number").html(
                parseInt($(".orders-money .number").html()) + money)
    }

}
function addTotalTime(time) {
//	var total = parseInt(($(".cart-center .fa-data .datass b").html()).replace("秒", "")) + time;
//	if (total > 0) {
//		$(".banlance-end .banlance-btn").addClass("avaliable");
//	}
//	$(".cart-center .fa-data .datass b").html((parseInt(($(".cart-center .fa-data .datass b")
//			.html()).replace("秒", "")) + time)+"秒");
	if (!!$(".cart-center .fa-data .datass b").html()) {
		$(".cart-center .fa-data .datass b")
		.html(
				(parseInt(($(".cart-center .fa-data .datass b")
						.html()).replace("秒", "")) + time)+"秒");
	}
//	if (!!$(".orders-money .number").html()) {
//		$(".orders-money .number").html(
//				parseInt($(".orders-money .number").html()) + money)
//	}
	
}
function removeTotalMoney(money) {
    var total = parseInt($(".total-money b").html()) - money;
    if (total <= 0) {
        $(".banlance-end .banlance-btn").removeClass("avaliable");
    }
    $(".total-money b").html(parseInt($(".total-money b").html()) - money);
    if (!!$(".cart-center .fa-data .datas b").html()) {
        $(".cart-center .fa-data .datas b")
                .html(
                        "¥"
                                + (parseInt(($(".cart-center .fa-data .datas b")
                                        .html()).replace("¥", "")) - money));
    }
    if (!!$(".orders-money .number").html()) {
        $(".orders-money .number").html(
                parseInt($(".orders-money .number").html()) - money)
    }

}
function removeTotalTime(time) {
//	var total = parseInt($(".total-money b").html()) - money;
//	var total = parseInt(($(".cart-center .fa-data .datass b").html()).replace("秒", "")) - time;
//	if (total <= 0) {
//		$(".banlance-end .banlance-btn").removeClass("avaliable");
//	}
//	$(".total-money b").html(parseInt($(".total-money b").html()) - money);
//	$(".cart-center .fa-data .datass b").html((parseInt(($(".cart-center .fa-data .datass b")
//			.html()).replace("秒", "")) + time)-"秒");
	if (!!$(".cart-center .fa-data .datass b").html()) {
		$(".cart-center .fa-data .datass b")
		.html(
				(parseInt(($(".cart-center .fa-data .datass b")
						.html()).replace("¥", "")) - time)+"秒");
	}
//	if (!!$(".orders-money .number").html()) {
//		$(".orders-money .number").html(
//				parseInt($(".orders-money .number").html()) - money)
//	}
//	
}

function addZero(p) {
    return p < 10 ? '0' + p : p;
}

function secToMin(sec) {
//    if (!sec)
//        return 0;

    var hasH = false;
    var h;
    if (parseInt(sec / 3600) != 0) {
        hasH = true;
        h = addZero(parseInt(sec / 3600));
        sec = sec % 3600;
    }
    var m = addZero(parseInt(sec / 60));
    var s = addZero(parseInt(sec % 60));
    return (hasH ? h + ':' : '') + m + ':' + s;
}
function minToSec(min) {
    if (!min)
        return 0;
    var arr = min.split(':');
    if (arr.length == 3) {
        return parseInt(arr[0]) * 3600 + parseInt(arr[1]) * 60
                + parseInt(arr[2]);
    } else {
        return parseInt(arr[0]) * 60 + parseInt(arr[1]);
    }
}

// 高级搜索，设置URL参数
function setParmsValue(parms, parmsValue) {
    var urlstrings = document.URL;
    var args = GetUrlParms();
    var values = args[parms];
    // 如果参数不存在，则添加参数
    if (values == undefined) {
        var query = location.search.substring(1); // 获取查询串
        // 如果Url中已经有参数，则附加参数
        if (query) {
            urlstrings += ("&" + parms + "=" + parmsValue);
        } else {
            urlstrings += ("?" + parms + "=" + parmsValue); // 向Url中添加第一个参数
        }
        window.location = urlstrings;
    } else {
        window.location = updateParms(parms, parmsValue); // 修改参数
    }
}

// 修改URL参数，parms：参数名，parmsValue：参数值，return：修改后的URL
function updateParms(parms, parmsValue) {
    var newUrlParms = "";
    var newUrlBase = location.href.substring(0, location.href.indexOf("?") + 1); // 截取查询字符串前面的url
    var query = location.search.substring(1); // 获取查询串
    var pairs = query.split("&"); // 在&处断开
    for ( var i = 0; i < pairs.length; i++) {
        var pos = pairs[i].indexOf('='); // 查找name=value
        if (pos == -1)
            continue; // 如果没有找到就跳过
        var argname = pairs[i].substring(0, pos); // 提取name
        var value = pairs[i].substring(pos + 1); // 提取value
        // 如果找到了要修改的参数
        if (findText(argname, parms)) {
            newUrlParms = newUrlParms + (argname + "=" + parmsValue + "&");
        } else {
            newUrlParms += (argname + "=" + value + "&");
        }
    }
    return newUrlBase + newUrlParms.substring(0, newUrlParms.length - 1);
}

// 辅助方法
function findText(urlString, keyWord) {
    return urlString.toLowerCase().indexOf(keyWord.toLowerCase()) != -1 ? true
            : false;
}

// 得到查询字符串参数集合
function GetUrlParms() {
    var args = new Object();
    var query = location.search.substring(1); // 获取查询串
    var pairs = query.split("&"); // 在&处断开
    for ( var i = 0; i < pairs.length; i++) {
        var pos = pairs[i].indexOf('='); // 查找name=value
        if (pos == -1)
            continue; // 如果没有找到就跳过
        var argname = pairs[i].substring(0, pos); // 提取name
        var value = pairs[i].substring(pos + 1); // 提取value
        args[argname] = unescape(value); // 存为属性
    }
    return args;
}

// 身份证号码验证
function isIdCardNo(num) {

    var factorArr = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4,
            2, 1);
    var parityBit = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3",
            "2");
    var varArray = new Array();
    var intValue;
    var lngProduct = 0;
    var intCheckDigit;
    var intStrLen = num.length;
    var idNumber = num;
    // initialize
    if ((intStrLen != 15) && (intStrLen != 18)) {
        return false;
    }
    // check and set value
    for (i = 0; i < intStrLen; i++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
            return false;
        } else if (i < 17) {
            varArray[i] = varArray[i] * factorArr[i];
        }
    }

    if (intStrLen == 18) {
        // check date
        var date8 = idNumber.substring(6, 14);
        if (isDate8(date8) == false) {
            return false;
        }
        // calculate the sum of the products
        for (i = 0; i < 17; i++) {
            lngProduct = lngProduct + varArray[i];
        }
        // calculate the check digit
        intCheckDigit = parityBit[lngProduct % 11];
        // check last digit
        if (varArray[17] != intCheckDigit) {
            return false;
        }
    } else { // length is 15
        // check date
        var date6 = idNumber.substring(6, 12);
        if (isDate6(date6) == false) {
            return false;
        }
    }
    return true;

}

// 判断是否为“YYYYMM”式的时期
function isDate6(sDate) {
    if (!/^[0-9]{6}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    if (year < 1700 || year > 2500)
        return false
    if (month < 1 || month > 12)
        return false
    return true;
}
// 判断是否为“YYYYMMDD”式的时期

function isDate8(sDate) {
    if (!/^[0-9]{8}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    day = sDate.substring(6, 8);
    var iaMonthDays = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ]
    if (year < 1700 || year > 2500)
        return false
    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
        iaMonthDays[1] = 29;
    if (month < 1 || month > 12)
        return false
    if (day < 1 || day > iaMonthDays[month - 1])
        return false
    return true;
}

function fun(p) {
    if (p == 0) {
        $(".bill-item-address").css("display", "none");
    } else {
        $(".bill-item-address").css("display", "block");
    }
}
// 更新顶部购物车条目数量
function updateCartItemCount() {
    jQuery.ajax({
        url: '/cart/count',
        type: 'GET',
        success: function (r) {
            if (r.code == 200) {
                var html = '(' + r.data.count + ')';
                $("#head-cart-item-count").html(html);
            }
        }
    });
}