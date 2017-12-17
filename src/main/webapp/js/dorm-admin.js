$(document).ready(function(){
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
        $(href).addClass('active').siblings('.tab-panel').removeClass('active');
    })
})