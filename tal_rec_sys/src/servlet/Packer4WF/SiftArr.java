package servlet.Packer4WF;

import bean.Arrangement;
import com.alibaba.fastjson.JSON;
import ienum.Arr_result;

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
        while(keys.hasMoreElements()){
            Arrangement temp=new Arrangement();
            String key=keys.nextElement();
            String rec_id=key.split("_")[1];
            String value=request.getParameter(key);
            Arr_result arr=null;
            if(key.equals("itv"))arr=Arr_result.INTERVIEW;
            else if(key.equals("otherneed")){
                arr=Arr_result.OTHERNEED;
                temp.setRr_id_of_otherNeed(request.getParameter("id_otherNeed_"+rec_id));
            }else if(key.equals("talents"))arr=Arr_result.TALENTS;
            temp.setRec_id(rec_id);
            temp.setResult(arr);
            arrangements.add(temp);
        }
        String json_str= JSON.toJSONString(arrangements);
        //************************pass it to workflow************************
        response.sendRedirect("/complete/7?json="+json_str);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
