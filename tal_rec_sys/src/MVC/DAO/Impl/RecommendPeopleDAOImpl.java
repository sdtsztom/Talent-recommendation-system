package MVC.DAO.Impl;


import MVC.DAO.RecommendPeopleDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;
import util.JsonUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class RecommendPeopleDAOImpl implements RecommendPeopleDAO {

    @Override
    public List<Map> getDesc() throws SQLException{
        ResultSet rs = CommonConnection.makeQuery("select rp_id,\n" +
                "degree.deg_name,\n" +
                "university.uni_name,\n" +
                "rp_name,rp_sex,rp_age,rp_tel_num,rp_email,rp_stu,rp_grt,rp_maj,rp_abi,rp_res_path,rp_vali,\n" +
                "job.jb_name\n" +
                "from recommend_people\n" +
                "inner join degree on degree.deg_id = rp_deg\n" +
                "inner join university on rp_uni = university.uni_id\n" +
                "inner join job on rp_job = job.jb_id\n" +
                "where rp_vali = '是'",ConnectUser.DEV);
        return JsonUtils.toMap(rs,"rp_id","deg_name","uni_name","rp_name","rp_sex","rp_age","rp_tel_num","rp_email","rp_stu","rp_grt","rp_maj","rp_abi","rp_res_path","rp_vali","jb_name");
    }

    @Override
    public int Insert(String name,String age,String tel,String email,String grt,String major,String abi,String path,String sex,String stu,String deg_id,String uni_id,String jb_id) {
        /* 待完善:检验重复插入 */
        return CommonConnection.Update("INSERT INTO recommend_people VALUES ("+deg_id+","+uni_id+",'"+name+"','"+sex+"',"+age+",'"+tel+"','"+email+"','"+stu+"','"+grt+"','"+major+"','"+abi+"','"+path+"','"+'是'+"',"+jb_id+");",ConnectUser.DEV);
    }
}
