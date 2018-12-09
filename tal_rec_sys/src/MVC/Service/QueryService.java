package MVC.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface QueryService {

    List<Map> getSimple(HttpServletRequest request) throws Exception;

    List<Map> getHRs(HttpServletRequest request) throws Exception;

    List<Map> getDetails(HttpServletRequest request) throws Exception;

}
