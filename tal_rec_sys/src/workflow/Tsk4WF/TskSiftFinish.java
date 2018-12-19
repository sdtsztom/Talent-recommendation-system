package workflow.Tsk4WF;

import bean.Arrangement;
import ienum.ConnectUser;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import util.CommonConnection;
import workflow.Tsk_sift;

public class TskSiftFinish implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String json=(String)delegateExecution.getVariable("json");
        Arrangement[] arrangements=ArrangementListUnpacker.unpack2array(json);
        // 查询出rrid
        // 本来直接为workflow传来rrid更优雅
        // 但由于理解失误(此函数非Tsk_sift.finish作者所写)，导致原先的使用方式出现了错误
        // API已经确定，不想再改了，只能修改此函数
        // 故选择这样稍不优雅的实现方式
        String rrid= CommonConnection.singleResultQuery("select rec_rr_id from recommend where rec_id="+arrangements[0].getRec_id(), ConnectUser.SYS);
        boolean finish = Tsk_sift.finish(rrid);
        delegateExecution.setVariable("isFinish",finish);
    }

    public void exec_debug(String json){
        Arrangement[] arrangements=ArrangementListUnpacker.unpack2array(json);
        String rrid= CommonConnection.singleResultQuery("select rec_rr_id from recommend where rec_id="+arrangements[0].getRec_id(), ConnectUser.SYS);
        boolean finish = Tsk_sift.finish(rrid);
    }
}
