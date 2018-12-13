package MVC.DAO.Impl;

import MVC.DAO.RecruitmentRequirementsDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public class RecruitmentRequirementsDAOImpl implements RecruitmentRequirementsDAO {

    @Override
    public List<Map> getAll() throws Exception{
        ResultSet rs = CommonConnection.makeQuery("select rr_id,rr_wp_id,rr_ed_id,rr_st_id,rr_hr_id,rr_ri_id,rr_sta_id,rr_num,rr_el,rr_ept,rr_spreq from recruitment_requirements",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"rr_id","rr_wp_id","rr_ed_id","rr_st_id","rr_hr_id","rr_ri_id","rr_sta_id","rr_num","rr_el","rr_ept","rr_spreq");
    }

    @Override
    public List<Map> getValid() throws Exception{
        ResultSet rs = CommonConnection.makeQuery("select rr_id,rr_wp_id,rr_ed_id,rr_st_id,rr_hr_id,rr_ri_id,rr_sta_id,rr_num,rr_el,rr_ept,rr_spreq from recruitment_requirements where rr_sta_id != 1;",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"rr_id","rr_wp_id","rr_ed_id","rr_st_id","rr_hr_id","rr_ri_id","rr_sta_id","rr_num","rr_el","rr_ept","rr_spreq");
    }

    @Override
    public List<Map> getHR(String rr_id) throws Exception{
        ResultSet rs = CommonConnection.makeQuery("select rr_hr_id from recruitment_requirements where rr_id = "+rr_id+";",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"rr_hr_id");

    }

    @Override
    public List<Map> getValidDesc() throws Exception {
        ResultSet rs = CommonConnection.makeQuery("select rr_id,\n" +
                "work_place.wp_name,\n" +
                "emergency_degree.ed_name,emergency_degree.ed_desc,\n" +
                "stuff_type.st_name,stuff_type.st_desc,\n" +
                "stuff.stf_name,\n" +
                "job.jb_name,job.jb_desc,job.jb_sal,\n" +
                "requirements_common_info.ri_desc,requirements_common_info.ri_req,\n" +
                "recruitment_requirements_stage.rrs_desc,\n" +
                "rr_num,rr_el,rr_ept,rr_spreq\n" +
                "from recruitment_requirements\n" +
                "inner join work_place on work_place.wp_id = rr_wp_id\n" +
                "inner join emergency_degree on emergency_degree.ed_id = rr_ed_id\n" +
                "inner join stuff_type on stuff_type.st_id = rr_st_id\n" +
                "inner join stuff on stuff.stf_id = rr_hr_id\n" +
                "inner join requirements_common_info on requirements_common_info.ri_id = rr_ri_id\n" +
                "inner join job on requirements_common_info.ri_job_id = job.jb_id\n" +
                "inner join recruitment_requirements_stage on recruitment_requirements_stage.rrs_id = rr_sta_id\n" +
                "where rr_sta_id != 1;",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"rr_id","wp_name","ed_name","ed_desc","st_name","st_desc","stf_name","jb_name","jb_desc",
                "jb_sal","ri_desc","ri_req","rrs_desc","rr_num","rr_el","rr_ept","rr_spreq");
    }

    @Override
    public int update(String rr_id,String rr_wp_id, String rr_ed_id, String rr_st_id, String rr_hr_id, String rr_ri_id, String rr_sta_id, String rr_num, String rr_el, String rr_ept, String rr_spreq) {
        return CommonConnection.Update("UPDATE recruitment_requirements set rr_wp_id="+rr_wp_id+","+"rr_ed_id="+rr_ed_id+","+
                        "rr_st_id="+rr_st_id+","+"rr_hr_id="+rr_hr_id+","+"rr_ri_id="+rr_ri_id+","+"rr_sta_id="+rr_sta_id+","+
                        "rr_num="+rr_num+","+"rr_el='"+rr_el+"',"+"rr_ept="+rr_ept+","+"rr_spreq='"+rr_spreq+"' where rr_id="+rr_id+";",ConnectUser.DEV);

    }

    @Override
    public int insert(int rr_wp_id, int rr_ed_id, int rr_st_id, int rr_hr_id, int rr_ri_id,int rr_num, String rr_el, int rr_ept, String rr_spreq){
        return CommonConnection.Update("insert into recruitment_requirements values(" + rr_wp_id+ "," + rr_ed_id + "," + rr_st_id + "," + rr_hr_id + "," +
                rr_ri_id + ",2," + rr_num + ",'" + rr_el +"'," + rr_ept + ",'" + rr_spreq + "')",ConnectUser.DEV);
    }
}
