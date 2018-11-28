package MVC.Controller;

import MVC.Service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.ResResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    @RequestMapping(value = "/ajax.get.PR_Detail",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult RP_Detail() throws Exception {
        List<Map> rpList = recommendService.getAllRecommendPeople();
        List<List<Map>> list = recommendService.getRPSelect();
        list.add(rpList);
        return ResResult.build(400,"",list);
    }

    @RequestMapping(value = "/ajax.get.Stuff_Recommend_History",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult Stuff_Recommend_History(HttpServletRequest request) throws Exception {
        List<Map> list = recommendService.getRecommendByStuffId(request);
        return ResResult.build(400,"",list);
    }

    @RequestMapping(value = "/ajax.get.Stuff_Recommend_Track",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult Stuff_Recommend_Track(HttpServletRequest request) throws Exception {
        List<Map> list = recommendService.getValidRecommendByStuffId(request);
        return ResResult.build(400,"",list);
    }

    @RequestMapping(value = "/ajax.get.Stuff_Recommend_Page",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult Stuff_Recommend_Page(HttpServletRequest request) throws Exception {
        List<List<Map>> list = recommendService.getRecommendPageSelect();
        List<Map> VilidRecommned = recommendService.getValidRecommendByStuffId(request);
        String msg = "true";
        if(VilidRecommned.size() == 0) {
            msg = "false";
        }
        return ResResult.build(400,msg,list);
    }

    @RequestMapping(value = "/ajax.post.Stuff_Recommend_Page",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult Stuff_Recommend_Page_Insert(HttpServletRequest request,String rp_id,String recf_id,String rr_id) throws Exception {

        if(recommendService.RecommendPageInsert(request,rp_id,recf_id,rr_id) == 0) return ResResult.build(200,"插入失败",null);
        else return ResResult.build(400,"插入成功",null);
    }

    @RequestMapping(value = "/ajax.get.resume_entry",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult resume_entry(HttpServletRequest request) throws Exception {
        List<List<Map>> list = recommendService.getRPSelect();
        return ResResult.build(400,"",list);
    }

    @RequestMapping(value = "/ajax.post.resume_entry",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult resume_entry_Insert(String name,String age,String tel,String email,String grt,String major,String abi,String path,String sex,String stu,String deg_id,String uni_id,String jb_id) throws Exception {
        if(recommendService.RecommendPeopleInsert(name,age,tel,email,grt,major,abi,path,sex,stu,deg_id,uni_id,jb_id) == 0) return ResResult.build(200,"插入失败",null);
        else return ResResult.build(400,"ok",null);
    }

    @RequestMapping(value = "/ajax.get.Recruitment_Demand_Page",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult Recruitment_Demand_Page() throws Exception{
        List<Map> list = recommendService.getValidRRDesc();
        return ResResult.build(400,"",list);
    }

    @RequestMapping(value = "/ajax.get.Republish_Demand",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult Republish_Demand() throws Exception {
        List<List<Map>> list = recommendService.getRepublishDemandSelect();
        list.add(recommendService.getValidRR());
        return ResResult.build(400,"",list);
    }

    @RequestMapping(value = "/ajax.post.Republish_Demand",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResResult RePublish_Demand_Update(HttpServletRequest request,String rr_id,String rr_wp_id, String rr_ed_id, String rr_st_id,String rr_ri_id, String rr_sta_id, String rr_num, String rr_el, String rr_ept, String rr_spreq) throws Exception {

        if(recommendService.RRUpdate(request,rr_id,rr_wp_id,rr_ed_id,rr_st_id,rr_ri_id,rr_sta_id,rr_num,rr_el,rr_ept,rr_spreq) == 0) return ResResult.build(200,"更新失败",null);
        else return ResResult.build(400,"更新成功",null);
    }

}
