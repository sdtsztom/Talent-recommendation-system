package MVC.DAO.Impl;

import MVC.DAO.LogincheckDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;

@Repository
public class LogincheckDAOImpl implements LogincheckDAO {

    @Override
    public String getUser_id(String username){
        String user_id = CommonConnection.singleResultQuery("select stf_id from stuff where stf_username='" + username + "'",ConnectUser.SYS);
        return user_id;
    }

    @Override
    public String getJob_type(String id){
        String jt_name=CommonConnection.singleResultQuery("select stf_jt_name from stuff_job_type where stf_id="+id,ConnectUser.SYS);
        return jt_name;
    }

    @Override
    public boolean isRight(String username,String password){
        return CommonConnection.existQuery("select * from stuff where stf_username = '" +
                username + "' and stf_pwd='" + password + "'", ConnectUser.SYS);
    }
}
