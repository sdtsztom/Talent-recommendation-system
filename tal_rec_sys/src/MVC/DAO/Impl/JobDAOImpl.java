package MVC.DAO.Impl;

import MVC.DAO.JobDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public class JobDAOImpl implements JobDAO {

    @Override
    public List<Map> getName() throws Exception {
        CommonConnection.setConnectUser(ConnectUser.DEV);
        ResultSet rs = CommonConnection.makeQuery("select jb_id,jb_name from job");
        return JsonUtils.toMap(rs,"jb_id","jb_name");
    }


    @Override
    public List<Map> getAll() throws Exception {
        CommonConnection.setConnectUser(ConnectUser.DEV);
        ResultSet rs = CommonConnection.makeQuery("select jb_id,jb_jt_id,jb_name,jb_desc,jb_sal from job");
        return JsonUtils.toMap(rs,"jb_id","jb_jt_id","jb_name","jb_desc","jb_sal");
    }
}
