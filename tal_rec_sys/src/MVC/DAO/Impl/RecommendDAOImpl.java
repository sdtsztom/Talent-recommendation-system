package MVC.DAO.Impl;

import MVC.DAO.RecommendDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public class RecommendDAOImpl implements RecommendDAO {
    public List<Map> getDescByStuffId(String stu_id) throws Exception {


        ResultSet rs = CommonConnection.makeQuery("select rec_id,\n"+
                "rec_rr_id,\n"+
                "stuff.stf_name,\n"+
                "recommend_people.rp_name,\n"+
                "recommend_from.recf_desc,\n"+
                "recommend_stage.rec_sta_desc,\n"+
                "recommend_results.rec_desc\n"+
                "from recommend\n"+
                "inner join stuff on stuff.stf_id = recommend.rec_recstu_id\n"+
                "inner join recommend_people on recommend_people.rp_id = recommend.rec_rp_id\n"+
                "inner join recommend_from on recommend_from.recf_id = recommend.rec_from_id\n"+
                "inner join recommend_stage on recommend_stage.rec_sta_id = recommend.rec_recsta_id\n"+
                "inner join recommend_results on recommend_results.rec_res_id = recommend.rec_recres_id\n"+
                "where rec_recstu_id="+stu_id,ConnectUser.DEV);
        return JsonUtils.toMap(rs,"rec_id","rec_rr_id","stf_name","rp_name","recf_desc","rec_sta_desc","rec_desc");
    }

    public List<Map> getValidDescByStuffId(String stu_id) throws Exception {
        ResultSet rs = CommonConnection.makeQuery("select rec_id,\n"+
                "rec_rr_id,\n"+
                "stuff.stf_name,\n"+
                "recommend_people.rp_name,\n"+
                "recommend_from.recf_desc,\n"+
                "recommend_stage.rec_sta_desc,\n"+
                "recommend_results.rec_desc\n"+
                "from recommend\n"+
                "inner join stuff on stuff.stf_id = recommend.rec_recstu_id\n"+
                "inner join recommend_people on recommend_people.rp_id = recommend.rec_rp_id\n"+
                "inner join recommend_from on recommend_from.recf_id = recommend.rec_from_id\n"+
                "inner join recommend_stage on recommend_stage.rec_sta_id = recommend.rec_recsta_id\n"+
                "inner join recommend_results on recommend_results.rec_res_id = recommend.rec_recres_id\n"+
                "where rec_recstu_id="+stu_id+" and rec_sta_id != 1",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"rec_id","rec_rr_id","stf_name","rp_name","recf_desc","rec_sta_desc","rec_desc");
    }

    @Override
    public int InsertRecommend(String rp_id,String stu_id,String rr_id,String hr_id,String recf_id) {
        return CommonConnection.Update("INSERT INTO recommend VALUES ("+rp_id+","+stu_id+",6,2,"+rr_id+","+hr_id+","+recf_id+");",ConnectUser.DEV);
    }
}
