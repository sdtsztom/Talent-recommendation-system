package MVC.DAO.Impl;

import MVC.DAO.StuffDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public class StuffDAOImpl implements StuffDAO {

    @Override
    public List<Map> getHR(String stu_id) {
        return null;
    }

    @Override
    public List<Map> getName() {
        CommonConnection.setConnectUser(ConnectUser.DEV);
        ResultSet rs = CommonConnection.makeQuery("select stf_id,stf_name from stuff;");
        try{
            return JsonUtils.toMap(rs,"stf_id","stf_name");
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
