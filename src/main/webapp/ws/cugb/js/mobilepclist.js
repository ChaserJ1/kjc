$(function () {
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
    // 移动端二级导航
    $(".m_home_headerbox_cover").on("touchmove", function (event) {
        event.preventDefault();
    });
    $('.have_child_nav').on('click', function () {
        $(this).find('.n_m_nav_more').toggleClass('nav_more_bot')
        $(this).find('.n_m_nav_item').toggle()
    })
    $('.n_m_nav_item a').on('click', function (event) {
        event.stopPropagation()
    })
    // 最上方轮播
    $('#toptimelineSwiper').removeClass('timeline').addClass('timeline_cover');
    var timelineSwiper = new Swiper('.timelineSwiper', {
        direction: 'horizontal',
        slidesPerView: 1,
        slidesPerGroup: 1,
        loop: true,
        speed: 700,
        pagination: '.swiper-pagination',
        paginationClickable: true,
        autoplay: 6000,
        autoplayDisableOnInteraction: false,
    });
    // 导航
    $('#home_head_closeIcon').click(function () {
        $(this).parent().parent().parent().css('opacity', 0);
        $(this).parent().parent().parent().css('visibility', 'hidden');
    })
    $('#home_head_openIcon').click(function () {
        $('#home_head_closeIcon').parent().parent().parent().css('opacity', 1);
        $('#home_head_closeIcon').parent().parent().parent().css('visibility', 'visible');
      	$('#home_head_closeIcon').parent().parent().parent().css('display', 'block');
    })
    if ($('.m_home_headerbox_cover .hm_nav_item') && $('.m_home_headerbox_cover .hm_nav_item').length % 2 == 0) {
        $('.m_home_headerbox_cover .hm_nav_item').eq(-2).css('border-bottom', 'none');
    }
    // 页脚
    $('.home_bottom .home_bot_linkbox').find('li').eq(1).css('width', '2.1rem');
    $('.home_bottom .home_bot_linkbox').find('li').eq(3).css('width', '2.1rem');
});