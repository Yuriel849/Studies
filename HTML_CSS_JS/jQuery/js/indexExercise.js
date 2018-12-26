$(document).ready(function() {
    $('#setter').on('click', function() {
        var vtxt = $('#txt').val();
        $('#main').append("<li>" + vtxt + "</li>");
        $('#txt').val("");
    });
    $('#finder').on('click', function() {
        var data = $('#main>li');
        if(data.length > 0) {
            data.each(function(dragon, hatchling) {
                var txt = $(this).text();
                var loc = txt.indexOf(" ");
                var content = txt.substr(loc);
                $(this).text(content); 
            });
        }
    });
});