
var heatMapChart = null; 
function heatmap(dataList) {

    // Apply chart themes
    am4core.useTheme(am4themes_animated);

    let heatMapChart = am4core.create("heatmap", am4charts.XYChart);
    heatMapChart.maskBullets = false;
    heatMapChart.dateFormatter.inputDateFormat = "yyyy-MM-dd HH:mm:ss";
    // heatMapChart.background.fill = am4core.color("#ff");
    heatMapChart.plotContainer.background.fill = am4core.color("gray");  // 원하는 배경 색상
    heatMapChart.plotContainer.background.fillOpacity = 1;  // 배경의 불투명도 설정


    let xAxis = heatMapChart.xAxes.push(new am4charts.CategoryAxis());
    xAxis.dataFields.category = "time";
    xAxis.renderer.grid.template.disabled = true;
    xAxis.renderer.minGridDistance = 40;
    xAxis.renderer.labels.template.rotation = 45;
    xAxis.renderer.labels.template.fill = am4core.color("#000000");

    let yAxis = heatMapChart.yAxes.push(new am4charts.CategoryAxis());
    yAxis.dataFields.category = "id";
    yAxis.renderer.grid.template.disabled = true;
    yAxis.renderer.inversed = true;
    yAxis.renderer.minGridDistance = 30;
    yAxis.renderer.labels.template.fill = am4core.color("#000000");

    let series = heatMapChart.series.push(new am4charts.ColumnSeries());
    series.dataFields.categoryX = "time";
    series.dataFields.openDateX = "time";
    series.dataFields.categoryY = "id";
    series.dataFields.value = "value";

    series.sequencedInterpolation = true;
    series.defaultState.transitionDuration = 3000;

    series.columns.template.width = am4core.percent(100);
    series.columns.template.height = am4core.percent(100);


    let columnTemplate = series.columns.template;
    columnTemplate.strokeWidth = 0.05;
    columnTemplate.strokeOpacity = 1;
    columnTemplate.stroke = am4core.color("#000000");
    columnTemplate.tooltipText = "{id} - {time}";
    columnTemplate.column.adapter.add("fill", function (fill, target) {
        if (target.dataItem) {
            if (target.dataItem.value == 1) {
                return am4core.color("#0f0")
            }
            else if (target.dataItem.value == 2) {
                return am4core.color("#f00")
            }
            else {
                return am4core.color("#00");
            }
        }
        return fill;
    });

    let legend = new am4charts.Legend();
    legend.parent = heatMapChart.chartContainer;
    legend.labels.template.fill = am4core.color("#00");
    legend.labels.template.strokeWidth = 1;
    legend.labels.template.stroke = am4core.color("#ff");
    legend.data = [{
        "name": "위치 데이터 정상 수신",
        "fill": am4core.color("#0f0"),
    }, {
        "name": "위치 데이터 미 수신",
        "fill": am4core.color("gray"),
        "strokeWidth": 1
    }, {
        "name": "배터리 10% 미만",
        "fill": am4core.color("#f00")
    }];


    heatMapChart.scrollbarX = new am4core.Scrollbar();
    heatMapChart.scrollbarX.series = series; // 스크롤바가 이 시리즈와 함께 작동하도록 설정

    heatMapChart.data = dataList;
}