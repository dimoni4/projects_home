$(".button-collapse").sideNav();

function draw(chart) {
    $('#'+chart.id).highcharts({
        title: {
            text: chart.title,
            x: -20
        },
        xAxis: {
            categories: chart.categories
        },
        yAxis: {
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }],
            title: {
                text: ''
            },
            min: 0
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0,
            enabled: chart.legend || false
        },
        series: [{
            data: chart.data
        }],
        credits: {
            enabled: false
        }
    });
}

function getDataAndDraw(chart) {
    chart.cont.spin();
    $.ajax({
            url: "project/violations",
            type: "GET",
            dataType: "json",
            success: function(data){
                chart.cont.highcharts({
                    chart: {
                        zoomType: 'x'
                    },
                    title: {
                        text: 'Violations'
                    },
                    subtitle: {
                        text: document.ontouchstart === undefined ?
                            'Click and drag in the plot area to zoom in' : 'Pinch the chart to zoom in'
                    },
                    xAxis: {
                        type: 'datetime'
                    },
                    yAxis: {
                        title: {
                            text: 'Exchange rate'
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    plotOptions: {
                        area: {
                            fillColor: {
                                linearGradient: {
                                    x1: 0,
                                    y1: 0,
                                    x2: 0,
                                    y2: 1
                                },
                                stops: [
                                    [0, Highcharts.getOptions().colors[0]],
                                    [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                                ]
                            },
                            marker: {
                                radius: 2
                            },
                            lineWidth: 1,
                            states: {
                                hover: {
                                    lineWidth: 1
                                }
                            },
                            threshold: null
                        }
                    },

                    series: [{
                        type: 'area',
                        name: 'USD to EUR',
                        data: data
                    }]
                });
                chart.cont.unspin();
            }
        }
    );
}