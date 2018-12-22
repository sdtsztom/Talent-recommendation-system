package MVC.Service;

import MVC.DAO.RecruitDAO;
import bean.LoginUser;
import bean.Recruit;
import bean.RrSortOrder;
import ienum.ConnectUser;
import ienum.JobType;
import ienum.RrStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class QueryServiceImpl implements QueryService{

    @Autowired
    RecruitDAO recruitDAO;

    @Override
    public List<Map> getSimple(HttpServletRequest request) throws Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JobType jobType =((LoginUser) request.getSession().getAttribute("user")).getJob_type();
        ConnectUser connectUser = null;
        switch (jobType){
            case HR:connectUser=ConnectUser.HR;break;
            case STUFF:connectUser=ConnectUser.STUFF;break;
            case ADMIN:connectUser=ConnectUser.ADMIN;break;
        }
        String order = null;
        if(request.getParameter("sort")!=null){
            switch (Integer.parseInt(request.getParameter("sort"))){
                case 1:{
                    order = "order by rr_el desc";
                    break;
                }
                case 2:{
                    order = "order by rr_ed_id asc";
                    break;
                }
                case 3:{
                    order = "order by rr_el asc, rr_ed_id desc";
                }
            }
        }
        return recruitDAO.getSimple(df.format(new Date()),connectUser,order);
    }

    @Override
    public List<Map> getHRs(HttpServletRequest request) throws Exception {

        LoginUser user=(LoginUser)request.getSession().getAttribute("user");

        String order = null;
        if(request.getParameter("sort")!=null){
            switch (Integer.parseInt(request.getParameter("sort"))){
                case 1:{
                    order = "order by rr_el desc";
                    break;
                }
                case 2:{
                    order = "order by rr_ed_id asc";
                    break;
                }
                case 3:{
                    order = "order by rr_el asc, rr_ed_id desc";
                    break;
                }
            }
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return recruitDAO.getHRs(df.format(new Date()),user.getId(),order);
    }

    @Override
    public List<Map> getDetails(HttpServletRequest request) throws Exception{
        String rr_id = request.getParameter("rr_id");
        JobType jobType =((LoginUser) request.getSession().getAttribute("user")).getJob_type();
        ConnectUser connectUser = null;
        switch (jobType){
            case HR:connectUser=ConnectUser.HR;break;
            case STUFF:connectUser=ConnectUser.STUFF;break;
            case ADMIN:connectUser=ConnectUser.ADMIN;break;
        }
        return recruitDAO.getDetails(rr_id,connectUser);
    }

}
