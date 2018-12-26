$(document).ready(function() {
    $('#btn').on('click', function() {
        var name = document.getElementById("name").value;
        var num = $("#idNo").val();
        
        /* string.substr(start[, length])
            -> start는 시작 위치 (start 위치의 값도 포함)
            -> length는 추출할 문자들 개수 */
        var y = num.substr(0,2); // year of birth
        var m = num.substr(2,2); // month of birth
        var d = num.substr(4,2); // day of birth
        
        /* string.slice(start[, end]) AND string.substring(start[, end])
            -> start는 시작 위치 (start 위치의 값도 포함 inclusive)
            -> end는 끝나는 위치 (end 위치의 값은 불포함 exclusive) */
        var g = num.substring(7,8); // gender
        var gender = "";
        if(g == 1 || g == 3)
            gender = "남";
        else
            gender = "여";
        
        var fully = ""; // 19XX OR 20XX 출생년도 만들기
        if(g == 1 || g == 2)
            fully = "19" + y;
        else
            fully = "20" + y;
        
        var now = new Date(); // 오늘 날짜를 얻기위해 Date 객체 사용
            /* "new Date()" without arguments for the constructor,
               creates a new date object with the current date and time */
        
        $('#result').append("<p>이름 : " + name)
                    .append("<p>주민번호 : " + num)
                    .append("<p>생년월일 : " + fully + "년도" + m + "월" + d + "일")
                    .append("<p>성별 : " + gender)
                    .append("<p>나이 : " + (now.getFullYear() - fully));
    });
});