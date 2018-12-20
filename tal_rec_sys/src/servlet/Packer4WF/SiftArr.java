package servlet.Packer4WF;

import bean.Arrangement;
import com.alibaba.fastjson.JSON;
import ienum.Arr_result;
import ienum.SRM_Page;
import workflow.Tsk4WF.TskSiftArrEmail;
import workflow.Tsk4WF.TskSiftArrFinish;
import workflow.Tsk4WF.TskSiftArrRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet(name = "SiftArr")
public class SiftArr extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> keys=request.getParameterNames();
        ArrayList<Arrangement> arrangements=new ArrayList<Arrangement>();
        String rrid=null;
        while(keys.hasMoreElements()){
            Arrangement temp=new Arrangement();
            String key=keys.nextElement();
            if(key.equals("rrid"))rrid=request.getParameter(key);
            else{
                String rec_id=key.split("_")[1];
                String value=request.getParameter(key);
                Arr_result arr=null;
                if(value.equals("itv"))arr=Arr_result.INTERVIEW;
                else if(value.equals("otherneed")){
                    arr=Arr_result.OTHERNEED;
                    temp.setRr_id_of_otherNeed(request.getParameter("id_otherNeed_"+rec_id));
                }else if(value.equals("talents"))arr=Arr_result.TALENTS;
                temp.setRec_id(rec_id);
                temp.setResult(arr);
                arrangements.add(temp);
            }
        }
        String json_str= JSON.toJSONString(arrangements);
        //************************pass it to workflow************************
        //response.sendRedirect("/complete/5?json="+json_str);//userTask5
        TskSiftArrRecord.exec_debug(json_str);
        TskSiftArrEmail.exec_debug(json_str);
        //************************pass it to workflow************************
        boolean finish= TskSiftArrFinish.exec_debug(json_str);
        if(finish)response.sendRedirect("/function/Query_Recruit_HR.html");
        else response.sendRedirect(SRM_Page.W_ARR_S.toString()+"?rrid="+rrid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
