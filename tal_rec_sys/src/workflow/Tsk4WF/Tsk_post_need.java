package workflow.Tsk4WF;

import MVC.DAO.RecruitmentRequirementsDAO;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import util.JsonUtils;

import java.util.Map;

public class Tsk_post_need implements JavaDelegate {

    @Autowired
    RecruitmentRequirementsDAO recruitmentRequirementsDAO;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception{
        Map<String,Object> map = JsonUtils.json2Map(delegateExecution.getVariable("Json").toString());
        int rr_wp_id = Integer.parseInt(map.get("rr_wp_id").toString());
        int rr_ed_id = Integer.parseInt(map.get("rr_ed_id").toString());
        int rr_st_id = Integer.parseInt(map.get("rr_st_id").toString());
        int rr_hr_id = Integer.parseInt(map.get("rr_hr_id").toString());
        int rr_ri_id = Integer.parseInt(map.get("rr_ri_id").toString());
        int rr_num = Integer.parseInt(map.get("rr_num").toString());
        String rr_el = map.get("rr_ed").toString();
        int rr_ept = Integer.parseInt(map.get("rr_ept").toString());
        String rr_spreq = map.get("rr_spreq").toString();

        recruitmentRequirementsDAO.insert(rr_wp_id,rr_ed_id,rr_st_id,rr_hr_id,rr_ri_id,rr_num,rr_el,rr_ept,rr_spreq);
    }

}
