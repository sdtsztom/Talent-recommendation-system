package MVC.Service;

import MVC.DAO.*;
import MVC.DAO.Impl.IDToDescDAOImpl;
import bean.LoginUser;
import ienum.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    RecommendPeopleDAO rpDAO;

    @Autowired
    IDToDescDAOImpl dao;

    @Autowired
    JobDAO jobDAO;

    @Autowired
    RecommendDAO recommendDAO;

    @Autowired
    RecruitmentRequirementsDAO recruitmentRequirementsDAO;

    @Autowired
    StuffDAO stuffDAO;

    @Autowired
    RequirementsCommonInfoDAO requirementsCommonInfoDAO;

    @Override
    public List<Map> getAllRecommendPeople() throws SQLException {
        return rpDAO.getDesc();
    }

    @Override
    public List<List<Map>> getRPSelect() throws Exception {
        List<List<Map>> list = new ArrayList();
        list.add(dao.degree());
        list.add(dao.university());
        list.add(jobDAO.getName());
        return list;
    }

    @Override
    public int RecommendPageInsert(HttpServletRequest request,String rp_id,String recf_id,String rr_id) throws Exception{
        HttpSession session = request.getSession();
        //测试用session
        session.setAttribute("user",new LoginUser("1","1", JobType.STUFF));
        LoginUser loginUser = (LoginUser)  session.getAttribute("user");
        List<Map> list = recruitmentRequirementsDAO.getHR(rr_id);
        String hr_id = "";
        for(Map<String,String> m : list) {
            hr_id = m.get("rr_hr_id");
        }
        return recommendDAO.InsertRecommend(rp_id,loginUser.getId(),rr_id,hr_id,recf_id);
    }

    @Override
    public List<Map> getRecommendByStuffId(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        //测试用session
        session.setAttribute("user",new LoginUser("1","1", JobType.STUFF));
        LoginUser loginUser = (LoginUser)  session.getAttribute("user");
        return recommendDAO.getDescByStuffId(loginUser.getId());
    }

    @Override
    public List<Map> getValidRecommendByStuffId(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        //测试用session
        session.setAttribute("user",new LoginUser("1","1", JobType.STUFF));
        LoginUser loginUser = (LoginUser)  session.getAttribute("user");
        return recommendDAO.getValidDescByStuffId(loginUser.getId());
    }

    @Override
    public List<List<Map>> getRecommendPageSelect() throws Exception{
        List<List<Map>> list = new ArrayList();
        list.add(recruitmentRequirementsDAO.getAll());
        list.add(rpDAO.getDesc());
        list.add(dao.recommendfrom());
        return list;
    }

    @Override
    public int RecommendPeopleInsert(String name, String age, String tel, String email, String grt, String major, String abi, String path, String sex, String stu, String deg_id, String uni_id, String jb_id) {
        return rpDAO.Insert(name,age,tel,email,grt,major,abi,path,sex,stu,deg_id,uni_id,jb_id);
    }

    @Override
    public List<Map> getValidRRDesc() throws Exception{
        return recruitmentRequirementsDAO.getValidDesc();
    }

    @Override
    public List<Map> getValidRR() throws Exception {
        return recruitmentRequirementsDAO.getValid();
    }

    @Override
    public List<List<Map>> getRepublishDemandSelect() throws Exception {
        List<List<Map>> lists = new ArrayList<>();
        lists.add(dao.work_place());
        lists.add(dao.stuff_type());
        lists.add(requirementsCommonInfoDAO.getDesc());
        lists.add(dao.emergency_degree());
        lists.add(dao.recruitment_requirements_stage());
        return lists;
    }

    @Override
    public int RRUpdate(HttpServletRequest request,String rr_id, String rr_wp_id, String rr_ed_id, String rr_st_id, String rr_ri_id, String rr_sta_id, String rr_num, String rr_el, String rr_ept, String rr_spreq) {
        HttpSession session = request.getSession();
        //测试用session
        session.setAttribute("user",new LoginUser("1","1", JobType.STUFF));
        LoginUser loginUser = (LoginUser)  session.getAttribute("user");
        return recruitmentRequirementsDAO.update(rr_id,rr_wp_id,rr_ed_id,rr_st_id,loginUser.getId(),rr_ri_id,rr_sta_id,rr_num,rr_el,rr_ept,rr_spreq);
    }
}
