function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

$(function () {
    var rr_id = getQueryString("rr_id");
    getmc();
    tr = new Vue({
        el: '#div',
        data: {
            rrid: rr_id,
            rrs: [],
            rps: [],
            recfs: [],
            check: []
        }
    });
});


function getmc(){
    $.get("ajax.get.Stuff_Recommend_Page",
        function(msg){
            tr.rrs = msg.data[0];
            tr.rps = msg.data[1];
            tr.recfs = msg.data[2];
            tr.check = eval(msg.msg)
        });
}

function submit() {
    var rr_id = getQueryString("rr_id");//$("#rr_id").val();
    var rp_id = $("#rp_id").val();
    var recf_id = $("#recf_id").val();
    $.post("ajax.post.Stuff_Recommend_Page",{
        rr_id:rr_id,rp_id:rp_id,recf_id:recf_id
    }, function(msg){
        alert(msg.msg);
    });
}