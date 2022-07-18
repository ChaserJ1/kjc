// 论文分析
var reA_k = [];
var reA_v = [];
var reA_kStr = $("#reCitationsPart_k").val();
var reA_vStr = $("#reCitationsPart_v").val();
reA_kStr = reA_kStr.replace("[","");
reA_kStr = reA_kStr.replace("]","");
reA_vStr = reA_vStr.replace("[","");
reA_vStr = reA_vStr.replace("]","");
var reA_k_temp = reA_kStr.split(",");
var reA_v_temp = reA_vStr.split(",");
// A
var reA_v_A = [];
var reA_vStr_A = $("#reCitationsPart_v_A").val();
reA_vStr_A = reA_vStr_A.replace("[","");
reA_vStr_A = reA_vStr_A.replace("]","");
var reA_v_temp_A = reA_vStr_A.split(",");
// B
var reA_v_B = [];
var reA_vStr_B = $("#reCitationsPart_v_B").val();
reA_vStr_B = reA_vStr_B.replace("[","");
reA_vStr_B = reA_vStr_B.replace("]","");
var reA_v_temp_B = reA_vStr_B.split(",");

// 删除开头空格
for (var i=0;i<reA_k_temp.length;i++){
	if (reA_k_temp[i][0]==" "){
		reA_k_temp[i] = reA_k_temp[i].substr(1);
	}
}

// 处理格式
for (var i=0;i<reA_k_temp.length;i++)
{ 
	reA_k[i] = reA_k_temp[i];
	reA_v[i] = Number(reA_v_temp[i]);
	reA_v_A[i] = Number(reA_v_temp_A[i]);
	reA_v_B[i] = Number(reA_v_temp_B[i]);
}
if (reA_k_temp.length==0){
	// 如果只有一个特殊处理
	reA_k[0] = reA_kStr;
	reA_v[0] = reA_vStr;
	reA_v_A[0] = reA_v_AStr;
	reA_v_B[0] = reA_v_BStr;
}
console.log(reA_k);
console.log(reA_v);
console.log(reA_v_A);
console.log(reA_v_B);

Apex.grid = {
    borderColor: '#191e3a'
};
Apex.track = {
    background: '#0e1726',
};
Apex.tooltip = {
    theme: 'dark'
};

// Donut Chart

var donutChart = {
    chart: {
        height: 250,
        type: 'donut',
        toolbar: {
          show: false,
        }
    },
    stroke: {
      colors: '#0e1726'
    },
    series: reA_v,
    labels: reA_k,
    responsive: [{
        breakpoint: 480,
        options: {
            chart: {
                width: 200
            },
            legend: {
                position: 'bottom'
            }
        }
    }]
};

var donut = new ApexCharts(
    document.querySelector("#donut-chart"),
    donutChart
);

donut.render();

var donutChart_A = {
    chart: {
        height: 250,
        type: 'donut',
        toolbar: {
          show: false,
        }
    },
    stroke: {
      colors: '#0e1726'
    },
    series: reA_v_A,
    labels: reA_k,
    responsive: [{
        breakpoint: 480,
        options: {
            chart: {
                width: 200
            },
            legend: {
                position: 'bottom'
            }
        }
    }]
};

var donut_A = new ApexCharts(
    document.querySelector("#donut-chart_A"),
    donutChart_A
);

donut_A.render();

var donutChart_B = {
    chart: {
        height: 250,
        type: 'donut',
        toolbar: {
          show: false,
        }
    },
    stroke: {
      colors: '#0e1726'
    },
    series: reA_v_B,
    labels: reA_k,
    responsive: [{
        breakpoint: 480,
        options: {
            chart: {
                width: 200
            },
            legend: {
                position: 'bottom'
            }
        }
    }]
};

var donut_B = new ApexCharts(
    document.querySelector("#donut-chart_B"),
    donutChart_B
);

donut_B.render();