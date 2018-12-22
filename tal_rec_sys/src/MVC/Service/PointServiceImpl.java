package MVC.Service;

import MVC.DAO.PointDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    PointDAO pointDAO;

    @Override
    public void changePoint(String pointChangeRule,String stf_id) {
        pointDAO.ChangePoint(pointChangeRule,stf_id);
    }
}
