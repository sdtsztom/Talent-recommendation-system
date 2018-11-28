package MVC.DAO.Impl;

import MVC.DAO.RequirementsCommonInfoDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public class RequirementsCommonInfoDAOImpl implements RequirementsCommonInfoDAO {

    @Override
    public List<Map> getDesc() throws Exception{
        CommonConnection.setConnectUser(ConnectUser.DEV);
        ResultSet rs = CommonConnection.makeQuery("select ri_id,ri_desc,ri_req,departments.dp_name from requirements_common_info inner join departments on ri_dpt_id = departments.dp_id;");
        return JsonUtils.toMap(rs,"ri_id","ri_desc","ri_req","dp_name");
    }
}
