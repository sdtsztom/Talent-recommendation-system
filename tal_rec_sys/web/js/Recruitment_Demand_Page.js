$(function () {
    getmc();
    tr = new Vue({
        el: '#div',
        data: {
            rrs: []
        },
        methods: {
            goto: function (rr) {
                var path = "/Stuff_Recommend_Page?rr_id=" + rr.rr_id;
                window.location.href = path;
            }
        }
    })
});

function getmc(){
    $.get("ajax.get.Recruitment_Demand_Page",
        function(msg){
            tr.rrs = msg.data

        });
}