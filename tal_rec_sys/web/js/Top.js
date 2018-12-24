$(function(){
    $.get("/get_log_message",
        function(msg){
            var vm = new Vue({
                el:'#div',
                data:{
                    detail:msg.data
                }
            })
        });
})

function out() {
    $.get("/login_out",function (msg) {
        if(msg === "true"){
            top.location.href='/Login/login.html'
        }
    })
}