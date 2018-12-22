package MVC.Controller;


import MVC.ActivitiService.ActivitiService;
import MVC.Service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.ResResult;

import javax.faces.annotation.RequestMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.Addressing;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PublishController {

    @Autowired
    PublishService publishService;

    @Autowired
    ActivitiService activitiService;

    @RequestMapping(value = "/get.requirementinfo",produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult getRequireinfo() throws Exception{
        return  new ResResult(200,"查询成功",publishService.getRequirementInfo());
    }

    @RequestMapping(value = "/get.requirementdetail",produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult getRequiredetail() throws Exception{
        List<List<Map>> result = new ArrayList<>();
        result.add(publishService.getWorkplaceName());
        result.add(publishService.getStufftypeName());
        result.add(publishService.getEmergencyName());
        return new ResResult(200,"查询成功",result);
    }

    @RequestMapping(value = "/publish.requirement",method = RequestMethod.POST)
    public @ResponseBody String publish(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String result = publishService.Publish(request,response);
        activitiService.startProcess();
        return result;
    }
}
