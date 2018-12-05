$(function () {
    gettype()
    getmc()
});

function getmc(){
    $.get("/get.requirementinfo",
        function(msg){
            var vm = new Vue({
                el:'#div',
                data:{
                    detail:msg.data
                },
                methods:{
                    goto: function (details) {
                        var path =  "/function/Publish_Details.html?rr_id=" +  details.ri_id
                        window.location.replace(path)
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
            }else if( msg !== "人事人员") {
                alert("您没有权限");
                history.go(-1)
            }
        });
}