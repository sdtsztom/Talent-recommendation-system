package MVC.DAO;

public interface InterviewDAO {

    int insert(String ip_id,String rp_id,String dealHR_id,String rr_id,String itv_time,String exmer_id,String itv_detail);

    int update(String id,String res_id,String rnd);
}
