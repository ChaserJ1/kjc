$(function () {
    // 上方导航
    $('.hn_main .hn_mn_ul li').hover(function () {
        $(this).children('div:first').addClass("hn_mn_ul_li_hover");
        $(this).children('.hn_mn_nav_second').slideDown();
        var secwidth = $(this).children('.hn_mn_nav_second').outerWidth();
        var firwidth = $(this).children('.hn_mn_ul_li_hover').outerWidth();
        $(this).children('.hn_mn_nav_second').css({ 'left': - (secwidth - firwidth) / 2 })
    }, function () {
        $(this).children('.hn_mn_nav_second').slideUp();
        $(this).children('div:first').removeClass("hn_mn_ul_li_hover");
    });
    
    var topmain_height = $('.home_banner').height();
    var centerlist_height = $('#list_detail_box').height();
    var headcolor = function () {  //导航背景色变化
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
    // 最上方轮播
    var timelineSwiper = new Swiper('.timelineSwiper', {
        // direction: 'vertical',
        mode: 'vertical',
        loop: false,
        speed: 700,
        // mousewheelControl: true,
        pagination: '.swiper-pagination',
        paginationClickable: true,
        autoplay: 6000,
        autoplayDisableOnInteraction: false,
        breakpoints: {
            768: {
                direction: 'horizontal',
            }
        }
    });
    // 公告..显示动画
    window.scrollReveal = new scrollReveal({ reset: true, move: '50px' });
    // 轮播---------------
    $('.timelineSwiper').hover(function () {
        timelineSwiper.stopAutoplay();
    }, function () {
        timelineSwiper.startAutoplay();
    });

});