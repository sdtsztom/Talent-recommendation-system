package MVC.Service;

import MVC.DAO.*;
import bean.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.Email;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Service
public class PublishServiceImpl implements PublishService {

    @Autowired
    WorkPlaceDAO workPlaceDAO;

    @Autowired
    StuffTypeDAO stuffTypeDAO;

    @Autowired
    RequirementInfoDAO requirementInfoDAO;

    @Autowired
    EmergencyDegreeDAO emergencyDegreeDAO;

    @Autowired
    StuffDAO stuffDAO;

    @Autowired
    RecruitmentRequirementsDAO recruitmentRequirementsDAO;

    @Override
    public List<Map> getRequirementInfo() throws Exception {
        return requirementInfoDAO.getAll();
    }

    @Override
    public  List<Map> getWorkplaceName()throws Exception{
        return workPlaceDAO.getName();
    }

    @Override
    public List<Map> getEmergencyName() throws Exception{
        return emergencyDegreeDAO.getName();
    }

    @Override
    public List<Map> getStufftypeName() throws Exception{
        return stuffTypeDAO.getName();
    }

    @Override
    public String Publish(HttpServletRequest request, HttpServletResponse response) throws Exception{
        int rr_ri_id = Integer.parseInt(request.getSession().getAttribute("ri_id").toString());
        int rr_hr_id = Integer.parseInt( ( (LoginUser) request.getSession().getAttribute("user") ).getId() );
        request.getSession().removeAttribute("ri_id");
        int rr_wp_id = Integer.parseInt(request.getParameter("rr_wp_id"));
        int rr_num = Integer.parseInt(request.getParameter("rr_num"));
        int rr_st_id = Integer.parseInt(request.getParameter("rr_st_id"));
        String rr_el = request.getParameter("rr_el").replace("T"," ");
        int rr_ept = Integer.parseInt(request.getParameter("rr_ept"));
        int rr_ed_id = Integer.parseInt(request.getParameter("rr_ed_id"));
        String rr_spreq = null;
        if(request.getParameter("rr_spreq")!=null){
            rr_spreq = request.getParameter("rr_spreq");
        }
        int result = recruitmentRequirementsDAO.insert(rr_wp_id,rr_ed_id,rr_st_id,rr_hr_id,rr_ri_id,rr_num,rr_el,rr_ept,rr_spreq);
        if(result == 1){
            List<Map> all = stuffDAO.getEmail();
            Email em = new Email();
            em.changeSubject("有新需求发布，请及时查看！");
            for(Map email: all){
                String name = email.get("stf_name").toString();
                String Email = email.get("stf_email").toString();
                em.changeRecipientAddress(Email);
                em.changeContent("亲爱的员工 " + name +" :您好\r\n有一个新需求发布，请及时查看！");
            }

            return "redirect: /HR.html";
        }else{
            return "redirect: /HR.html";
        }

    }

}
