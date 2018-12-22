package MVC.DAO.Impl;

import MVC.DAO.RecruitDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import com.sun.rowset.CachedRowSetImpl;;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class RecruitDAOImpl implements RecruitDAO{

    @Override
    public List<Map> getHRs(String time,String id,String order) throws SQLException{
        String sql = "select rr_id,jb_name,rr_num,wp_name,rr_el,rr_ed_id,ed_name,rr_sta_id,rrs_desc from requirement_list " +
                "left join recruitment_requirements_stage on requirement_list.rr_sta_id = recruitment_requirements_stage.rrs_id where rr_hr_id ="
                + id + " and rr_el>'" + time + "' ";
        if(order != null){
            sql += order;
        }
        CachedRowSetImpl rs = CommonConnection.makeQuery(sql,ConnectUser.HR);
        return JsonUtils.toMap(rs,"rr_id","jb_name","rr_num","wp_name","rr_el","rr_ed_id","ed_name","rr_sta_id","rrs_desc");
    }

    @Override
    public List<Map> getSimple(String time,ConnectUser connectUser,String order) throws SQLException{
        String sql = "select rr_id,wp_name,rr_num,rr_el,ed_name from " +
                "recruitment_requirements join work_place on rr_wp_id = wp_id join emergency_degree on rr_ed_id = ed_id " +
                "where rr_el > '" + time + "'";
        if(order != null){
            sql+=order;
        }
        CachedRowSetImpl rs = CommonConnection.makeQuery(sql,connectUser);
        return JsonUtils.toMap(rs,"rr_id","wp_name","rr_num","rr_el","ed_name");
    }

    @Override
    public List<Map> getDetails(String id,ConnectUser connectUser) throws SQLException{
        CachedRowSetImpl rs = CommonConnection.makeQuery("select * from requirement_details where rr_id = " + id,connectUser);
        return JsonUtils.toMap(rs,"rr_id","rr_sta_id","rr_num","ed_name","st_name","st_desc","wp_name","wp_detail","jb_name",
                "jb_desc","jb_sal","jt_name","jt_desc","dp_name","dp_contact","rr_spreq");
    }

}
