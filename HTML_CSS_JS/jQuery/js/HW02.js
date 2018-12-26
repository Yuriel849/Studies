$(document).ready(function() {
    $('#submit').on('click', function() {
        var d = $("#text").val();
        $('<option>').prop('value', d).prop('class', 'entry').prop('textContent', d).appendTo('#chooser');
        $('#text').val("");
    });
    
    $('#adder').on('click', function() {
        $('#chooser>.entry').filter(":selected").appendTo($("#catcher"));
    });
    
    $('#remover').on('click', function() {
        $('#catcher>.entry').filter(":selected").appendTo($("#chooser"));
    });
    
    $('#chooser').on('dblclick', '.entry', function() {
        $(this).remove();
    });
    
    $('#catcher').on('dblclick', '.entry', function() {
        $(this).remove();
    });
});