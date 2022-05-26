var reWs_kStr = $("#reCitationsPart_k").val();
reWs_kStr = reWs_kStr.replace("[","");
reWs_kStr = reWs_kStr.replace("]","");
var reWs_k_temp = reWs_kStr.split(",");
var reWs_vStr = $("#reCitationsPart_v").val();
reWs_vStr = reWs_vStr.replace("[","");
reWs_vStr = reWs_vStr.replace("]","");
var reWs_v_temp = reWs_vStr.split(",");
var reWs_vStr_A = $("#reCitationsPart_v_A").val();
reWs_vStr_A = reWs_vStr_A.replace("[","");
reWs_vStr_A = reWs_vStr_A.replace("]","");
var reWs_v_temp_A = reWs_vStr_A.split(",");
var reWs_vStr_B = $("#reCitationsPart_v_B").val();
reWs_vStr_B = reWs_vStr_B.replace("[","");
reWs_vStr_B = reWs_vStr_B.replace("]","");
var reWs_v_temp_B = reWs_vStr_B.split(",");

var len_data=0;
for (var i=0;i<reWs_k_temp.length;i++)
{ 
	if(reWs_v_temp[i]!='0.0'&&reWs_v_temp[i]!=' 0.0'){
		len_data++;
	}
}
var data = new Array(len_data);
var data_A = new Array(len_data);
var data_B = new Array(len_data);
var j = 0;
for (var i=0;i<reWs_k_temp.length;i++)
{ 
	if(reWs_v_temp[i]!='0.0'&&reWs_v_temp[i]!=' 0.0'){
		var map = {year:reWs_k_temp[i], litres:reWs_v_temp[i]};
		var map_A = {year:reWs_k_temp[i], litres:reWs_v_temp_A[i]};
		var map_B = {year:reWs_k_temp[i], litres:reWs_v_temp_B[i]};
		data[j] = map;
		data_A[j] = map_A;
		data_B[j] = map_B;
		j++;
	}
}

am4core.ready(function() {
	// Themes begin
    function am4themes_myTheme(target) {
        if (target instanceof am4core.ColorSet) {
            target.list = [
                am4core.color("#CCE1FE"),
                am4core.color("#D8C7E8"),
                am4core.color("#99C2FD"),
                am4core.color("#BFA1D8"),
                am4core.color("#66A4FC"),
                am4core.color("#A57BC8"),
                am4core.color("#3385FB"),
                am4core.color("#8B56B9"),
                am4core.color("#0067FA")
            ];
        }
    }
    am4core.useTheme(am4themes_animated);
    am4core.useTheme(am4themes_myTheme);
    // Themes end
    var chart = am4core.create("chartdiv", am4charts.PieChart3D);
    chart.padding(40, 40, 40, 40);
    chart.hiddenState.properties.opacity = 0; // this creates initial fade-in
    chart.data = data;
    chart.innerRadius = am4core.percent(40);
    chart.depth = 120;
    chart.legend = new am4charts.Legend();
    chart.legend.labels.template.fill = am4core.color("#E6EFF4");
    chart.legend.valueLabels.template.fill = am4core.color("#E6EFF4");
    var series = chart.series.push(new am4charts.PieSeries3D());
    series.dataFields.value = "litres";
    series.dataFields.depthValue = "litres";
    series.dataFields.category = "year";
    series.slices.template.cornerRadius = 10;
    series.labels.template.text = "{category}:{value}篇 ({value.percent.formatNumber('#.0')}%)";
    series.labels.template.fill = '#E6EFF4';
    //去除图表logo图标
    let eles = document.querySelectorAll("[aria-labelledby$=-title]");
    eles.forEach((ele) => {
        ele.style.visibility = "hidden";
    })
    
	// A
    // Themes begin
    function am4themes_myTheme_A(target) {
        if (target instanceof am4core.ColorSet) {
            target.list = [
                am4core.color("#E29D9D"),
                am4core.color("#77A5C1"),
                am4core.color("#DD8D8C"),
                am4core.color("#6399B8"),
                am4core.color("#D87D7C"),
                am4core.color("#508CAF"),
                am4core.color("#D36C6B"),
                am4core.color("#3C7FA6"),
                am4core.color("#CE5C5B"),
            ];
        }
    }
    am4core.useTheme(am4themes_animated);
    am4core.useTheme(am4themes_myTheme_A);
    // Themes end
    var chart_A = am4core.create("chartdiv_A", am4charts.PieChart3D);
    chart_A.padding(40, 40, 40, 40);
    chart_A.hiddenState.properties.opacity = 0; // this creates initial fade-in
    chart_A.data = data_A;
    chart_A.innerRadius = am4core.percent(40);
    chart_A.depth = 120;
    chart_A.legend = new am4charts.Legend();
    chart_A.legend.labels.template.fill = am4core.color("#E6EFF4");
    chart_A.legend.valueLabels.template.fill = am4core.color("#E6EFF4");
    var series_A = chart_A.series.push(new am4charts.PieSeries3D());
    series_A.dataFields.value = "litres";
    series_A.dataFields.depthValue = "litres";
    series_A.dataFields.category = "year";
    series_A.slices.template.cornerRadius = 10;
    series_A.labels.template.text = "{category}:{value}篇 ({value.percent.formatNumber('#.0')}%)";
    series_A.labels.template.fill = '#E6EFF4';
    //去除图表logo图标
    let eles_A = document.querySelectorAll("[aria-labelledby$=-title]");
    eles_A.forEach((ele) => {
        ele.style.visibility = "hidden";
    })
    // B
    // Themes begin
    function am4themes_myTheme_B(target) {
        if (target instanceof am4core.ColorSet) {
            target.list = [
                am4core.color("#B7DEB3"),
                am4core.color("#A6D6A0"),
                am4core.color("#94CD8C"),
                am4core.color("#82C579"),
                am4core.color("#70BD66"),
                am4core.color("#5EB453"),
                am4core.color("#4CAC40"),
                am4core.color("#4CAC40"),
                am4core.color("#4CAC40"),
            ];
        }
    }
    am4core.useTheme(am4themes_animated);
    am4core.useTheme(am4themes_myTheme_B);
    // Themes end
    var chart_B = am4core.create("chartdiv_B", am4charts.PieChart3D);
    chart_B.padding(40, 40, 40, 40);
    chart_B.hiddenState.properties.opacity = 0; // this creates initial fade-in
    chart_B.data = data_B;
    chart_B.innerRadius = am4core.percent(40);
    chart_B.depth = 120;
    chart_B.legend = new am4charts.Legend();
    chart_B.legend.labels.template.fill = am4core.color("#E6EFF4");
    chart_B.legend.valueLabels.template.fill = am4core.color("#E6EFF4");
    var series_B = chart_B.series.push(new am4charts.PieSeries3D());
    series_B.dataFields.value = "litres";
    series_B.dataFields.depthValue = "litres";
    series_B.dataFields.category = "year";
    series_B.slices.template.cornerRadius = 10;
    series_B.labels.template.text = "{category}:{value}篇 ({value.percent.formatNumber('#.0')}%)";
    series_B.labels.template.fill = '#E6EFF4';
    //去除图表logo图标
    let eles_B = document.querySelectorAll("[aria-labelledby$=-title]");
    eles_B.forEach((ele) => {
        ele.style.visibility = "hidden";
    })
}); // end am4core.ready()