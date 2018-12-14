package servlet.Packer4WF;

import bean.Arrangement;
import ienum.Arr_result;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet(name = "SiftServlet")
public class SiftServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> keys=request.getParameterNames();
        ArrayList<Arrangement> arrangements=new ArrayList<Arrangement>();
        while(keys.hasMoreElements()){
            String key=keys.nextElement();
            String rec_id=key.split("_")[1];
            String value=request.getParameter(key);
            Arr_result arr=null;
            if(key.equals("pass"))arr=Arr_result.PASS;
            else if(key.equals("fail"))arr=Arr_result.TALENTS;
            arrangements.add(new Arrangement(rec_id,arr));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
