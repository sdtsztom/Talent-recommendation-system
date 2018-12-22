$(function () {
    $("#ip_id").val("0");
    $("#itv_res").hide();
    $("#forhide").hide();
    getmc();
    tr = new Vue({
        el: '#div',
        data: {
            ips: [],
            rps: [],
            sts: [],
            rrs: [],
            ress: [],
            datas: []
        }
    })
});

function getmc(){
    $.get("ajax.get.Interview_Build_Page",
        function(msg){
            tr.ips = msg.data[0];
            tr.rps = msg.data[1];
            tr.sts = msg.data[2];
            tr.rrs = msg.data[3];
            tr.ress = msg.data[4];
            tr.datas = msg.data[5];
            datas = msg.data[5]
        });
}

function submit() {
    var get_itv_id = $("#itv_id").val();
    if(get_itv_id === '0') {
        $.post("ajax.post.Interview_Build_Page",{
            ip_id:$("#ip_id").val(),rp_id:$("#rp_id").val(),dealHR_id:$("#dealHR_id").val(),
            rr_id:$("#rr_id").val(),itv_time:$("#itv_time").val(),exmer_id:$("#exmer_id").val(),
            itv_detail:$("#itv_detail").val()
        }, function(msg){
            $.get("/complete/8?rr_id="+$("#ip_id").val(),{},function (msg) {});
            alert(msg.msg);
        });
    } else {
        $.post("ajax.post.Interview_Build_Page2",{
            ip_id:$("#ip_id").val(),rp_id:$("#rp_id").val(),dealHR_id:$("#dealHR_id").val(),
            rr_id:$("#rr_id").val(),itv_time:$("#itv_time").val(),exmer_id:$("#exmer_id").val(),
            itv_detail:$("#itv_detail").val(),ip_rnd:$("#ip_rnd").val(),itv_res:$("#itv_res").val(),
            itv_id:$("#itv_id").val()
        }, function(msg){
            $.get("/complete/10?rr_id="+$("#ip_id").val(),{},function (msg) {});
            alert(msg.msg);
        });
    }
}


$(document).ready(function(){
    $("#itv_id").change(function(){
        var get_itv_id = $("#itv_id").val();
        for(var i = 0; i < datas.length; i++) {
            if (datas[i].itv_id === get_itv_id) {
                var itv_id = i;
            }
        }
        if(get_itv_id === '0') {
            $("#itv_res").hide();
            $("#forhide").hide();
        } else {
            $("#ip_rnd").val(datas[itv_id].itv_rnd);
            $("#ip_id").val(datas[itv_id].itv_pl_id);
            $("#rp_id").val(datas[itv_id].itv_rp_id);
            $("#dealHR_id").val(datas[itv_id].itv_dealHR_id);
            $("#rr_id").val(datas[itv_id].itv_rr_id);
            $("#itv_time").val(datas[itv_id].itv_time);
            $("#exmer_id").val(datas[itv_id].itv_exmer_id);
            $("#itv_detail").val(datas[itv_id].itv_detals);
            $("#itv_res").val(datas[itv_id].itv_res_id);
            $("#itv_res").show();
            $("#forhide").show();
        }
    });
});