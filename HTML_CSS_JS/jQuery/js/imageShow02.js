$(document).ready(function() {
    $('img').on('click', function() {
        /*
            $('li') -> 이미 존재하는 li를 찾는다!
            $('<li>') -> 새로운 li를 만든다!
        */
        $('<li>').append($(this).clone()).appendTo('#result');
            /* 새로운 li 태그를 만들고, 그 태그에 $(this).clone을 추가하고, 그 태그를 #result에 추가한다. */
    });
    
    /* .on(events[, selector][, data][, handler])
            only events is required, all others are optional.
            HERE, "dblclick" is events, "li" is selector, "function() {}" is handler
                the event is attached not to the selected element ("#result") but to the present AND future descendants (자손) of the selected element (which is "li" (i.e. li tags) here) */
    $('#result').on('dblclick', 'li', function() {
        $(this).remove();
    });
});