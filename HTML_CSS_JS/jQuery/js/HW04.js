$(document).ready(function() {
    var n = 2;
    $('div').eq(n).css('backgroundColor', 'aqua');
    
    $("#left").on('click', function() {
        $('div').eq(n%5).css('backgroundColor', 'transparent');
        $('div').eq(--n%5).css('backgroundColor', 'aqua');
    });
    
    $("#right").on('click', function() {
        $('div').eq(n%5).css('backgroundColor', 'transparent');
        $('div').eq(++n%5).css('backgroundColor', 'aqua');
    });
});
