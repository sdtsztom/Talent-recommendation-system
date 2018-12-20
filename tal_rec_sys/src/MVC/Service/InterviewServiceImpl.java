package MVC.Service;

import MVC.DAO.Impl.IDToDescDAOImpl;
import MVC.DAO.InterviewDAO;
import MVC.DAO.RecommendPeopleDAO;
import MVC.DAO.RecruitmentRequirementsDAO;
import MVC.DAO.StuffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    InterviewDAO interviewDAO;

    @Autowired
    IDToDescDAOImpl dao;

    @Autowired
    RecommendPeopleDAO recommendPeopleDAO;

    @Autowired
    StuffDAO stuffDAO;

    @Autowired
    RecruitmentRequirementsDAO recruitmentRequirementsDAO;

    @Override
    public int BuildInterview(String ip_id, String rp_id, String dealHR_id, String rr_id, String itv_time, String exmer_id, String itv_detail) {
        return interviewDAO.insert(ip_id,rp_id,dealHR_id,rr_id,itv_time,exmer_id,itv_detail);
    }

    @Override
    public List<List<Map>> getSelect() throws Exception{
        List<List<Map>> list = new ArrayList<>();
        list.add(dao.interviewplace());
        list.add(recommendPeopleDAO.getDesc());
        list.add(stuffDAO.getName());
        list.add(recruitmentRequirementsDAO.getAll());
        list.add(dao.interview_result());
        list.add(interviewDAO.getAll());
        return list;
    }

    @Override
    public int Update(String ip_id,String rp_id,String dealHR_id,String rr_id,String itv_time,String exmer_id,String itv_detail,String ip_rnd,String itv_res,String itv_id) {
        return interviewDAO.update(ip_id,rp_id,dealHR_id,rr_id,itv_time,exmer_id,itv_detail,ip_rnd,itv_res,itv_id);
    }
}

