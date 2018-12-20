package servlet.Packer4WF;

import bean.Arrangement;
import com.alibaba.fastjson.JSON;
import ienum.Arr_result;
import ienum.SRM_Page;
import workflow.Tsk4WF.TskItv2Finish;
import workflow.Tsk4WF.TskItv2PointsDeal;
import workflow.Tsk4WF.TskItv2Record;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet(name = "Intv2")
public class Intv2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> keys=request.getParameterNames();
        ArrayList<Arrangement> arrangements=new ArrayList<Arrangement>();
        String rrid=null;
        while(keys.hasMoreElements()){
            String key=keys.nextElement();
            if(key.equals("rrid"))rrid=request.getParameter(key);
            else{
                String rec_id=key.split("_")[1];
                String value=request.getParameter(key);
                Arr_result arr=null;
                if(value.equals("pass"))arr=Arr_result.PASS;
                else if(value.equals("fail"))arr=Arr_result.NOOFFER;
                arrangements.add(new Arrangement(rec_id,arr));
            }
        }
        String json_str=JSON.toJSONString(arrangements);
        //************************pass it to workflow************************
        //response.sendRedirect("/complete/10?json="+json_str);//userTask10
        TskItv2Record.exec_debug(json_str);
        TskItv2PointsDeal.exec_debug(json_str);
        //************************pass it to workflow************************
        boolean finish= TskItv2Finish.exec_debug(json_str);
        if(finish)response.sendRedirect("/function/Query_Recruit_HR.html");
        else response.sendRedirect(SRM_Page.W_I2.toString()+"?rrid="+rrid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
