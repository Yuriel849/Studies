$(document).ready(function(){
    var gnbA = $("#gnb>li>a");
	var h = new Array();
	var sum = 0;
	$("#content > div").each(function(index){
		h[index] = sum;
        sum += $(this).innerHeight();
	});
	$(window).scroll(function(){
		$("#content > div").each(function(index){
			if($(window).scrollTop() >= h[index]){
				gnbA.removeClass("on");
				gnbA.eq(index).addClass("on");
			}
		});
	});
	gnbA.click(function(){
		var target = $(this).attr("href");
/*      console.log($(target).offset().top);
        console.log($("#content").offset().top);
        console.log($(target).offset().top - $("#content").offset().top); */
		$("html,body").stop().animate({scrollTop:$(target).offset().top-$("#content").offset().top},1500);
		if(gnbA.target){
			$(gnbA.target).removeClass("on");
			$(this).addClass("on");
		}else{
			$(this).addClass("on");
		}
		gnbA.target = this;
		return false;          
	   });
	gnbA[0].click();
});      

     