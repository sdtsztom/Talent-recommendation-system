package example;

import bean.Arrangement;
import ienum.Arr_result;
import util.JsonUtils;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

public class Json_lib_compare {
    public static void main(String []argv){
        System.out.println("*******************************truth:*********************************");
        Arrangement a=new Arrangement(0,Arr_result.PASS);
        System.out.println(a.getResult());

/*        System.out.println("***********************************net.jt.json***************************");
        String str=JsonUtils.toJSONString(a);
        System.out.println(str);
        Arrangement b=JsonUtils.<Arrangement>Str2Obj(str,Arrangement.class);
        System.out.println(b.getResult());    这个包容易报错*/

        System.out.println("***********************fastJSON*****************************");
        String str2=JSON.toJSONString(a);
        System.out.println(str2);
        Arrangement b2=JSON.parseObject(str2,Arrangement.class);
        System.out.println(b2.getResult());

        System.out.println("***********************Gson**************************");
        Gson gson=new Gson();
        String str3=gson.toJson(a);
        System.out.println(str3);
        Arrangement b3=gson.fromJson(str3,Arrangement.class);
        System.out.println(b3.getResult());
    }
}
