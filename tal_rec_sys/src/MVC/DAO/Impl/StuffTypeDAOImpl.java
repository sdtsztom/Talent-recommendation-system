package MVC.DAO.Impl;

import MVC.DAO.StuffTypeDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class StuffTypeDAOImpl implements StuffTypeDAO {


    @Override
    public List<Map> getAll() throws SQLException{
        ResultSet rs = CommonConnection.makeQuery("select * from stuff_type", ConnectUser.HR);
        return JsonUtils.toMap(rs,"st_id","st_name","st_desc");
    }

    @Override
    public List<Map> getName() throws SQLException {
        ResultSet rs = CommonConnection.makeQuery("select st_id,st_name from stuff_type",ConnectUser.HR);
        return JsonUtils.toMap(rs,"st_id","st_name");
    }

}
