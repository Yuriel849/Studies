var tagImg = document.getElementsByTagName("img")
for(var i = 1; i < tagImg.length; i++) {
    tagImg[i].onmouseover = function() {
        imgSrc = this.getAttribute("src");
        imgAlt = this.getAttribute("alt");
        tagImg[0].setAttribute("src", imgSrc);
        tagImg[0].setAttribute("alt", imgAlt);
        this.style.border="5px solid red";
        // this.setAttribute은 사용 불가!!!
    }
    tagImg[i].onmouseout = function() {
        this.style.border="";
    }
}