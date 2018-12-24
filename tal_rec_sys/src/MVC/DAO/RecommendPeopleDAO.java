package MVC.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface RecommendPeopleDAO {

    List<Map> getDesc() throws SQLException;

    int Insert(String name,String age,String tal,String email,String grt,String major,String abi,String path,String sex,String stu,String deg_id,String uni_id,String jb_id);

    List<Map> getVali() throws SQLException;
}
