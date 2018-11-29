package MVC.DAO;

import java.util.List;
import java.util.Map;

public interface RecommendDAO {
    List<Map> getDescByStuffId(String stu_id) throws Exception;

    List<Map> getValidDescByStuffId(String stu_id) throws Exception;

    int InsertRecommend(String rp_id,String stu_id,String rr_id,String hr_id,String recf_id);
}

