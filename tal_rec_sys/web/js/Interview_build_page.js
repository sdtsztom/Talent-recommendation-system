$(function () {
    getmc();
    tr = new Vue({
        el: '#div',
        data: {
            ips: [],
            rps: [],
            sts: [],
            rrs: []
        }
    })
});

function getmc(){
    $.get("ajax.get.Interview_Build_Page",
        function(msg){
            tr.ips = msg.data[0];
            tr.rps = msg.data[1];
            tr.sts = msg.data[2];
            tr.rrs = msg.data[3]
        });
}

function submit() {
    $.post("ajax.post.Interview_Build_Page",{
        ip_id:$("#ip_id").val(),rp_id:$("#rp_id").val(),dealHR_id:$("#dealHR_id").val(),
        rr_id:$("#rr_id").val(),itv_time:$("#itv_time").val(),exmer_id:$("#exmer_id").val(),
        itv_detail:$("#itv_detail").val(),ip_rnd:$("#ip_rnd").val()
    }, function(msg){
        alert(msg.msg);
    });
}