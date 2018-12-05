package MVC.Controller;

import MVC.Service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.ResResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class QueryController {

    @Autowired
    QueryService queryService;

    @RequestMapping(value = "/get.detail",produces = "application/json;charset=UTF-8" )
    public @ResponseBody ResResult getDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
        return new ResResult(200,"查询成功",queryService.getDetails(request));
    }

    @RequestMapping(value = "/get.hrs",produces = "application/json;charset=UTF-8" )
    public @ResponseBody ResResult getHRs(HttpServletRequest request,HttpServletResponse response) throws Exception{
        return new ResResult(200,"查询成功",queryService.getHRs(request));
    }

    @RequestMapping(value = "/get.simple",produces = "application/json;charset=UTF-8" )
    public @ResponseBody ResResult getSimple(HttpServletRequest request,HttpServletResponse response) throws Exception{
        return new ResResult(200,"查询成功",queryService.getSimple(request));
    }

}
