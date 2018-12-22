$(function () {
    gettype();
    getmc();
});

function getmc(){
    var sort = window.location.href;
    var data = sort.split("?");
    $.get("/get.detail?" + data[1],
        function(msg){
            var vm = new Vue({
                el:'#div',
                data:{
                    detail:msg.data[0]
                },
                methods:{
                    goto3:function (detail_single) {
                        var sort = window.location.href;
                        var data = sort.split("=");
                        var path;
                        switch (parseInt(detail_single.rr_sta_id)) {
                            case 1: alert("错误！ 已关闭"); return;
                            case 2: path = "/SRMPages/Single_Rec_vOpen.jsp?rrid=" + data[1]; break;
                            case 4: path = "/SRMPages/Single_Rec_vSift.jsp?rrid=" + data[1]; break;
                            case 5: path = "/SRMPages/Single_Rec_vSift_Arr.jsp?rrid=" + data[1]; break;
                            case 6: path = "/SRMPages/Single_Rec_vIntv1.jsp?rrid=" + data[1]; break;
                            case 7: path = "/SRMPages/Single_Rec_vIntv2.jsp?rrid=" + data[1];break;
                            case 8: path = "/SRMPages/Single_Rec_vOfferConfirm.jsp?rrid=" + data[1];break;
                            //case 9: path = "/SRMPages/Single_Rec_vTW.jsp?rrid=" + details.rr_id;break;
                        }
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
            }else{
                var job_type_temp=-1;
                if(msg === "开发人员"){
                    job_type_temp = 1
                }else if(msg === "人事人员"){
                    job_type_temp = 2
                }else if(msg === "管理人员"){
                    job_type_temp = 3
                }

                var vm2 = new Vue({
                    el:'#jobswitch',
                    data: {
                        job_type:job_type_temp
                    }
                })

                //补回被覆盖的@click
                //实现方式并不优雅，待以后修改
                var bt=null;
                switch (vm2.job_type) {
                    case 1:bt=document.getElementById('button1');break;
                    case 2:
                    case 3:bt=document.getElementById('button23');break;
                }
                bt.setAttribute('v-on:click','goto3(detail)')
            }
        });
}