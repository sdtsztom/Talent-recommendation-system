package MVC.Service;

import bean.Stuff;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface RecommendService {

    List<Map> getAllRecommendPeople() throws SQLException;

    List<List<Map>> getRPSelect() throws Exception;

    List<Map> getRecommendByStuffId(HttpServletRequest request) throws Exception;

    List<Map> getValidRecommendByStuffId(HttpServletRequest request) throws Exception;

    List<List<Map>> getRecommendPageSelect() throws Exception;

    int RecommendPageInsert(HttpServletRequest request,String rp_id,String recf_id,String rr_id) throws Exception;

    int RecommendPeopleInsert(String name,String age,String tel,String email,String grt,String major,String abi,String path,String sex,String stu,String deg_id,String uni_id,String jb_id);

    List<Map> getValidRRDesc() throws Exception;

    List<Map> getValidRR() throws Exception;

    List<List<Map>> getRepublishDemandSelect() throws Exception;

    int RRUpdate(HttpServletRequest request,String rr_id,String rr_wp_id, String rr_ed_id, String rr_st_id, String rr_ri_id, String rr_sta_id, String rr_num, String rr_el, String rr_ept, String rr_spreq) throws Exception;

    int StuffInsert(Stuff stuff);

    int RecommendUpdate(String rec_id,String rec_recres_id);
}
