package example;

import bean.Arrangement;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import ienum.Arr_result;

import java.util.ArrayList;

public class JsonExample {
    public static void main(String []argv){
        /* Notice:
            1.Bean应该有无参初始化方法
            2.Bean的属性若为private，则必须给出setter和getter方法
         */

        //****************************Object&Str******************************
        Arrangement a=new Arrangement("0",Arr_result.PASS);
        String str=JSON.toJSONString(a);
        Arrangement b=JSON.parseObject(str,Arrangement.class);
        System.out.println(b.getRec_id()+"/"+b.getResult());

        //****************************List&Str******************************
        ArrayList<Arrangement> arrangements=new ArrayList<Arrangement>();
        arrangements.add(new Arrangement("0", Arr_result.PASS));
        arrangements.add(new Arrangement("1",Arr_result.PASS));
        String json= JSON.toJSONString(arrangements);
        ArrayList<Arrangement>arrs=(ArrayList<Arrangement>)JSON.parseArray(json,Arrangement.class);
        System.out.println(arrs.get(0).getRec_id()+"/"+arrs.get(0).getResult());
        System.out.println(arrs.get(1).getRec_id()+"/"+arrs.get(1).getResult());

        //************************List2Json2Array*******************************
        Arrangement []arrs2=JSON.parseObject(json,Arrangement[].class);
        System.out.println(arrs2[0].getRec_id()+"/"+arrs2[0].getResult());
        System.out.println(arrs2[1].getRec_id()+"/"+arrs2[1].getResult());
    }
}
