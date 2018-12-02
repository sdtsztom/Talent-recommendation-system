package MVC.ActivitiService;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CandidateUsers {

    //将任务分发给HR和admin
    public List<String> CandidateUsers(DelegateExecution execution) {
        return Arrays.asList("admin","HR");
    }
}
