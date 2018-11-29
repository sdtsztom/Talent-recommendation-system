package MVC.DAO.Impl;

import MVC.DAO.InterviewDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;

@Repository
public class InterviewDAOImpl implements InterviewDAO {

    @Override
    public int insert(String ip_id,String rp_id,String dealHR_id,String rr_id,String itv_time,String exmer_id,String itv_detail) {
        CommonConnection.setConnectUser(ConnectUser.DEV);
        return CommonConnection.Update("INSERT INTO interview VALUES("+ip_id+",7,"+rp_id+","+dealHR_id+","+rr_id+",1,'"+itv_time+"',"+exmer_id+",'"+itv_detail+"');");
    }
}
