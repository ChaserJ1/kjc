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
console.log("reH_k", reH_k);
console.log("reH_vj", reH_vj);
console.log("reH_vh", reH_vh);
console.log("reH_vk", reH_vk);

Apex.grid = {
    borderColor: '#191e3a'
};
Apex.track = {
    background: '#0e1726',
};
Apex.tooltip = {
    theme: 'dark'
};

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