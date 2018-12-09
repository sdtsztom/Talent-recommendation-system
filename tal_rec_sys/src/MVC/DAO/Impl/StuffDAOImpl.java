package MVC.DAO.Impl;

import MVC.DAO.StuffDAO;
import bean.Stuff;
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

    @Override
    public List<Map> getAll() {
        ResultSet rs = CommonConnection.makeQuery("select stf_id,stf_job_id,stf_dp_id,stf_name,stf_age,stf_sex,stf_username,stf_pwd,stf_email,stf_pts,stf_tel from stuff;",ConnectUser.DEV);
        try {
            return JsonUtils.toMap(rs,"stf_id","stf_job_id","stf_dp_id","stf_name","stf_age","stf_sex","stf_username","stf_pwd","stf_email","stf_pts","stf_tel");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int insert(Stuff stuff) {
        return CommonConnection.Update("insert into stuff values("+stuff.getStf_job_id()+","
                +stuff.getStf_dp_id()+",'"+stuff.getStf_name()+"',"+stuff.getStf_age()+",'"
                +stuff.getStf_sex()+"','"+stuff.getStf_username()+"','"+stuff.getStf_pwd()+"','"
                +stuff.getStf_email()+"',"+stuff.getStf_pts()+",'"+stuff.getStf_tel()+"')",ConnectUser.DEV);
    }
}
