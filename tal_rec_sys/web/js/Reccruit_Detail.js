function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
    if(r!=null)return  unescape(r[2]); return null;
}

function Open2Sift() {
    var rr_id = GetQueryString("rr_id");
    $(location).attr('href', '/complete/5?rr_id='+rr_id);
}



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