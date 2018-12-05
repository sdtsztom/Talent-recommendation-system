$(function () {
    getmc()
});

function getmc(){
    var sort = window.location.href
    var data = sort.split("?")
    $.get("/get.simple?" + data[1],
        function(msg){
            var vm = new Vue({
                el:'#div',
                data:{
                    detail:msg.data
                },
                methods:{
                    goto: function (details) {
                        var path =  "/function/Recruit_Detail.html?rr_id=" +  details.rr_id
                        window.location.href = path
                    }
                }
            })
        });
}