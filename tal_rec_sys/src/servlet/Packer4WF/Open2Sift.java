package servlet.Packer4WF;

import workflow.Tsk_open2sift;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Open2Sift")
public class Open2Sift extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rrid=request.getParameter("rrid");
        System.out.println("rrid:"+rrid);
        //************************pass it to workflow************************
        response.sendRedirect("/complete/5?rr_id="+rrid);
        //response.sendRedirect("/function/Query_Recruit_HR.html");
    }
}
