package workflow.Tsk4WF;

import bean.Arrangement;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;

// 考虑到效率，因此优先使用array

public class ArrangementListUnpacker {
    public static ArrayList<Arrangement> unpack(String json){
        return (ArrayList<Arrangement>)JSON.parseArray(json,Arrangement.class);
    }
    public static Arrangement[] unpack2array(String json){
        return JSON.parseObject(json,Arrangement[].class);
    }
}
