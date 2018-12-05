package MVC.Controller;

import MVC.Service.LoginService;
import bean.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "check_login",method = RequestMethod.POST)
    public String check(HttpServletRequest request, HttpServletResponse response){
        if(loginService.isRight(request)){
            loginService.insertUser(request);
            return loginService.getPath( (LoginUser) request.getSession().getAttribute("user"));
        }else {
            return "redirect: Login/login.html?error=true";
        }
    }

    @RequestMapping(value = "login_out")
    public String checkout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("user");
        return "redirect: Login/login.html";
    }

}
