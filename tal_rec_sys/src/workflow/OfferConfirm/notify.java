package workflow.OfferConfirm;

import MVC.DAO.RecommendDAO;
import MVC.DAO.StuffDAO;
import MVC.Service.MailService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


//邮件提醒
@Service
public class notify implements JavaDelegate {

    @Autowired
    RecommendDAO recommendDAO;

    @Autowired
    StuffDAO stuffDAO;

    @Autowired
    MailService mailService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        //获取被推荐人id
        String rp_id = (String) delegateExecution.getVariable("rp_id");
        //根据被推荐人id获取员工id
        String stf_id = recommendDAO.getStuffIdByRPId(rp_id);
        List<Map> list = stuffDAO.getAll();
        //根据员工id获取员工邮箱
        String mail = null;
        for (Map<String, String> map : list) {
            if (map.get("stf_id").equals(stf_id)) {
                mail = map.get("stf_email");
            }
        }
        mailService.sentMail(mail, "mail3-subject", "mail3-content");
    }
}
