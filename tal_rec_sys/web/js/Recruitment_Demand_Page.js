$(function () {
    getmc();
    tr = new Vue({
        el: '#div',
        data: {
            rrs: []
        }
    })
});

function getmc(){
    $.get("ajax.get.Recruitment_Demand_Page",
        function(msg){
            tr.rrs = msg.data
        });
}