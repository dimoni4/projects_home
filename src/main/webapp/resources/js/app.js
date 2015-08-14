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
            url: "project/violations/"+1,
            type: "GET",
            dataType: "json",
            success: function(msg){
                console.log(msg);
                draw(chart);
                chart.cont.unspin();
            }
        }
    );

    //$.getJSON('project/violations',
    //    {},
    //    function(msg){
    //        console.log(msg);
    //        draw(chart);
    //        chart.cont.unspin();
    //    }
    //);
}