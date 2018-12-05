package MVC.DAO.Impl;

import MVC.DAO.StuffDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        ResultSet rs = CommonConnection.makeQuery("select stf_id,stf_name from stuff;",ConnectUser.DEV);
        try{
            return JsonUtils.toMap(rs,"stf_id","stf_name");
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Map> getEmail() throws SQLException {
        ResultSet rs = CommonConnection.makeQuery("select stf_name,stf_email from stuff where stf_id = 1",ConnectUser.SYS);
        return JsonUtils.toMap(rs,"stf_name","stf_email");
    }
}
