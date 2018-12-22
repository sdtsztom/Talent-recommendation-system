package MVC.DAO;

import java.util.Map;

public interface LogincheckDAO {
    String getUser_id(String username);
    String getJob_type(String id);
    boolean isRight(String username,String password);
}
