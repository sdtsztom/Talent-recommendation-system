$(function () {
    getmc();
    tr = new Vue({
        el: '#div',
        data: {
            recs: []
        }
    })
});

function getmc(){
    $.get("ajax.get.Stuff_Recommend_Track",
        function(msg){
            tr.recs = msg.data
        });
}