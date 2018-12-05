package MVC.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface PublishService {

    List<Map> getRequirementInfo() throws Exception;

    List<Map> getWorkplaceName() throws Exception;

    List<Map> getEmergencyName() throws Exception;

    List<Map> getStufftypeName() throws Exception;

    String Publish(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
