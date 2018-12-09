package MVC.DAO.Impl;


import MVC.DAO.RequirementInfoDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class RequirementInfoDAOImpl implements RequirementInfoDAO {

    @Override
    public List<Map> getAll() throws SQLException{
        ResultSet rs = CommonConnection.makeQuery("select * from requirement_info_view", ConnectUser.HR);
        return JsonUtils.toMap(rs,"ri_id","jb_name","jt_name","jb_sal","dp_name");
    }

}
