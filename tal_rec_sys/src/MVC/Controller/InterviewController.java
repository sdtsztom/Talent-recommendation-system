package MVC.Controller;

import MVC.Service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.ResResult;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class InterviewController {

    @Autowired
    InterviewService interviewService;

    @RequestMapping(value = "/ajax.get.Interview_Build_Page",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult resume_entry() throws Exception {
        List<List<Map>> list = interviewService.getSelect();
        return ResResult.build(400,"",list);
    }

    @RequestMapping(value = "/ajax.post.Interview_Build_Page",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult resume_entry_insert(String ip_id,String rp_id,String dealHR_id,String rr_id,String itv_time,String exmer_id,String itv_detail) throws Exception {
        DateTimeFormatter local = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime time = LocalDateTime.parse(itv_time,local);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String parsed_itv_time = time.format(formatter);
        if(interviewService.BuildInterview(ip_id,rp_id,dealHR_id,rr_id,parsed_itv_time,exmer_id,itv_detail)==0) return ResResult.build(200,"插入失败",null);
        else return ResResult.build(400,"插入成功",null);
    }
}
