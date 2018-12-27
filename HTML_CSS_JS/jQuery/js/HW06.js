$(document).ready(function() {
    $('.wrap').slideUp();
    $('h3').on('mouseenter', function() {
        $(this).siblings('.wrap').slideUp();
        $(this).next().slideDown();
    }).on('mouseleave', function() {
        $(this).next().slideUp();
    });
});