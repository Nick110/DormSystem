$(document).ready(function(){
    var href = $.cookie('href');
    // if (href == undefined){
    //     $('.tab-panel').addClass('active').siblings('.tab-panel').removeClass('active');
    //     $('.menu-item').eq(0).addClass('menu-item-active');
    //     $('.menu-item').eq(0).addClass('menu-item-active');
    //     $('.menu-item').eq(0).siblings().removeClass('menu-item-active');
    //     $('.menu-item').eq(0).siblings('ul').children('.menu-item-content').removeClass('menu-item-active');
    //     $('.menu-item').eq(0).parent().siblings('.menu-item').removeClass('menu-item-active');
    //     $('.menu-item').eq(0).parent().siblings('ul').children('.menu-item-content').removeClass('menu-item-active');
    // }


    $(href).addClass('active').siblings('.tab-panel').removeClass('active');
    $('.menu-item').each(function () {
        if ($(this).attr('href') == href) {
            $(this).addClass('menu-item-active');
            $(this).siblings().removeClass('menu-item-active');
            $(this).siblings('ul').children('.menu-item-content').removeClass('menu-item-active');
            $(this).parent().siblings('.menu-item').removeClass('menu-item-active');
            $(this).parent().siblings('ul').children('.menu-item-content').removeClass('menu-item-active');
        }
    })

    $('.menu-item-content').each(function () {
        if ($(this).attr('href') == href) {
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
        $.cookie('href', href);
        console.log(href);
        $(href).addClass('active').siblings('.tab-panel').removeClass('active');
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
            }
        })
        }
    })

    $('.state').each(function () {
        if ($(this).text() == '未修复') {
            $(this).css('color', '#ff540e');
        }
    })

})