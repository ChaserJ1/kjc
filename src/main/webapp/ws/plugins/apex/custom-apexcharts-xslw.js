// 年到账科研经费
var reWs_kStr = $("#ws_a_cugb_k").val();
reWs_kStr = reWs_kStr.replace("[","");
reWs_kStr = reWs_kStr.replace("]","");
var reWs_k_temp = reWs_kStr.split(",");
var reWs_vStr = $("#ws_a_cugb_SCI_v").val();
reWs_vStr = reWs_vStr.replace("[","");
reWs_vStr = reWs_vStr.replace("]","");
var reWs_v_temp = reWs_vStr.split(",");
// 自然科学基金年资助项目数
var reWs_vStr_A = $("#ws_a_cugb_BZX_v").val();
reWs_vStr_A = reWs_vStr_A.replace("[","");
reWs_vStr_A = reWs_vStr_A.replace("]","");
var reWs_v_temp_A = reWs_vStr_A.split(",");

var ws_a_cugb_SCI_unit = $("#ws_a_cugb_SCI_unit").val();
var ws_a_cugb_BZX_unit = $("#ws_a_cugb_BZX_unit").val();
var gaojing_color = [];
var indicator = {};

// 删除开头空格
for (var i=0;i<reWs_k_temp.length;i++){
	if (reWs_k_temp[i][0]==" "){
		reWs_k_temp[i] = reWs_k_temp[i].substr(1);
	}
}

// 处理格式
var reWs_k = [];
var reWs_v = [];
for (var i=0;i<reWs_k_temp.length;i++)
{ 
	reWs_k[i] = reWs_k_temp[i];
	reWs_v[i] = Number(reWs_v_temp[i]);
}
if (reWs_k_temp.length==0){
	//如果只有一个特殊处理
	reWs_k[0] = reWs_kStr;
	reWs_v[0] = reWs_vStr;
}
// A
var reWs_v_A = [];
for (var i=0;i<reWs_k_temp.length;i++)
{ 
	reWs_v_A[i] = Number(reWs_v_temp_A[i]);
}
if (reWs_k_temp.length==0){
	//如果只有一个特殊处理
	reWs_v_A[0] = reWs_vStr;
}

// Simple Column
var sColStacked = {
    chart: {
        height: 250,
        type: 'bar',
        stacked: true,
        toolbar: {
          show: false,
        }
    },
    responsive: [{
        breakpoint: 480,
        options: {
            legend: {
                position: 'bottom',
                offsetX: -10,
                offsetY: 0
            }
        }
    }],
    plotOptions: {
        bar: {
            horizontal: false,
        },
    },
    series: [{
        name: ws_a_cugb_SCI_unit,
        data: reWs_v
    }],
    xaxis: {
        type: '年份',
        categories: reWs_k,
    },
    legend: {
        position: 'right',
        offsetY: 40
    },
    fill: {
        opacity: 1
    },
};

var chart = new ApexCharts(
    document.querySelector("#s-col-stacked"),
    sColStacked
);

chart.render();

// A
var sColStacked_A = {
    chart: {
        height: 250,
        type: 'bar',
        stacked: true,
        toolbar: {
          show: false,
        }
    },
    responsive: [{
        breakpoint: 480,
        options: {
            legend: {
                position: 'bottom',
                offsetX: -10,
                offsetY: 0
            }
        }
    }],
    plotOptions: {
        bar: {
            horizontal: false,
        },
    },
    series: [{
        name: ws_a_cugb_BZX_unit,
        data: reWs_v_A
    }],
    xaxis: {
        type: '年份',
        categories: reWs_k,
    },
    legend: {
        position: 'right',
        offsetY: 40
    },
    fill: {
        opacity: 1
    },
};

var chart_A = new ApexCharts(
    document.querySelector("#s-col-stacked_A"),
    sColStacked_A
);

chart_A.render();
