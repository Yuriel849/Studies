$(document).ready(function() {
    var eleWidth = $('.vis_frame ul li').innerWidth();
    var direction = "left";
    
    function left() {
        direction="left"; /* 방향성을 나타내기 위한 것, 지금 상황에서는 필요없다. */
        $('.vis_frame>ul').animate({left:eleWidth*-1}, 300, 'swing', function() {
            $(this).children('li:first').insertAfter($(this).children('li:last'));
            $(this).css({left:0});
                /* ...animate({left:eleWidth*-1}...)로 변한 left의 값을 초기화한다. */
        });
    }
    
    function right(){
		direction = "right";
		$(".vis_frame > ul > li:last").insertBefore($(".vis_frame > ul > li:first"));
		$(".vis_frame > ul").css({left:eleWidth*-1});
		$(".vis_frame > ul").animate({left:0},300,"swing",function(){
		});
	}	
    
    $('.left').on('click', function() {
        left();
    });
    
    $('.right').click(function(){
        right();
    }); 
});
