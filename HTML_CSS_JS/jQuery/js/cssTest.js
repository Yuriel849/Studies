$(document).ready(function() {
/*
    $('div').css('width', '100px')
            .css('height', '100px')
            .css('border', '1px solid silver');
     하나의 ".css()"로 여러 속성을 한번에 적용하기 
    $('div').css({
        'color':'purple'
        ,'backgroundColor':'skyblue'
         JavaScript에서와 똑같이 JS의 backgroundColor 사용!
                CSS의 background-color 사용하면 안된다! 
    });
*/
    $('div').css('backgroundColor', function(index, item) {
/*        console.log(index);
        console.log(item);
        console.log('------')*/
        if(index%2==0) {
            return "blue";
        } else {
            return "yellow";
        }
    });
});