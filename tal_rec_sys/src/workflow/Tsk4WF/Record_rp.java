package workflow.Tsk4WF;

import MVC.DAO.Impl.RecommendDAOImpl;
import MVC.DAO.RecruitmentRequirementsDAO;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import util.JsonUtils;

import java.util.Map;

public class Record_rp implements JavaDelegate {

    @Autowired
    RecommendDAOImpl recommendDAO;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception{
        Map<String,Object> map = JsonUtils.json2Map(delegateExecution.getVariable("Json").toString());
        String rp_id = map.get("rp_id").toString();
        String stu_id = map.get("rp_id").toString();
        String rr_id = map.get("rp_id").toString();
        String hr_id = map.get("rp_id").toString();
        String recf_id  = map.get("rp_id").toString();
        recommendDAO.InsertRecommend(rp_id,stu_id,rr_id,hr_id,recf_id);
    }

}
