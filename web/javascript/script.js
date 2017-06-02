$(document).ready(function () {
    $('#brTable').DataTable();
    $('#trTable').DataTable();
    $('#tcTable').DataTable();
});


// Any of the following formats may be used
var ctx = document.getElementById("myChart");
var ctx = document.getElementById("myChart").getContext("2d");
var ctx = $("#myChart");
var ctx = "myChart";

var dynamicColors = function () {
    var r = Math.floor(Math.random() * 255);
    var g = Math.floor(Math.random() * 255);
    var b = Math.floor(Math.random() * 255);
    return "rgb(" + r + "," + g + "," + b + ")";
}

var ctx = document.getElementById("myChart");
var bgColors = ['rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)'];

$.urlParam = function (name) {
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    return results[1] || 0;
}
var br;
$.ajax({
    method: "POST",
    url: "http://localhost:8084/rastreabilityMatrixICC/report",
    data: {bucId: $.urlParam('bucId')}
}).done(function (BR) {
    br = BR;

    var myChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: label(),
            datasets: [{
                    data: data(),
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)'
                    ],
                    borderWidth: 1
                }],

        }
    });
});

function label() {
    var result = [];

    for (var i = 0; i < br.length; i++) {
        result.push(br[i].name);
    }
    return result;
}

function data() {
    var result = [];

    for (var i = 0; i < br.length; i++) {
        result.push(br[i].tcQTDE);
    }
    return result;
}

