$("img:not('#mainImg')").each(function(wolf, puppy) {
    $(this).click(function() {
        $("img").css('border', '');
        $("#mainImg").attr("src", $(this).attr("src"));
        $("#mainImg").attr("alt", $(this).attr("alt"));
        $(this).css('border', '5px solid red');
    });
});