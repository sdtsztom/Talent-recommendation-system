function getmc(){
    $.get("ajax.get.Republish_Demand",
        function(msg){
            tr.wps = msg.data[0];
            tr.sts = msg.data[1];
            tr.ris = msg.data[2];
            tr.eds = msg.data[3];
            tr.rrss = msg.data[4];
            tr.rrs = msg.data[5];
            datas = msg.data[5];
        });
}

function submit() {
    $.post("ajax.post.Republish_Demand",{
        rr_id:$("#rr_id").val(),rr_wp_id:$("#wp_id").val(),rr_ed_id:$("#ed_id").val(),rr_st_id:$("#st_id").val(),
        rr_ri_id:$("#ri_id").val(),rr_sta_id:$("#rrs_id").val(),
        rr_num:$("#rr_num").val(),rr_el:$("#rr_el").val(),rr_ept:$("#rr_ept").val(),rr_spreq:$("#rr_spreq").val()
    }, function(msg){
        $.get("test",{},function (msg) {});
        alert(msg.msg);
    });
}

$(function() {
    getmc();
    tr = new Vue({
        el: '#div',
        data: {
            wps: [],
            sts: [],
            ris: [],
            eds: [],
            rrss: [],
            rrs: []
        }
    });
});

$(document).ready(function(){
    $("#rr_id").change(function(){
        var get_rr_id = $("#rr_id").val();
        for(var i = 0; i < datas.length; i++) {
            if(datas[i].rr_id === get_rr_id) {
                var rr_id = i;
            }
        }
        $("#rr_num").val(datas[rr_id].rr_num);
        $("#wp_id").val(datas[rr_id].rr_wp_id);
        $("#st_id").val(datas[rr_id].rr_st_id);
        $("#rr_el").val(datas[rr_id].rr_el);
        $("#rr_ept").val(datas[rr_id].rr_ept);
        $("#ri_id").val(datas[rr_id].rr_ri_id);
        $("#ed_id").val(datas[rr_id].rr_ed_id);
        $("#rr_spreq").val(datas[rr_id].rr_spreq);
        $("#rrs_id").val(datas[rr_id].rr_sta_id);
    });
});