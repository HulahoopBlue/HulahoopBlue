// 공통 포맷 함수
function number_format(number, decimals, dec_point, thousands_sep) {
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

// ===========================
// 📊 일별 거래금액 차트
// ===========================
async function loadDailyChart() {
  try {
    const res = await fetch("/api/dashboard/brokerageDaily");
    const data = await res.json();

    // DB에서 넘어온 값 -> {period: "2025-09-21", total: 12345}
    const labels = data.map(d => d.period.substring(8, 10) + "일");
    const totals = data.map(d => d.total);

    var ctx = document.getElementById("myBarChart");
    new Chart(ctx, {
      type: 'bar',
      data: {
        labels: labels,  // → ["22일","22일","23일","24일","26일"]
        datasets: [{
          label: "금일 거래금액",
          backgroundColor: "#316bff",
          hoverBackgroundColor: "#0b0561",
          borderColor: "#2a01ac",
          data: totals,   // → [DB 합산 값]
        }],
      },
      options: {
        maintainAspectRatio: false,
        layout: {
          padding: { left: 10, right: 25, top: 25, bottom: 0 }
        },
        scales: {
          xAxes: [{
            gridLines: { display: false, drawBorder: false },
            ticks: { maxTicksLimit: 6 },
            maxBarThickness: 25,
          }],
          yAxes: [{
            ticks: {
              min: 0,
              maxTicksLimit: 5,
              padding: 10,
              callback: function(value) {
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
        legend: { display: false },
        tooltips: {
          titleMarginBottom: 10,
          titleFontColor: '#6e707e',
          titleFontSize: 14,
          backgroundColor: "rgb(255,255,255)",
          bodyFontColor: "#858796",
          borderColor: '#dddfeb',
          borderWidth: 1,
          xPadding: 15,
          yPadding: 15,
          displayColors: false,
          caretPadding: 10,
          callbacks: {
            label: function(tooltipItem, chart) {
              var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
              return datasetLabel + ':' + number_format(tooltipItem.yLabel);
            }
          }
        },
      }
    });
  } catch (err) {
    console.error("일별 차트 로드 실패:", err);
  }
}

// 페이지 로드 시 실행
window.addEventListener("DOMContentLoaded", loadDailyChart);
