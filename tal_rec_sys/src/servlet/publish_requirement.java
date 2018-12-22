package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "publish_requirement")
public class publish_requirement extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rr_ri_id = Integer.parseInt(request.getSession().getAttribute("ri_id").toString());
        request.getSession().removeAttribute("ri_id");
        int rr_num = Integer.parseInt(request.getParameter("rr_num"));
        int rr_wp_id = Integer.parseInt(request.getParameter("rr_wp_id"));
        int rr_st_id = Integer.parseInt(request.getParameter("rr_st_id"));
        String rr_el = request.getParameter("rr_el").replace("T"," ");
        int rr_ept = Integer.parseInt(request.getParameter("rr_ept"));
        int rr_ed_id = Integer.parseInt(request.getParameter("rr_ed_id"));
        String rr_spreq = null;
        if(request.getParameter("rr_spreq")!=null){
            rr_spreq = request.getParameter("rr_spreq");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
