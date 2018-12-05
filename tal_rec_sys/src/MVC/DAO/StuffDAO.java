package MVC.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StuffDAO {

    List<Map> getHR(String stu_id);

    List<Map> getName();

    List<Map> getEmail() throws SQLException;
}
