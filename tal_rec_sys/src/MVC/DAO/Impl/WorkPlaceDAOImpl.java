package MVC.DAO.Impl;

import MVC.DAO.WorkPlaceDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import com.sun.rowset.CachedRowSetImpl;;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class WorkPlaceDAOImpl implements WorkPlaceDAO {

    @Override
    public List<Map> getAll() throws SQLException {
        CachedRowSetImpl rs = CommonConnection.makeQuery("select * from work_place", ConnectUser.HR);
        return JsonUtils.toMap(rs,"wp_id","wp_name","wp_detail");
    }

    @Override
    public List<Map> getName() throws SQLException{
        CachedRowSetImpl rs = CommonConnection.makeQuery("select wp_id,wp_name from work_place",ConnectUser.HR);
        return JsonUtils.toMap(rs,"wp_id","wp_name");
    }

}
