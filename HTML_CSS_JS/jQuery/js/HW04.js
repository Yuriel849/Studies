$(document).ready(function() {
    var n1 = 2;
    var n2 = 3;
    $('div').slice(n1,n2).css('backgroundColor', 'aqua');
    
    $("#left").on('click', function() {
        $('div').slice(n1,n2).css('backgroundColor', 'transparent');
        $('div').slice(--n1,--n2).css('backgroundColor', 'aqua');

//        n1--;
//        n2--;
//        if(n1 == 0) {
//            n1 = 4;
//            n2 = 0;
//        } else if(n2 == 0) {
//            n2 = 4;
//        }
    });
    
    $("#right").on('click', function() {
        $('div').slice(n1,n2).css('backgroundColor', 'transparent');
        $('div').slice(++n1,++n2).css('backgroundColor', 'aqua');
    });
});
