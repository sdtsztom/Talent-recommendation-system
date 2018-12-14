package workflow.Tsk4WF;

import MVC.DAO.RecruitmentRequirementsDAO;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import util.JsonUtils;

import java.util.Map;

public class Recommand_update implements JavaDelegate {

    @Autowired
    RecruitmentRequirementsDAO recruitmentRequirementsDAO;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception{
        Map<String,Object> map = JsonUtils.json2Map(delegateExecution.getVariable("Json").toString());
        String rr_id = map.get("rr_id").toString();
        String rr_wp_id = map.get("rr_wp_id").toString();
        String rr_ed_id = map.get("rr_ed_id").toString();
        String rr_st_id = map.get("rr_st_id").toString();
        String rr_hr_id = map.get("rr_hr_id").toString();
        String rr_ri_id = map.get("rr_ri_id").toString();
        String rr_sta_id = map.get("rr_sta_id").toString();
        String rr_num = map.get("rr_num").toString();
        String rr_el = map.get("rr_el").toString();
        String rr_ept = map.get("rr_ept").toString();
        String rr_spreq = map.get("rr_spreq").toString();
        recruitmentRequirementsDAO.update(rr_id,rr_wp_id,rr_ed_id,rr_st_id,rr_hr_id,rr_ri_id,rr_sta_id,rr_num,rr_el,rr_ept,rr_spreq);
    }

}
