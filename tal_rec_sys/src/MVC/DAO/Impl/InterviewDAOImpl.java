package MVC.DAO.Impl;

import MVC.DAO.InterviewDAO;
import com.sun.rowset.CachedRowSetImpl;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class InterviewDAOImpl implements InterviewDAO {

    @Override
    public int insert(String ip_id,String rp_id,String dealHR_id,String rr_id,String itv_time,String exmer_id,String itv_detail) {
        return CommonConnection.Update("INSERT INTO interview VALUES("+ip_id+",7,"+rp_id+","+dealHR_id+","+rr_id+",1,'"+itv_time+"',"+exmer_id+",'"+itv_detail+"');",ConnectUser.DEV);
    }

    @Override
    public int update(String ip_id,String rp_id,String dealHR_id,String rr_id,String itv_time,String exmer_id,String itv_detail,String ip_rnd,String itv_res,String itv_id) {
        return CommonConnection.Update("update interview set itv_res_id ="+itv_res+",itv_rnd="+ip_rnd+",itv_pl_id="+ip_id+",itv_rp_id="+rp_id+",itv_dealHR_id="+dealHR_id+",itv_rr_id="+rr_id+",itv_time='"+itv_time+"',itv_exmer_id="+exmer_id+",itv_detals='"+itv_detail+"' where itv_id="+itv_id+";",ConnectUser.DEV);
    }

    @Override
    public List<Map> getAll() throws SQLException {
        CachedRowSetImpl rs = CommonConnection.makeQuery("select * from interview",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"itv_id","itv_pl_id","itv_res_id","itv_rp_id","itv_dealHR_id","itv_rr_id","itv_rnd","itv_time","itv_exmer_id","itv_detals");
    }
}
