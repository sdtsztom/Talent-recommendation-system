$(function () {
    gettype()
    getmc()
});

function getmc(){
    $.get("/get.requirementdetail",
        function(msg){
            var vm = new Vue({
                el:'#div',
                data:{
                    wpn:msg.data[0],
                    stn:msg.data[1],
                    emn:msg.data[2]
                }
            })
        });
}

function gettype() {
    $.get("/login_type",
        function(msg){
            if( msg === ""){
                alert("请先登录")
                top.location.href = '/Login/login.html';
            }else if( msg !== "人事人员") {
                alert("您没有权限");
                history.go(-1)
            }
        });
}

function checkForm(){
    var path = window.location.href
    var data = path.split("=")
    $.session.set("rr_id",data[1])
    var str= $('#summernote').summernote('code');
    document.getElementById("rr_spreq").value=str;
    document.getElementById("publish").submit();
}