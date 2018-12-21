function check_otherneed(form){
    var prefix="arr_";
    var name_set=new Set();
    for(let ele of form){
        if(ele.name.startsWith(prefix)){
            name_set.add(ele.name);
        }
    }

    //check otherneed
    var ok=true;

    for(let name of name_set){
        if(form[name]['value']==="otherneed"){
            var id=name.substring(prefix.length,name.length);
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
        window.alert("没有填完对应需求号!");
        return false;
    }
}