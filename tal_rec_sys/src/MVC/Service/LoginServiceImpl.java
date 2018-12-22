package MVC.Service;

import MVC.DAO.Impl.LogincheckDAOImpl;
import MVC.DAO.LogincheckDAO;
import bean.LoginUser;
import ienum.ConnectUser;
import ienum.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import util.CommonConnection;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LogincheckDAO logincheckDAO;

    @Override
    public boolean isRight(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("pwd").trim();
        return logincheckDAO.isRight(username,password);
    }

    @Override
    public void insertUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String user_id = logincheckDAO.getUser_id(username);
        String jt_name = logincheckDAO.getJob_type(user_id);
        JobType jt_type=null;
        for(JobType i:JobType.values()){
            if(jt_name.equals(i.toString())){
                jt_type=i;
                break;
            }
        }
        LoginUser user = new LoginUser(user_id,username, jt_type);
        request.getSession().setAttribute("user",user);
    }

    @Override
    public  String getPath(LoginUser user){
        String redirect_path = null;
        JobType jt_type = user.getJob_type();
        switch (jt_type){
            case HR:redirect_path="redirect: /HR.html";break;
            case ADMIN:redirect_path="redirect: /Admin.html";break;
            case STUFF:redirect_path="redirect: /Stuff.html";break;
        }
        return redirect_path;
    }

}
