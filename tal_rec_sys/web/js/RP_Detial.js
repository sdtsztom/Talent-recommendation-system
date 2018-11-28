$(function () {
    getmc();
    tr = new Vue({
        el: '#div',
        data: {
            rps: [],
            degs: [],
            unis: [],
            jobs: []
        }
    })
});

function getmc(){
    $.get("ajax.get.PR_Detail",
        function(msg){
            tr.degs = msg.data[0];
            tr.unis = msg.data[1];
            tr.jobs = msg.data[2];
            tr.rps = msg.data[3]
        });
}