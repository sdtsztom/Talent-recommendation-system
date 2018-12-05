$(function () {
    getmc()
});

function getmc(){
    $.get("/get.requirementinfo",
        function(msg){
            var vm = new Vue({
                el:'#div',
                data:{
                    detail:msg.data
                },
                methods:{
                    goto: function (details) {
                        var path =  "/function/Publish_Details.html?rr_id=" +  details.ri_id
                        window.location.replace(path)
                    }
                }
            })
        });
}