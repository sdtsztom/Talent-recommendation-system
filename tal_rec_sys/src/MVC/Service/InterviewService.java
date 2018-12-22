package MVC.Service;

import java.util.List;
import java.util.Map;

public interface InterviewService {

    int BuildInterview(String ip_id,String rp_id,String dealHR_id,String rr_id,String itv_time,String exmer_id,String itv_detail);

    List<List<Map>> getSelect() throws Exception;

    int Update(String ip_id,String rp_id,String dealHR_id,String rr_id,String itv_time,String exmer_id,String itv_detail,String ip_rnd,String itv_res,String itv_id);

}
