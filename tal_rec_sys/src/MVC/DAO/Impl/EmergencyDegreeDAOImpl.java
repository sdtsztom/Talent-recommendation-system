package MVC.DAO.Impl;

import MVC.DAO.EmergencyDegreeDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class EmergencyDegreeDAOImpl implements EmergencyDegreeDAO {

    @Override
    public List<Map> getAll() throws SQLException{
        ResultSet rs = CommonConnection.makeQuery("select * from emergency_degree", ConnectUser.HR);
        return JsonUtils.toMap(rs,"ed_id","ed_name","ed_desc");
    }

    @Override
    public List<Map> getName() throws SQLException{
        ResultSet rs = CommonConnection.makeQuery("select ed_id,ed_name from emergency_degree",ConnectUser.HR);
        return JsonUtils.toMap(rs,"ed_id","ed_name");
    }
}
