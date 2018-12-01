package MVC.DAO.Impl;

import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public class IDToDescDAOImpl {

    public List<Map> degree() throws Exception{
        ResultSet rs = CommonConnection.makeQuery("select deg_id,deg_name from degree",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"deg_id","deg_name");
    }

    public List<Map> university() throws Exception {
        ResultSet rs = CommonConnection.makeQuery("select uni_id,uni_name from university",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"uni_id","uni_name");
    }

    public List<Map> recommendfrom() throws Exception {
        ResultSet rs = CommonConnection.makeQuery("select recf_id,recf_desc from recommend_from",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"recf_id","recf_desc");
    }

    public List<Map> interviewplace() {
        ResultSet rs =CommonConnection.makeQuery("select ip_id,work_place.wp_detail,ip_detail from interview_place inner join work_place on wp_id = ip_id;",ConnectUser.DEV);
        try{
            return JsonUtils.toMap(rs,"ip_id","wp_detail","ip_detail");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Map> stuff_type() throws Exception{
        ResultSet rs = CommonConnection.makeQuery("select st_id,st_name,st_desc from stuff_type;",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"st_id","st_name","st_desc");
    }

    public List<Map> work_place() throws Exception {
        ResultSet rs = CommonConnection.makeQuery("select wp_id,wp_name,wp_detail from work_place;",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"wp_id","wp_name","wp_detail");
    }

    public List<Map> emergency_degree() throws Exception {
        ResultSet rs = CommonConnection.makeQuery("select ed_id,ed_name from emergency_degree;",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"ed_id","ed_name");
    }

    public List<Map> recruitment_requirements_stage() throws Exception {
        ResultSet rs = CommonConnection.makeQuery("select rrs_id,rrs_desc from recruitment_requirements_stage;",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"rrs_id","rrs_desc");
    }
}
