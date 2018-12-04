package MVC.DAO.Impl;

import MVC.DAO.PointDAO;
import ienum.ConnectUser;
import org.springframework.stereotype.Repository;
import util.CommonConnection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Repository
public class PointDAOImpl implements PointDAO {

    @Override
    public int ChangePoint(String pointChangeRule,String stf_id) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String parsedtime = time.format(formatter);
        CommonConnection.setConnectUser(ConnectUser.DEV);
        return CommonConnection.Update("INSERT INTO points_change values(+"+pointChangeRule+","+stf_id+",'"+parsedtime+"')");
    }
}
