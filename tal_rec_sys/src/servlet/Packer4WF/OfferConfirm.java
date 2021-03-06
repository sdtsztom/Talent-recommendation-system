package servlet.Packer4WF;

import bean.ConfirmUser;
import ienum.ConnectUser;
import ienum.RecStage;
import ienum.eErrorPage;
import util.CommonConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "OfferConfirm")
public class OfferConfirm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        ConfirmUser user=(ConfirmUser) session.getAttribute("confirm_user");
        if(user==null){
            response.sendRedirect(eErrorPage.PERMISSIONDENY.toString());
            return;
        }
        String rp_id=user.getId();
        String name=user.getName();
        String sex=user.getSex();
        String values[]=CommonConnection.singleLineQuery("select rec_id,rec_rr_id from recommend where rec_rp_id="+rp_id+" and rec_recsta_id="+RecStage.W_OC.toId(),2,ConnectUser.SYS);
        String rec_id=values[0];
        String rrid= values[1];

        System.out.println(rec_id+"|"+rrid+"|"+"select rec_id,rec_rr_id from recommend where rec_rp_id="+rp_id+" and rec_recsta_id="+RecStage.W_OC.toId());

        String type=request.getParameter("type");
        String username="";
        String pwd="";
        if(type.equals("confirm")){
            username+=request.getParameter("username");
            pwd+=request.getParameter("pwd");
        }

        //TODO 这些分散的参数应该放入map在序列化成json

        //************************pass it to workflow************************

        //************************pass it to workflow************************
        /*if(type.equals("confirm"))*/response.sendRedirect("/complete/12?"+
                "rr_id="+rrid+
                "&rec_id="+rec_id+
                "&name="+name+
                "&sex="+sex+
                "&username="+username+
                "&pwd="+pwd+
                "&type="+type);
                //"params = params");
        //else if(type.equals("refuse"))response.sendRedirect("");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}