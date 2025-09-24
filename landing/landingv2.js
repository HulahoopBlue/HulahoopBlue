document.addEventListener('DOMContentLoaded', () => {
    const dropdownTrigger = document.querySelector('.dropdown-trigger');
    const dropdownWrapper = document.querySelector('.dropdown-wrapper');
    const dropdownItems = document.querySelectorAll('.dropdown-item');
    const sections = document.querySelectorAll('.section');

    // 플로팅 메뉴 토글
    dropdownTrigger.addEventListener('click', () => {
        dropdownWrapper.classList.toggle('active');
    });

    // 섹션 스크롤
    dropdownItems.forEach(item => {
        item.addEventListener('click', (e) => {
            const targetId = e.target.dataset.target;
            const targetSection = document.getElementById(targetId);
            if (targetSection) {
                window.scrollTo({
                    top: targetSection.offsetTop,
                    behavior: 'smooth'
                });
                dropdownWrapper.classList.remove('active');
            }
        });
    });

    // 스크롤 시 섹션 활성화
    const checkSectionVisibility = () => {
        const triggerBottom = window.innerHeight / 5 * 4;

        sections.forEach(section => {
            const sectionTop = section.getBoundingClientRect().top;
            
            if (sectionTop < triggerBottom) {
                section.classList.add('show');
            } else {
                section.classList.remove('show');
            }
        });

        let currentActiveSectionId = '';
        for (let i = sections.length - 1; i >= 0; i--) {
            const section = sections[i];
            const sectionRect = section.getBoundingClientRect();
            if (sectionRect.top <= window.innerHeight / 2 && sectionRect.bottom >= window.innerHeight / 2) {
                currentActiveSectionId = section.id;
                break;
            }
        }

        dropdownItems.forEach(item => {
            if (item.dataset.target === currentActiveSectionId) {
                item.classList.add('active');
            } else {
                item.classList.remove('active');
            }
        });
    };

    window.addEventListener('scroll', checkSectionVisibility);
    checkSectionVisibility();
      // 팀원 카드 클릭 시 상세 설명 표시
  const members=document.querySelectorAll('.member');
  const detailBox=document.getElementById('member-detail');

  members.forEach(member=>{
    member.addEventListener('click', ()=>{
      members.forEach(m=>m.classList.remove('active'));
      member.classList.add('active');
      detailBox.textContent = member.getAttribute('data-detail');
      detailBox.classList.remove('show');
      void detailBox.offsetWidth; // reflow
      detailBox.classList.add('show');
    });
  });
});