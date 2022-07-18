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

var ws_a_cugb_SCI_project = $("#ws_a_cugb_SCI_project").val();
var ws_a_cugb_BZX_project = $("#ws_a_cugb_BZX_project").val();
var ws_a_cugb_SCI_unit = $("#ws_a_cugb_SCI_unit").val();
var ws_a_cugb_BZX_unit = $("#ws_a_cugb_BZX_unit").val();

//console.log(reWs_k_temp);
//console.log(reWs_v_temp);
//console.log(reWs_v_temp_A);
//console.log(ws_a_cugb_SCI_unit);
//console.log(ws_a_cugb_BZX_unit);
var len_data=0;
for (var i=0;i<reWs_k_temp.length;i++)
{ 
	if(reWs_v_temp[i]!='0.0'&&reWs_v_temp[i]!=' 0.0'){
		len_data++;
	}
}
var data = new Array(len_data);
var data_A = new Array(len_data);
var j = 0;
for (var i=0;i<reWs_k_temp.length;i++)
{ 
	if(reWs_v_temp[i]!='0.0'&&reWs_v_temp[i]!=' 0.0'){ 
		var map = {year:reWs_k_temp[i], litres:reWs_v_temp[i]};
		var map_A = {year:reWs_k_temp[i], litres:reWs_v_temp_A[i]};
		data[j] = map;
		data_A[j] = map_A;
		j++;
	}
}
//console.log(data);
//console.log(data_A);

am4core.ready(function() {
	// Themes begin
	am4core.useTheme(am4themes_animated);
	// Themes end
	// Create chart instance
	var chart = am4core.create("chartdiv", am4charts.XYChart);
	chart.colors.list = [
        am4core.color("#FDF4F9"),
        am4core.color("#FBE9F2"),
        am4core.color("#F9DEEC"),
        am4core.color("#F7D3E5"),
        am4core.color("#F5C8DF"),
        am4core.color("#F2BCD8"),
        am4core.color("#F0B1D2"),
        am4core.color("#EEA6CB"),
        am4core.color("#EC9BC5"),
        am4core.color("#EA90BE"),
        am4core.color("#D382AB"),
        am4core.color("#BB7398"),
    ];
	chart.padding(40, 40, 40, 40);
	// Create axes
	var categoryAxis = chart.yAxes.push(new am4charts.CategoryAxis());
    categoryAxis.renderer.grid.template.location = 0;
	categoryAxis.dataFields.category = "year";
	categoryAxis.renderer.minGridDistance = 1;
    categoryAxis.renderer.inversed = false;
    categoryAxis.renderer.grid.template.disabled = true;
    categoryAxis.title.text = ws_a_cugb_SCI_project;
    categoryAxis.title.fontWeight = "bold";
    var valueAxis = chart.xAxes.push(new am4charts.ValueAxis());
    valueAxis.min = 0;
    valueAxis.title.text = ws_a_cugb_SCI_unit;
    valueAxis.title.fontWeight = "bold";
	// Create series
	var series1 = chart.series.push(new am4charts.ColumnSeries());
	series1.dataFields.categoryY = "year";
	series1.dataFields.valueX = "litres";
    series1.tooltipText = "{valueX.value}";
    series1.columns.template.strokeOpacity = 0;
    series1.columns.template.column.cornerRadiusBottomRight = 10;
    series1.columns.template.column.cornerRadiusTopRight = 10;
    series1.columns.template.tooltipText = "{categoryY}: {valueX}";
    var labelBullet = series1.bullets.push(new am4charts.LabelBullet());
    labelBullet.label.horizontalCenter = "left";
    labelBullet.label.dx = 10;
    labelBullet.label.text = "{values.valueX.workingValue.formatNumber('#.s')}";
    labelBullet.locationX = 1;
    // as by default columns of the same seriesA1 are of the same color, we add adapter which takes colors from chartA.colors color set
    series1.columns.template.adapter.add("fill", function (fill, target) {
        return chart.colors.getIndex(target.dataItem.index);
    });
    var series2 = chart.series.push(new am4charts.LineSeries());
    series2.name = "litres";
    series2.stroke = am4core.color("#CDA2AB");
    series2.strokeWidth = 1;
    series2.dataFields.valueX = "litres";
    series2.dataFields.categoryY = "year";
    chart.cursor = new am4charts.XYCursor();
    chart.cursor.lineY.disabled = true;
    chart.cursor.lineX.disabled = true;
	// Add data
	chart.data = data;
    let eles = document.querySelectorAll("[aria-labelledby$=-title]");
    eles.forEach((ele) => {
        ele.style.visibility = "hidden";
    })
	
	// A
	// Create chart instance
	var chart_A = am4core.create("chartdiv_A", am4charts.XYChart);
	chart_A.colors.list = [
        am4core.color("#EDF0F6"),
        am4core.color("#DAE0EC"),
        am4core.color("#C8D1E3"),
        am4core.color("#B5C1D9"),
        am4core.color("#A3B2D0"),
        am4core.color("#90A3C6"),
        am4core.color("#7E93BD"),
        am4core.color("#6B84B3"),
        am4core.color("#5974AA"),
        am4core.color("#4665A0"),
        am4core.color("#4665A0"),
        am4core.color("#4665A0"),
    ];
	chart_A.padding(40, 40, 40, 40);
	// Create axes
	var categoryAxis_A = chart_A.yAxes.push(new am4charts.CategoryAxis());
    categoryAxis_A.renderer.grid.template.location = 0;
	categoryAxis_A.dataFields.category = "year";
	categoryAxis_A.renderer.minGridDistance = 1;
    categoryAxis_A.renderer.inversed = false;
    categoryAxis_A.renderer.grid.template.disabled = true;
    categoryAxis_A.title.text = ws_a_cugb_BZX_project;
    categoryAxis_A.title.fontWeight = "bold";
    var valueAxis_A = chart_A.xAxes.push(new am4charts.ValueAxis());
    valueAxis_A.min = 0;
    valueAxis_A.title.text = ws_a_cugb_BZX_unit;
    valueAxis_A.title.fontWeight = "bold";
	// Create series
	var series_A1 = chart_A.series.push(new am4charts.ColumnSeries());
	series_A1.dataFields.categoryY = "year";
	series_A1.dataFields.valueX = "litres";
    series_A1.tooltipText = "{valueX.value}";
    series_A1.columns.template.strokeOpacity = 0;
    series_A1.columns.template.column.cornerRadiusBottomRight = 10;
    series_A1.columns.template.column.cornerRadiusTopRight = 10;
    series_A1.columns.template.tooltipText = "{categoryY}: {valueX}";
    var labelBullet = series_A1.bullets.push(new am4charts.LabelBullet());
    labelBullet.label.horizontalCenter = "left";
    labelBullet.label.dx = 10;
    labelBullet.label.text = "{values.valueX.workingValue.formatNumber('#.as')}";
    labelBullet.locationX = 1;
    // as by default columns of the same seriesA1 are of the same color, we add adapter which takes colors from chartA.colors color set
    series_A1.columns.template.adapter.add("fill", function (fill, target) {
        return chart_A.colors.getIndex(target.dataItem.index);
    });
    var series_A2 = chart_A.series.push(new am4charts.LineSeries());
    series_A2.name = "litres";
    series_A2.stroke = am4core.color("#CDA2AB");
    series_A2.strokeWidth = 1;
    series_A2.dataFields.valueX = "litres";
    series_A2.dataFields.categoryY = "year";
    chart_A.cursor = new am4charts.XYCursor();
    chart_A.cursor.lineY.disabled = true;
    chart_A.cursor.lineX.disabled = true;
	// Add data
	chart_A.data = data_A;
    let eles_A = document.querySelectorAll("[aria-labelledby$=-title]");
    eles_A.forEach((ele) => {
        ele.style.visibility = "hidden";
    })
}); // end am4core.ready()