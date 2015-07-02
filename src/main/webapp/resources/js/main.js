/*Check active item in menu*/

$('i').click(function ( e ) {
     e.preventDefault();
	$("i.active").removeClass("active"); //Remove any "active" class  
    $(this).addClass("active"); //Add "active" class to selected tab  
});

$('#dashboard').click(function(){
	$('#header').text ('DASHBOARD');
	$('#content').text ('comming soon...');
});

$('#projects').click(function(){
	$('#header').text ('Projects');
	$('#content').load( "projects.html" )
	/*$('#content').text ('Projects comming soon...');*/
	
	
});

$('#settings').click(function(){
	$('#header').text ('Settings');
	$('#content').text ('comming soon...');
	console.log('bang');
});

/*chart example*/
/*
var chart = $(
<div id="example">
    <div class="demo-section k-content">
        <div id="chart"></div>
    </div>
    <script>
        var data = [
            {
                "source": "Hydro",
                "percentage": 22,
                "explode": true
            },
            {
                "source": "Solar",
                "percentage": 2
            },
            {
                "source": "Nuclear",
                "percentage": 49
            },
            {
                "source": "Wind",
                "percentage": 27
            }
        ];

        function createChart() {
            $("#chart").kendoChart({
                title: {
                    text: "Break-up of Spain Electricity Production for 2008"
                },
                legend: {
                    position: "bottom"
                },
                dataSource: {
                    data: data
                },
                series: [{
                    type: "pie",
                    field: "percentage",
                    categoryField: "source",
                    explodeField: "explode"
                }],
                seriesColors: ["#42a7ff", "#666666", "#999999", "#cccccc"],
                tooltip: {
                    visible: true,
                    template: "${ category } - ${ value }%"
                }
            });
        }

        $(document).ready(createChart);
        $(document).bind("kendo:skinChange", createChart);
    </script>
</div>
).html;
*/