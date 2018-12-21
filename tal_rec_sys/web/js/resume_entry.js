$(function () {
    getmc();
    tr = new Vue({
        el: '#div',
        data: {
            degs: [],
            unis: [],
            jobs: []
        }
    })
});

function getmc(){
    $.get("ajax.get.resume_entry",
        function(msg){
            tr.degs = msg.data[0];
            tr.unis = msg.data[1];
            tr.jobs = msg.data[2]
        });
}

function submit() {
    $.post("ajax.post.resume_entry",{
        name:$("#name").val(),age:$("#age").val(),tal:$("#tel").val(),
        email:$("#email").val(),grt:$("#grt").val(),major:$("#major").val(),
        abi:$("#abi").val(),path:$("#path").val(),sex:$("#sex").val(),stu:$("#stu").val(),
        deg_id:$("#deg_id").val(),uni_id:$("#uni_id").val(),jb_id:$("#jb_id").val()
    }, function(msg){
        $.get("test",{},function (msg) {});
        alert(msg.msg);
    });
}