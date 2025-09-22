class ModernDropdown {
    constructor(element) {
        this.wrapper = element;
        this.trigger = element.querySelector('.dropdown-trigger');
        this.menu = element.querySelector('.dropdown-menu');
        this.init();
    }

    init() {
        this.trigger.addEventListener('click', (e) => {
            e.preventDefault();
            this.wrapper.classList.toggle('active');
        });

        document.addEventListener('click', (e) => {
            if (!this.wrapper.contains(e.target)) {
                this.wrapper.classList.remove('active');
            }
        });
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const currentPath = window.location.pathname;
    const items = document.querySelectorAll('.dropdown-item');

    items.forEach(item => {
        if(item.getAttribute('data-href') === currentPath){
            item.classList.add('active');
        }
    });

    const dropdowns = document.querySelectorAll('.dropdown-wrapper');
    dropdowns.forEach(dropdown => new ModernDropdown(dropdown));
});