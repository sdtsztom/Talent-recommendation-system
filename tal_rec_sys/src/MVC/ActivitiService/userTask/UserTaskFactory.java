package MVC.ActivitiService.userTask;

import org.springframework.stereotype.Service;

@Service
public class UserTaskFactory {

    public userTask getuserTask(String id) {
        if(id.equals("5")) return new userTask5();
        if(id.equals("6")) return new userTask6();
        if(id.equals("7")) return new userTask7();
        if(id.equals("8")) return new userTask8();
        if(id.equals("9")) return new userTask9();
        if(id.equals("10")) return new userTask10();
        if(id.equals("11")) return new userTask11();
        if(id.equals("12")) return new userTask12();
        return null;
    }
}
