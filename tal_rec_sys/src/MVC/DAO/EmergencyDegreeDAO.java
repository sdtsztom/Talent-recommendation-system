package MVC.DAO;

import java.util.List;
import java.util.Map;

public interface EmergencyDegreeDAO {

    List<Map> getAll() throws Exception;

    List<Map> getName() throws Exception;
}
