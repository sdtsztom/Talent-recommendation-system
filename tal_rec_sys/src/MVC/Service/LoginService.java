package MVC.Service;

import bean.LoginUser;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    boolean isRight(HttpServletRequest request);

    void insertUser(HttpServletRequest request);

    String getPath(LoginUser user);

}
