const chatBody  = document.getElementById("chatBody");
const infoBox   = document.getElementById("info");
const reserveBtn = document.getElementById("reserveBtn");

function addUserMessage(text) {
    if (!text || !text.trim()) return;
    const msg = document.createElement("div");
    msg.className = "user-msg";
    msg.textContent = text;
    chatBody.appendChild(msg);
    chatBody.scrollTop = chatBody.scrollHeight;
}
function addBotMessage(html) {
    const msg = document.createElement("div");
    msg.className = "bot-msg";
    msg.innerHTML = html;
    chatBody.appendChild(msg);
    chatBody.scrollTop = chatBody.scrollHeight;
}

// 지도
const map = new kakao.maps.Map(document.getElementById('map'), {
    center: new kakao.maps.LatLng(37.5630542, 127.1928256),
    level: 3
});

const imageSrc = "https://cdn-icons-png.flaticon.com/512/5002/5002382.png";
const imageSize = new kakao.maps.Size(80, 90);
const markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

let lastSelected = null;

// 마커 로드
fetch('/kakao/markers')
    .then(res => {
        if (!res.ok) throw new Error('HTTP ' + res.status);
        return res.json();
    })
    .then(list => {
        if (!Array.isArray(list) || list.length === 0) {
            addBotMessage('표시할 자전거가 없습니다.');
            return;
        }
        const bounds = new kakao.maps.LatLngBounds();

        list.forEach(pos => {
            if (typeof pos.lat !== 'number' || typeof pos.lng !== 'number') return;

            const latlng = new kakao.maps.LatLng(pos.lat, pos.lng);
            bounds.extend(latlng);

            const marker = new kakao.maps.Marker({
                map,
                position: latlng,
                title: pos.merchantNum || pos.bikeNo,
                image: markerImage
            });

            kakao.maps.event.addListener(marker, 'click', () => {
                lastSelected = {
                    bikeNo:      pos.bikeNo,
                    merchantNum: pos.merchantNum,
                    title:       pos.merchantNum || pos.bikeNo,
                    lat:         pos.lat,
                    lng:         pos.lng,
                    priority:    pos.priority
                };

                infoBox.style.display = "block";
                infoBox.innerHTML = `
          🚲 <b>${lastSelected.bikeNo}</b><br>
          가맹점번호: ${lastSelected.merchantNum}<br>
          위도: ${Number(lastSelected.lat).toFixed(6)}<br>
          경도: ${Number(lastSelected.lng).toFixed(6)}<br>
          우선순위: ${lastSelected.priority}
        `;

                reserveBtn.disabled = false;
                chatBody.scrollTop = chatBody.scrollHeight;
            });
        });

        if (!bounds.isEmpty()) {
            map.setBounds(bounds, 30, 30, 30, 30);
        }
    })
    .catch(err => {
        console.error('마커 로드 실패:', err);
        addBotMessage('마커 로드에 실패했습니다. 잠시 후 다시 시도해 주세요.');
    });

// 예약 → 서버 INSERT
reserveBtn.addEventListener("click", async () => {
    if (!lastSelected) return;

    reserveBtn.disabled = true;
    addBotMessage("📡 예약 요청을 보내는 중…");

    // 데모 값 (추후 로그인/입력으로 교체)
    const payload = {
        memberNum: "U000000001",
        phoneNum:  "01011112222",
        categoryCd: "B01",
        merchantNum: lastSelected.merchantNum,
        reservationStatus: "Y"
    };

    try {
        const res = await fetch("/kakao/reservations", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(payload)
        });
        if (!res.ok) throw new Error("HTTP " + res.status);
        const result = await res.json();

        addBotMessage(`<b>✅ 예약완료!</b>`);
        addBotMessage(`
      🚲 <b>${lastSelected.bikeNo}</b><br>
      가맹점번호: ${lastSelected.merchantNum}<br>
      위도: ${Number(lastSelected.lat).toFixed(6)}<br>
      경도: ${Number(lastSelected.lng).toFixed(6)}
    `);
    } catch (e) {
        console.error(e);
        addBotMessage("❌ 예약 저장에 실패했습니다. 잠시 후 다시 시도해 주세요.");
        reserveBtn.disabled = false;
    }
});

// 입력창 데모
const inputEl = document.querySelector(".input-shell input");
const sendBtn  = document.querySelector(".icon-btn.send");
const micBtn   = document.querySelector(".icon-btn.mic");

const send = () => {
    addUserMessage(inputEl.value);
    inputEl.value = "";
    inputEl.focus();
};
sendBtn.addEventListener("click", send);
inputEl.addEventListener("keydown", e => { if (e.key === "Enter") send(); });
micBtn.addEventListener("click", () => console.log("🎤 Mic clicked"));
