$(function () {
    getmc()
});

function getmc(){
    var sort = window.location.href
    var data = sort.split("?")
    $.get("/get.detail?" + data[1],
        function(msg){
            var vm = new Vue({
                el:'#div',
                data:{
                    detail:msg.data[0]
                },
                methods:{
                }
            })
        });
}