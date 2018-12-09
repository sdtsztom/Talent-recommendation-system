package MVC.DAO;


import ienum.ConnectUser;

import java.util.List;
import java.util.Map;

public interface RecruitDAO {

    List<Map> getHRs(String time,String id,String order) throws Exception;

    List<Map> getSimple(String time, ConnectUser connectUser, String order) throws Exception;

    List<Map> getDetails(String id,ConnectUser connectUser) throws Exception;

}
