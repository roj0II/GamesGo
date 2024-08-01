document.addEventListener('DOMContentLoaded', function() {
    const popupItem = document.querySelector('.popup-item');
    const closeButton = document.querySelector('.popup .close');

    // Function to hide the popup
    function hidePopup() {
        popupItem.classList.remove('show');
    }

    // Hide popup when close button is clicked
    if (closeButton) {
        closeButton.addEventListener('click', hidePopup);
    }
});