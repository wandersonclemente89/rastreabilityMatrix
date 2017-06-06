
$.urlParam = function (name) {
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    return results[1] || 0;
}

$.ajax({
    method: "POST",
    url: "http://localhost:8084/rastreabilityMatrixICC/report",
    data: {bucId: $.urlParam('bucId')}
}).done(function (BR) {
    initChart(BR);
});

function initChart(br) {
//Flot Pie Chart
    $(function () {

        /*
         * [{
                label: "Series 0",
                data: 1
           }]
         */
        var data = parseData(br);


        var plotObj = $.plot($("#placeholder"), data, {
            series: {
                pie: {
                    show: true
                }
            },
            grid: {
                hoverable: true
            },
            tooltip: true,
            tooltipOpts: {
                content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
                shifts: {
                    x: 20,
                    y: 0
                },
                defaultTheme: false
            }
        });

    });
}

function parseData(br) {
    var result = [];

    for (var i = 0; i < br.length; i++) {
        result.push({label: br[i].name, data: br[i].tcQTDE});
    }
    return result;
}