$(document).ready(function () {
    draw({
        cont: $('#responseTimeChart'),
        title: 'Response time',
        data: [0, 1,2],
        categories: ['a', 'b','c']
    });
    getDataAndDraw({
        cont: $('#violationsChart'),
        title: 'Violations',
        data: [0, 1,2],
        source: "project/violations",
        categories: ['a', 'b','c']
    });
});


