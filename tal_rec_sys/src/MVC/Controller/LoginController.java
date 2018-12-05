package MVC.Controller;

import MVC.Service.LoginService;
import bean.LoginUser;
import ienum.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.ResResult;

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
    public @ResponseBody String checkout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("user");
        return "true";
    }

    @RequestMapping(value = "/login_type")
    public @ResponseBody String get_type(HttpServletRequest request, HttpServletResponse response){
        String type = null;
        if(request.getSession().getAttribute("user")!=null){
            type = ((LoginUser) request.getSession().getAttribute("user") ).getJob_type().toString();
        }
        return type;
    }
}
