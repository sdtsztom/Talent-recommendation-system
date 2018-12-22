//控制需求号input的显示与消失
$(document).ready(function () {
    $(':radio').click(function () { //更严格的可以使用$(":radio[name^='arr_")
        var id=getId($(this).attr('name'));
        var corr_otherneed_name='id_otherNeed_'+id;
        if($(this).attr('value')==='otherneed'){
            $("[name='"+corr_otherneed_name+"']").show();
        }else{
            $("[name='"+corr_otherneed_name+"']").hide();
        }
    });
});

function check_otherneed(form){
    //var prefix="arr_";
    var name_set=new Set();
/*    for(let ele of form){
        if(ele.name.startsWith(prefix)){
            name_set.add(ele.name);
        }
    }*/

    for(let ele of $(':radio')){    //更严格的可以使用$(":radio[name^='arr_")
        name_set.add(ele.name);
    }

    //check otherneed
    var ok=true;

    for(let name of name_set){
        if(form[name]['value']==="otherneed"){
            var id=getId(name);
            var corr_otherneed_name='id_otherNeed_'+id;
            var otherneed_id=form[corr_otherneed_name].value;
            if(isNaN(parseInt(otherneed_id))){
                ok=false;
                break;
            }
        }
    }

    if(ok) {
        return true;
    }else{
        window.alert("没有填完/填对需求号!");
        return false;
    }
}

function getId(name){
    var prefix="arr_";
    return name.substring(prefix.length,name.length);
}