$(function () {
    var topmain_height = $('.home_banner').height();
    var centerlist_height = $('#list_detail_box').height();
    var headcolor = function () { //导航背景色变化
        var scrollTop = (document.documentElement && document.documentElement.scrollTop) || window.pageYOffset || document.body.scrollTop;
        var classnamest = document.getElementById('homehead').className;
        if ((scrollTop > -1 && scrollTop < topmain_height) || (scrollTop > topmain_height + centerlist_height)) {
            if (classnamest && classnamest.indexOf('showbgcolor') != -1) {
                $('#homehead').removeClass('showbgcolor');
            }
            if (classnamest && classnamest.indexOf('hidebgcolor') < 0) {
                $('#homehead').addClass('hidebgcolor');
            }
        } else {
            if (classnamest && classnamest.indexOf('hidebgcolor') != -1) {
                $('#homehead').removeClass('hidebgcolor');
            }
            if (classnamest && classnamest.indexOf('showbgcolor') < 0) {
                $('#homehead').addClass('showbgcolor');
            }
        }
    }
    headcolor();
    $(window).scroll(function (event) {
        headcolor();
    })
})