$(function () {
    getmc()
});

function getmc(){
    var sort = window.location.href

    var data = sort.split("?")
    $.get("/get.hrs?" + data[1],
        function(msg){
            var vm = new Vue({
                el:'#div',
                data:{
                    detail:msg.data
                },
                methods:{
                    goto:function (details) {
                        var path = "/function/Recruit_Detail.html?rr_id=" + details.rr_id
                        window.location.href = path
                    },
                    goto2:function (details) {
                        href="<%=SRM_Page.convert(stage)%>?rrid=<%=recruit.getRr_id() %>"
                        var path
                        switch (parseInt(details.rr_sta_id)) {
                            case 1: alert("错误！ 已关闭"); return;
                            case 2: path = "/SRMPages/Single_Rec_vOpen.jsp?rr_id=" + details.rr_id; break;
                            case 4: path = "/SRMPages/Single_Rec_vSift.jsp?rr_id=" + details.rr_id; break;
                            case 5: path = "/SRMPages/Single_Rec_vSift_Arr.jsp?rr_id=" + details.rr_id; break;
                            case 6: path = "/SRMPages/Single_Rec_vIntv1.jsp?rr_id=" + details.rr_id; break;
                            case 7: path = "/SRMPages/Single_Rec_vIntv1_Arr.jsp?rr_id=" + details.rr_id;break;
                            case 8: path = "/SRMPages/Single_Rec_vIntv2.jsp?rr_id=" + details.rr_id;break;
                            case 9: path = "/SRMPages/Single_Rec_vOC.jsp?rr_id=" + details.rr_id;break;
                            case 10: path = "/SRMPages/Single_Rec_vTW.jsp?rr_id=" + details.rr_id;break;
                        }
                        window.location.href = path
                    }
                }
            })
        })


}