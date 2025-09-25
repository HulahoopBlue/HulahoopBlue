// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

function number_format(number, decimals, dec_point, thousands_sep) {
  // *     example: number_format(1234.56, 2, ',', ' ');
  // *     return: '1 234,56'
  number = (number + '').replace(',', '').replace(' ', '');
  var n = !isFinite(+number) ? 0 : +number,
    prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
    sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
    dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
    s = '',
    toFixedFix = function(n, prec) {
      var k = Math.pow(10, prec);
      return '' + Math.round(n * k) / k;
    };
  // Fix for IE parseFloat(0.55).toFixed(0) = 0;
  s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
  if (s[0].length > 3) {
    s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
  }
  if ((s[1] || '').length < prec) {
    s[1] = s[1] || '';
    s[1] += new Array(prec - s[1].length + 1).join('0');
  }
  return s.join(dec);
}

const totalMembers = parseInt(document.querySelector("#totalMembersCard").innerText.replace(/,/g, ""));
const totalMerchants = parseInt(document.querySelector("#totalMerchantsCard").innerText.replace(/,/g, ""));
const externalApiCallCount = parseInt(document.querySelector("#externalApiCallCard").innerText.replace(/,/g, ""));
const gatewayProcessCount = parseInt(document.querySelector("#gatewayProcessCard").innerText.replace(/,/g, ""));

// 단위 맞추기 (회원수 → 천 단위, 가맹점수 → 천 단위, API → 만 단위, H/G → 십만 단위)
const memberValue = Math.round(totalMembers / 1000);
const merchantValue = Math.round(totalMerchants / 1000);
const apiValue = Math.round(externalApiCallCount / 10000);
const gatewayValue = Math.round(gatewayProcessCount / 100000);

// Area Chart Example
var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월"],
    datasets: [{
      label: "회원수(단위:천)",
      lineTension: 0.3,
      backgroundColor: "rgba(78, 115, 223, 0.05)",
      borderColor: "rgba(78, 115, 223, 1)",
      pointRadius: 3,
      pointBackgroundColor: "rgba(78, 115, 223, 1)",
      pointBorderColor: "rgba(78, 115, 223, 1)",
      pointHoverRadius: 3,
      pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
      pointHoverBorderColor: "rgba(78, 115, 223, 1)",
      pointHitRadius: 10,
      pointBorderWidth: 2,
      data: [32, 25, 48, 35, 30, 40, 55, 65, memberValue],
    },
      {
        label: "가맹점수(단위:천)",
        lineTension: 0.3,
        backgroundColor: "rgba(28, 200, 138, 0.05)",
        borderColor: "rgba(28, 200, 138, 1)",
        pointBackgroundColor: "rgba(28, 200, 138, 1)",
        pointBorderColor: "rgba(28, 200, 138, 1)",
        data: [22, 22, 21, 31, 28, 37, 59, 63, merchantValue],
      },
      {
        label: "외부 api 요청 건수(단위:만)",
        lineTension: 0.3,
        backgroundColor: "rgba(54, 185, 204, 0.05)",
        borderColor: "rgba(54, 185, 204, 1)",
        pointBackgroundColor: "rgba(54, 185, 204, 1)",
        pointBorderColor: "rgba(54, 185, 204, 1)",
        data: [60, 56, 68, 70, 69, 72, 65, 85, apiValue],
      },
      {
        label: "H/G 처리건수(단위:십만)",
        lineTension: 0.3,
        backgroundColor: "rgba(246, 194, 62, 0.05)",
        borderColor: "rgba(246, 194, 62, 1)",
        pointBackgroundColor: "rgba(246, 194, 62, 1)",
        pointBorderColor: "rgba(246, 194, 62, 1)",
        data: [20, 26, 24, 26, 30, 28, 33, 32, gatewayValue],
      }
      ],
  },
  options: {
    maintainAspectRatio: false,
    layout: {
      padding: {
        left: 10,
        right: 25,
        top: 25,
        bottom: 0
      }
    },
    scales: {
      xAxes: [{
        time: {
          unit: 'date'
        },
        gridLines: {
          display: false,
          drawBorder: false
        },
        ticks: {
          maxTicksLimit: 7
        }
      }],
      yAxes: [{
        ticks: {
          maxTicksLimit: 5,
          padding: 10,
          // Include a dollar sign in the ticks
          callback: function(value, index, values) {
            return number_format(value);
          }
        },
        gridLines: {
          color: "rgb(234, 236, 244)",
          zeroLineColor: "rgb(234, 236, 244)",
          drawBorder: false,
          borderDash: [2],
          zeroLineBorderDash: [2]
        }
      }],
    },
    legend: {
      display: true,
      position: 'bottom'
    },
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      titleMarginBottom: 10,
      titleFontColor: '#6e707e',
      titleFontSize: 14,
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      intersect: false,
      mode: 'index',
      caretPadding: 10,
      callbacks: {
        label: function(tooltipItem, chart) {
          var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
          return datasetLabel + ':' + number_format(tooltipItem.yLabel);
        }
      }
    }
  }
});
