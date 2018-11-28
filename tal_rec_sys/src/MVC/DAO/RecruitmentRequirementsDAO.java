package MVC.DAO;

import java.util.List;
import java.util.Map;

public interface RecruitmentRequirementsDAO {

    List<Map> getAll() throws Exception;

    List<Map> getHR(String rr_id) throws Exception;

    List<Map> getValidDesc() throws Exception;

    List<Map> getValid() throws Exception;

    int update(String rr_id,String rr_wp_id,String rr_ed_id,String rr_st_id,String rr_hr_id,String rr_ri_id,String rr_sta_id,String rr_num,String rr_el,String rr_ept,String rr_spreq);
}
