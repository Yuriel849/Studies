$(document).ready(function() {
    $('p').slideUp();
    $('h3').on('click', function() {
        $(this).siblings('p').not($(this).next()).slideUp();
        $(this).next().slideToggle();
    });
});