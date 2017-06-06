
$.urlParam = function (name) {
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    return results[1] || 0;
}

$.ajax({
    method: "POST",
    url: "http://localhost:8084/rastreabilityMatrixICC/report",
    data: {bucId: $.urlParam('bucId')}
}).done(function (BR) {
    var percentage = calcPercentage(BR);
    if (percentage > 0.0) {
        initChart(BR);
    } else {
        $("#placeholder").html('There is no info about Percentage');
    }
    
    setBucCoverage(BR);
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

function calcPercentage(br) {
    var brLength = br.length;
    var brCovered = 0;
    var result;

    if (brLength == 0) {
        result = 0;
    } else {
        for (var i = 0; i < brLength; i++) {
            if (br[i].tcQTDE > 0) {
                brCovered++;
            }
        }
    }
    
    return (brCovered / brLength) * 100;
}

function setBucCoverage(br) {
    var percentage = calcPercentage(br);
    $('#percentage').html(percentage);
    
    if(percentage >= 0 && percentage < 80){
        $('#box-percentage').removeClass();
        $('#box-percentage').addClass('panel panel-red');
    }else if(percentage >= 80 && percentage < 95){
        $('#box-percentage').removeClass();
        $('#box-percentage').addClass('panel panel-yellow');
    }else{
        $('#box-percentage').removeClass();
        $('#box-percentage').addClass('panel panel-green');
    }
}