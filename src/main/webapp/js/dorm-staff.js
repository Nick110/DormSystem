$(document).ready(function(){

    var prevItem = $.cookie('href');
    var currentUrl = window.location.href;
    if (currentUrl.indexOf("selectRewards") >= 0) {
        prevItem = '#rewardAndPunishment';
    }

    if (typeof(prevItem) == 'undefined'){
        prevItem = '#announcements';
    }

    console.log(prevItem);
    $(prevItem).addClass('active').siblings('.tab-panel').removeClass('active');
    $('.menu-item').each(function () {
        if ($(this).attr('href') == prevItem) {
            $(this).addClass('menu-item-active');
            $(this).siblings().removeClass('menu-item-active');
            $(this).siblings('ul').children('.menu-item-content').removeClass('menu-item-active');
            $(this).parent().siblings('.menu-item').removeClass('menu-item-active');
            $(this).parent().siblings('ul').children('.menu-item-content').removeClass('menu-item-active');
        }
    })

    $('.menu-item-content').each(function () {
        if ($(this).attr('href') == prevItem) {
            $(this).parent('.menu-ul').slideDown(1000);
            $(this).addClass('menu-item-active');
        }
    })

    $('.menu-item:gt(1)').click(function(){
        var menuUl = $(this).next('.menu-ul');
        if (menuUl.css('display') == 'none') {
            menuUl.slideDown(300);
        }
        else {
            menuUl.slideUp(300);
        }
    });
    $('.menu-item,.menu-item-content').click(function () {
        $(this).addClass('menu-item-active');
        $(this).siblings().removeClass('menu-item-active');
        $(this).siblings('ul').children('.menu-item-content').removeClass('menu-item-active');
        $(this).parent().siblings('.menu-item').removeClass('menu-item-active');
        $(this).parent().siblings('ul').children('.menu-item-content').removeClass('menu-item-active');
    });

    $('.menu-item,.menu-item-content').click(function () {
        var href = $(this).attr('href');
        console.log(href);
        $.cookie('href', href, {path: '/'});
        if (currentUrl != "http://localhost:8080/staffHome") {
            window.location.href = "http://localhost:8080/staffHome";
        }

        $(href).addClass('active').siblings('.tab-panel').removeClass('active');
    });


    //验证公告表单是否为空
    $('.add-notice-btn').click(function () {
        var noticeContext = $('.textarea').val();
        console.log(noticeContext);
        if (noticeContext == "") {
            alert("请输入公告内容！");
            return false;
        }
        $('.add-notice-form').submit();
    });

    
    //已修复
    $('td.do-repair').on('click', function () {
        var maintenanceId = $(this).siblings('.maintenance-id').attr('name');
        // var maintenanceId = parseInt(text);
        console.log(maintenanceId);
        console.log(typeof(maintenanceId))
        if(confirm("确定该项已修复完成？")) {
            $.ajax({
                type: "POST",
                url: "/staff/doRepair",
                data: 'maintenanceId='+maintenanceId,
                success: function (data) {
                    alert("已将该项标为已修复。");
                    window.location.reload();
                }
            })
        }
    })

    $('.state').each(function () {
        if ($(this).text() == '未修复') {
            $(this).css('color', '#ff540e');
        }
    })

    //提交添加奖惩表单
    $('.add-awards-btn').click(function () {
        var length = $('.add-awards-form input:lt(2)').length;
        for (var i = 0; i < length; i++) {
            if ($('.add-awards-form input').eq(i).val().length == 0) {
                alert("请填写完整信息！");
                return false;
            }
        }
        $('.add-awards-form').submit();
    })

    //查询奖惩表单action
    $('.select-rap-form > button').click(function () {
        var roomNo = $('#roomNo').val();
        if (roomNo == "") {
            alert("请输入寝室号！");
        }
        else {
            window.location.href = "/selectRewards/" + roomNo;
        }

        return false;
    })

    //弹出没查找到
    if ($('.select-error').text()) {
        alert($('.select-error').text() + '\n5s后返回');
        var t = setTimeout(function () {
            window.location.href = "/staffHome";
        }, 5000);
    }


    //分页
    $('.borrow-page .pagination a').click(function () {
        var data = $(this).text();
        var intPage = parseInt(data);
        // console.log(typeof(intPage));
        $(this).attr('href', '/staffHome/filp?page='+intPage);
    });

    $('.leave-page .pagination a').click(function () {
        var data = $(this).text();
        var intPage = parseInt(data);
        // console.log(typeof(intPage));
        $(this).attr('href', '/staffHome/leave?page='+intPage);
    })

    /*$('.leave-page .pagination a').click(function () {
        var data = $(this).text();
        var intPage = parseInt(data);
        console.log(typeof(intPage));
        $(this).attr('href', '/staffHome/filp?page='+intPage);
    })*/


    //显示未归还
    $('.isReturned').each(function () {
        if ($(this).text() == "") {
            $(this).text("还未归还");
            $(this).css('color', '#FF540E');
        }
    })

    //显示未返校
    $('.return-time').each(function () {
        if($(this).text() == "") {
            $(this).text("暂未返校");
            $(this).css('color', '#FF540E');
        }
    })

    //他已归还
    $('td.returned').on('click', function () {
        var equipmentId = $(this).siblings('.equipment-id').text();
        var returnTime = $(this).prev().text();
        console.log(returnTime);
        if (returnTime != "还未归还"){
            alert('此物品已经归还！');
        }
        else {
            console.log(equipmentId);
            // console.log(typeof(equipmentId))
            if(confirm("确定该物品已归还？")) {
                $.ajax({
                    type: "POST",
                    url: "/staff/return",
                    data: 'equipmentId='+equipmentId,
                    success: function (result) {
                        console.log(result)
                        alert("成功归还该物品。");
                        window.location.reload();
                    }
                })
            }
        }
    })

    //提交添加借物记录表单
    $('.borrow-btn').click(function () {
        var length = $('.borrow-form input').length;
        for (var i = 0; i < length; i++) {
            if ($('.borrow-form input').eq(i).val().length == 0) {
                alert("请填写完整信息！");
                return false;
            }
        }
        $('.borrow-form').submit();
    })

    console.log($('.borrow-msg').text());
    if ($('.borrow-msg').text() == "此学号不存在！") {
            alert($('.borrow-msg').text() + "\n5s后返回");
            var t = setTimeout(function () {
                window.location.href = "/staffHome";
            }, 5000);
        }
        else if ($('.borrow-msg').text() == "添加成功！") {
        alert($('.borrow-msg').text());
        window.location.href = "/staffHome";
    }


    //验证修改密码表单
    $('.update-psd-btn').click(function () {
        var length = $('.update-psw-form input:lt(3)').length
        var newPsd = $('.update-psw-form input').eq(1).val();
        for (var i = 0; i < length; i++){
            if (newPsd.length == 0) {
                alert("请填写完整信息！");
                return false;
            }
        }
        if (newPsd != $('.update-psw-form input').eq(2).val()){
            alert('两次密码输入不同！')
            return false;
        }
        else if (newPsd.length > 11 || newPsd.length < 3){
            alert("请输入3-11位的新密码！");
            return false;
        }
        $('.update-psw-form').submit();
    })

    if ($('.update-psw-result').text()){
        alert($('.update-psw-result').text());
    }

    //退出登录
    $('.logout').click(function () {
        if (confirm("你确定要退出系统吗？")) {
            window.location.href = "http://localhost:8080/staff/logout";
        }
    })

    //浏览器后退刷新
    var e=$("#refreshed");
    if(e.val() == "no") {
        e.val('yes');
    }else{
        e.val('no');
        location.reload();
    }
    
})

