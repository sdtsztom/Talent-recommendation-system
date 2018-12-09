$(function () {
    gettype()
    getmc()
});

function getmc(){
    var sort = window.location.href
    var data = sort.split("?")
    $.get("/get.simple?" + data[1],
        function(msg){
            var vm = new Vue({
                el:'#div',
                data:{
                    detail:msg.data
                },
                methods:{
                    goto: function (details) {
                        var path =  "/function/Recruit_Detail.html?rr_id=" +  details.rr_id
                        window.location.href = path
                    }
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
            }
        });
}