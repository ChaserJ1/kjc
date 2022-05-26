// 论文统计
var reWs_kStr = $("#reCitations_k").val();
reWs_kStr = reWs_kStr.replace("[","");
reWs_kStr = reWs_kStr.replace("]","");
var reWs_k_temp = reWs_kStr.split(",");

var reWs_vStr = $("#reCitations_v").val();
reWs_vStr = reWs_vStr.replace("[","");
reWs_vStr = reWs_vStr.replace("]","");
var reWs_v_temp = reWs_vStr.split(",");

var reWs_pStr = $("#reCitations_pe").val();
reWs_pStr = reWs_pStr.replace("[","");
reWs_pStr = reWs_pStr.replace("]","");
var reWs_p_temp = reWs_pStr.split(",");

var reWs_fStr = $("#reCitations_fu").val();
reWs_fStr = reWs_fStr.replace("[","");
reWs_fStr = reWs_fStr.replace("]","");
var reWs_f_temp = reWs_fStr.split(",");

var reWs_keStr = $("#reCitations_ke").val();
reWs_keStr = reWs_keStr.replace("[","");
reWs_keStr = reWs_keStr.replace("]","");
var reWs_ke_temp = reWs_keStr.split(",");

// A
var reWs_vStr_A = $("#reCitations_v_A").val();
reWs_vStr_A = reWs_vStr_A.replace("[","");
reWs_vStr_A = reWs_vStr_A.replace("]","");
var reWs_v_temp_A = reWs_vStr_A.split(",");

var reWs_pStr_A = $("#reCitations_pe_A").val();
reWs_pStr_A = reWs_pStr_A.replace("[","");
reWs_pStr_A = reWs_pStr_A.replace("]","");
var reWs_p_temp_A = reWs_pStr_A.split(",");

var reWs_fStr_A = $("#reCitations_fu_A").val();
reWs_fStr_A = reWs_fStr_A.replace("[","");
reWs_fStr_A = reWs_fStr_A.replace("]","");
var reWs_f_temp_A = reWs_fStr_A.split(",");

var reWs_keStr_A = $("#reCitations_ke_A").val();
reWs_keStr_A = reWs_keStr_A.replace("[","");
reWs_keStr_A = reWs_keStr_A.replace("]","");
var reWs_ke_temp_A = reWs_keStr_A.split(",");
// B
var reWs_vStr_B = $("#reCitations_v_B").val();
reWs_vStr_B = reWs_vStr_B.replace("[","");
reWs_vStr_B = reWs_vStr_B.replace("]","");
var reWs_v_temp_B = reWs_vStr_B.split(",");

var reWs_pStr_B = $("#reCitations_pe_B").val();
reWs_pStr_B = reWs_pStr_B.replace("[","");
reWs_pStr_B = reWs_pStr_B.replace("]","");
var reWs_p_temp_B = reWs_pStr_B.split(",");

var reWs_fStr_B = $("#reCitations_fu_B").val();
reWs_fStr_B = reWs_fStr_B.replace("[","");
reWs_fStr_B = reWs_fStr_B.replace("]","");
var reWs_f_temp_B = reWs_fStr_B.split(",");

var reWs_keStr_B = $("#reCitations_ke_B").val();
reWs_keStr_B = reWs_keStr_B.replace("[","");
reWs_keStr_B = reWs_keStr_B.replace("]","");
var reWs_ke_temp_B = reWs_keStr_B.split(",");

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
var reWs_p = [];
var reWs_f = [];
var reWs_ke = [];
for (var i=0;i<reWs_k_temp.length;i++)
{ 
	reWs_k[i] = reWs_k_temp[i];
	reWs_v[i] = Number(reWs_v_temp[i]);
	reWs_p[i] = Number(reWs_p_temp[i]);
	reWs_f[i] = Number(reWs_f_temp[i]);
	reWs_ke[i] = Number(reWs_ke_temp[i]);
}
if (reWs_k_temp.length==0){
	//如果只有一个特殊处理
	reWs_k[0] = reWs_kStr;
	reWs_v[0] = reWs_vStr;
	reWs_p[0] = reWs_pStr;
	reWs_f[0] = reWs_fStr;
	reWs_ke[0] = reWs_keStr;
}
// A
var reWs_v_A = [];
var reWs_p_A = [];
var reWs_f_A = [];
var reWs_ke_A = [];
for (var i=0;i<reWs_k_temp.length;i++)
{ 
	reWs_v_A[i] = Number(reWs_v_temp_A[i]);
	reWs_p_A[i] = Number(reWs_p_temp_A[i]);
	reWs_f_A[i] = Number(reWs_f_temp_A[i]);
	reWs_ke_A[i] = Number(reWs_ke_temp_A[i]);
}
if (reWs_k_temp.length==0){
	//如果只有一个特殊处理
	reWs_k_A[0] = reWs_kStr;
	reWs_v_A[0] = reWs_vStr;
	reWs_p_A[0] = reWs_pStr;
	reWs_f_A[0] = reWs_fStr;
	reWs_ke_A[0] = reWs_keStr;
}
// B
var reWs_v_B = [];
var reWs_p_B = [];
var reWs_f_B = [];
var reWs_ke_B = [];
for (var i=0;i<reWs_k_temp.length;i++)
{ 
	reWs_v_B[i] = Number(reWs_v_temp_B[i]);
	reWs_p_B[i] = Number(reWs_p_temp_B[i]);
	reWs_f_B[i] = Number(reWs_f_temp_B[i]);
	reWs_ke_B[i] = Number(reWs_ke_temp_B[i]);
}
if (reWs_k_temp.length==0){
	//如果只有一个特殊处理
	reWs_k_B[0] = reWs_kStr;
	reWs_v_B[0] = reWs_vStr;
	reWs_p_B[0] = reWs_pStr;
	reWs_f_B[0] = reWs_fStr;
	reWs_ke_B[0] = reWs_keStr;
}

//论文分析
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
//删除开头空格
for (var i=0;i<reA_k_temp.length;i++){
	if (reA_k_temp[i][0]==" "){
		reA_k_temp[i] = reA_k_temp[i].substr(1);
	}
	if (reA_v_temp[i][0]==" "){
		reA_v_temp[i] = reA_v_temp[i].substr(1);
	}
}
for (var i=0;i<reA_k_temp.length;i++)
{ 
	reA_k[i] = reA_k_temp[i];
	reA_v[i] = Number(reA_v_temp[i]);
}
if (reA_k_temp.length==0){
	//如果只有一个特殊处理
	reA_k[0] = reA_kStr;
	reA_v[0] = reA_vStr;
}
//console.log("reA_k", reA_k);
//console.log("reA_v", reA_v);

//历年统计
var reH_k = [];
var reH_vj = [];
var reH_vh = [];
var reH_vk = [];
var reH_kStr = $("#reYear_k").val();
var reH_vjStr = $("#reP_jd_v").val();
var reH_vhStr = $("#reP_hd_v").val();
var reH_vkStr = $("#reP_kd_v").val();

reH_kStr = reH_kStr.replace("[","");
reH_kStr = reH_kStr.replace("]","");
reH_vjStr = reH_vjStr.replace("[","");
reH_vjStr = reH_vjStr.replace("]","");
reH_vhStr = reH_vhStr.replace("[","");
reH_vhStr = reH_vhStr.replace("]","");
reH_vkStr = reH_vkStr.replace("[","");
reH_vkStr = reH_vkStr.replace("]","");
var reH_k_temp = reH_kStr.split(",");
var reH_vj_temp = reH_vjStr.split(",");
var reH_vh_temp = reH_vhStr.split(",");
var reH_vk_temp = reH_vkStr.split(",");
for (var i=0;i<reH_k_temp.length;i++)
{ 
	reH_k[i] = reH_k_temp[i];
	reH_vj[i] = Number(reH_vj_temp[i]);
	reH_vh[i] = Number(reH_vh_temp[i]);
	reH_vk[i] = Number(reH_vk_temp[i]);
}
if (reH_k_temp.length==0){
	//如果只有一个特殊处理
	reH_k[0] = reH_kStr;
	reH_vj[0] = reH_vjStr;
	reH_vh[0] = reH_vhStr;
	reH_vk[0] = reH_vkStr;
}
//console.log("reH_k", reH_k);
//console.log("reH_vj", reH_vj);
//console.log("reH_vh", reH_vh);
//console.log("reH_vk", reH_vk);

Apex.grid = {
    borderColor: '#191e3a'
};
Apex.track = {
    background: '#0e1726',
};
Apex.tooltip = {
    theme: 'dark'
};
// Simple Line

var sline = {
  chart: {
    height: 250,
    type: 'line',
    zoom: {
      enabled: false
    },
    toolbar: {
      show: false,
    }
  },
  dataLabels: {
    enabled: false
  },
  stroke: {
    curve: 'straight'
  },
  series: [{
    name: "Desktops",
    data: [10, 41, 35, 51, 49, 62, 69, 91, 148]
  }],
  title: {
    text: 'Product Trends by Month',
    align: 'left'
  },
  grid: {
    row: {
      colors: ['#3b3f5c', 'transparent'], // takes an array which will be repeated on columns
      opacity: 0.5
    },
  },
  xaxis: {
    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
  }
};

var chart = new ApexCharts(
  document.querySelector("#s-line"),
  sline
);

chart.render();


// Simple Line Area

var sLineArea = {
    chart: {
        height: 250,
        type: 'area',
        toolbar: {
          show: false,
        }
    },
    dataLabels: {
        enabled: false
    },
    stroke: {
        curve: 'smooth'
    },
    series: [{
        name: 'series1',
        data: [31, 40, 28, 51, 42, 109, 100]
    }, {
        name: 'series2',
        data: [11, 32, 45, 32, 34, 52, 41]
    }],

    xaxis: {
        type: 'datetime',
        categories: ["2018-09-19T00:00:00", "2018-09-19T01:30:00", "2018-09-19T02:30:00", "2018-09-19T03:30:00", "2018-09-19T04:30:00", "2018-09-19T05:30:00", "2018-09-19T06:30:00"],                
    },
    tooltip: {
        x: {
            format: 'dd/MM/yy HH:mm'
        },
    }
};

var chart = new ApexCharts(
    document.querySelector("#s-line-area"),
    sLineArea
);

chart.render();

// Simple Column

var sCol = {
	colors:gaojing_color,
    chart: {
        height: 250,
        type: 'bar',
        toolbar: {
          show: false,
        }
    },
    plotOptions: {
        bar: {
            horizontal: false,
            columnWidth: '24%',
            distributed: true,
            //,endingShape: 'rounded'  
        },
    },
    dataLabels: {
        enabled: false,
    },
    stroke: {
        show: true,
        width: 2,
        colors: ['transparent']
    },
    series: [{
        name: '论文数',
        data: reWs_v
    }],
    xaxis: {
        categories: reWs_k,
    },
    yaxis: {
        title: {
            text: ' (个)'
        }
    },
    fill: {
        opacity: 1

    },
    tooltip: {
        y: {
            formatter: function (val) {
                return  val + " 个";
            }
        }
    }
};

var chart = new ApexCharts(
    document.querySelector("#s-col"),
    sCol
);

chart.render();


// Simple Column Stacked

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
        name: '论文数',
        data: reWs_v
    },{
        name: '论文人',
        data: reWs_p
    }, {
        name: '基金人',
        data: reWs_f
    },{
        name: '科研人',
        data: reWs_ke
    }],
    xaxis: {
        type: '院系',
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

//A
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
	        name: '论文数',
	        data: reWs_v_A
	    },{
	        name: '论文人',
	        data: reWs_p_A
	    }, {
	        name: '基金人',
	        data: reWs_f_A
	    },{
	        name: '科研人',
	        data: reWs_ke_A
	    }],
	    xaxis: {
	        type: '院系',
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
//B
var sColStacked_B = {
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
	        name: '论文数',
	        data: reWs_v_B
	    },{
	        name: '论文人',
	        data: reWs_p_B
	    }, {
	        name: '基金人',
	        data: reWs_f_B
	    },{
	        name: '科研人',
	        data: reWs_ke_B
	    }],
	    xaxis: {
	        type: '院系',
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

	var chart_B = new ApexCharts(
	    document.querySelector("#s-col-stacked_B"),
	    sColStacked_B
	);

	chart_B.render();
// Simple Bar

var sBar = {
    chart: {
        height: 250,
        type: 'bar',
        toolbar: {
          show: false,
        }
    },
    plotOptions: {
        bar: {
            horizontal: true,
        }
    },
    dataLabels: {
        enabled: false
    },
    series: [{
        data: [400, 430, 448, 470, 540, 580, 690, 1100, 1200, 1380]
    }],
    xaxis: {
        categories: ['South Korea', 'Canada', 'United Kingdom', 'Netherlands', 'Italy', 'France', 'Japan', 'United States', 'China', 'Germany'],
    }
};

var chart = new ApexCharts(
    document.querySelector("#s-bar"),
    sBar
);

chart.render();


// Mixed Chart

var options = {
  chart: {
    height: 250,
    type: 'line',
    toolbar: {
      show: false,
    }
  },
  series: [{
    name: '京地',
    type: 'column',
    data: reH_vj
  }, {
    name: '汉地',
    type: 'line',
    data: reH_vh
  },{
	name: '科地',
	type: 'line',
	data: reH_vk
  }],
  stroke: {
    width: [0, 4]
  },
  title: {
    text: ''
  },
  labels: reH_k,
  fill: {
      opacity: 0.5 //设置图形的透明度，数值越小透明度越高，数值范围0-1
    },
  tooltip: {
	  x:{
	    format:"yyyy年"
	  },
	  y: {
	    formatter: function (val) {
	      return val + "篇";
	    }
	  }
  },
  dataLabels: {
	  enabled: true
  },
  xaxis: {
    type: 'datetime',
	labels:{
        format:"yyyy"
      }
  },
  yaxis: [{
    title: {
      text: '论文总数',
    },
  }]
};

var chart = new ApexCharts(
  document.querySelector("#mixed-chart"),
  options
);

chart.render();


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


// Radial Chart

var radialChart = {
    chart: {
        height: 250,
        type: 'radialBar',
        toolbar: {
          show: false,
        }
    },
    plotOptions: {
        radialBar: {
            dataLabels: {
                name: {
                    fontSize: '22px',
                },
                value: {
                    fontSize: '16px',
                },
                total: {
                    show: true,
                    label: 'Total',
                    formatter: function (w) {
                        // By default this function returns the average of all series. The below is just an example to show the use of custom formatter function
                        return 249;
                    }
                }
            }
        }
    },
    series: reA_v,
    labels: reA_k,
};

var chart = new ApexCharts(
    document.querySelector("#radial-chart"),
    radialChart
);

chart.render();