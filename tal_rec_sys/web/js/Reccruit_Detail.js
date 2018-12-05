$(function () {
    gettype()
    getmc()
});

function getmc(){
    var sort = window.location.href
    var data = sort.split("?")
    $.get("/get.detail?" + data[1],
        function(msg){
            var vm = new Vue({
                el:'#div',
                data:{
                    detail:msg.data[0]
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
            }else{
                var vm2 = new Vue({
                    el:'#jobswitch',
                    data: {
                        job_type:msg
                    }
                })
                if(msg === "开发人员"){
                    vm2.job_type = 1
                }else if(msg === "人事人员"){
                    vm2.job_type = 2
                }else if(msg === "管理人员"){
                    vm2.job_type = 3
                }
            }
        });
}