(function ($, window, document, undefined) {
	//定义分页类
	function Paging(element, options) {
		this.element = element;
		//传入形参
		this.options = {
			pageNo: options.pageNo || 1,
			totalPage: options.totalPage,
			totalSize: options.totalSize,
			callback: options.callback
		};
		//根据形参初始化分页html和css代码
		this.init();
	}
	//对Paging的实例对象添加公共的属性和方法
	Paging.prototype = {
		constructor: Paging,
		init: function () {
			this.creatHtml();
			this.bindEvent();
		},
		creatHtml: function () {
			var me = this;
			var content = "";
			var current = me.options.pageNo;
			var total = me.options.totalPage;
			var totalNum = me.options.totalSize;
			// content += "<a id=\"firstPage\">首页</a><a id='prePage'><img src='./images/list/left_icon.png'/></a>";
			//总页数大于5时候
			if (total > 5) {
				//当前页数小于4时显示省略号
				if (current < 4) {
					for (var i = 1; i < 5; i++) {
						if (current == i) {
							content += "<a class='current'>" + i + "</a>";
						} else {
							content += "<a>" + i + "</a>";
						}
					}
					content += "<span>. . .</span>";
					content += "<a>" + total + "</a>";
				} else {
					//判断页码在末尾的时候
					if (current < total - 2) {
						for (var i = current - 2; i < current + 2; i++) {
							if (current == i) {
								content += "<a class='current'>" + i + "</a>";
							} else {
								content += "<a>" + i + "</a>";
							}
						}
						content += "<span>. . .</span>";
						content += "<a>" + total + "</a>";
						//页码在中间部分时候	
					} else {
						content += "<a>1</a>";
						content += "<span>. . .</span>";
						for (var i = total - 3; i < total + 1; i++) {
							if (current == i) {
								content += "<a class='current'>" + i + "</a>";
							} else {
								content += "<a>" + i + "</a>";
							}
						}
					}
				}
				//页面总数小于5的时候
			} else {
				for (var i = 1; i < total + 1; i++) {
					if (current == i) {
						content += "<a class='current'>" + i + "</a>";
					} else {
						content += "<a>" + i + "</a>";
					}
				}
			}
			// content += "<a id='nextPage'><img src='./images/list/right_icon.png'/></a>";
			// content += "<a id=\"lastPage\">尾页</a>";
			// content += "<span class='totalPages'> 共<span>" + total + "</span>页 </span>";
			// content += "<span class='totalSize'> 共<span>" + totalNum + "</span>条记录 </span>";
			// $('#listpage').find('#page_content').html(content);
			me.element.find('#page_content').html(content);
		},
		//添加页面操作事件
		bindEvent: function () {
			var me = this;
			me.element.off('click', 'a');
			me.element.on('click', 'a', function () {
				var num = $(this).html();
				var id = $(this).attr("id");
				if (id == "prePage") {
					if (me.options.pageNo == 1) {
						return;
						me.options.pageNo = 1;
					} else {
						me.options.pageNo = +me.options.pageNo - 1;
					}
				} else if (id == "nextPage") {
					if (me.options.pageNo == me.options.totalPage) {
						return
						me.options.pageNo = me.options.totalPage
					} else {
						me.options.pageNo = +me.options.pageNo + 1;
					}

				} else if (id == "firstPage") {
					me.options.pageNo = 1;
				} else if (id == "lastPage") {
					me.options.pageNo = me.options.totalPage;
				} else {
					me.options.pageNo = +num;
				}
				me.creatHtml();
				if (me.options.callback) {
					me.options.callback(me.options.pageNo);
				}
			});
		}
	};
	//通过jQuery对象初始化分页对象
	$.fn.paging = function (options) {
		return new Paging($(this), options);
	}
})(jQuery, window, document);