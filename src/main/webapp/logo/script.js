// scripts.js
document.addEventListener('DOMContentLoaded', () => {
    const logo = document.querySelector('.logo');
    const leftG = document.querySelector('.left-g');
    const rightG = document.querySelector('.right-g');

    logo.addEventListener('click', () => {
        logo.classList.toggle('open');
    });
});
