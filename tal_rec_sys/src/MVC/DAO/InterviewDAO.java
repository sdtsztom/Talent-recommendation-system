package MVC.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface InterviewDAO {

    int insert(String ip_id,String rp_id,String dealHR_id,String rr_id,String itv_time,String exmer_id,String itv_detail,String itv_rnd);

    int update(String ip_id,String rp_id,String dealHR_id,String rr_id,String itv_time,String exmer_id,String itv_detail,String ip_rnd,String itv_res,String itv_id);

    List<Map> getAll() throws SQLException;
}

