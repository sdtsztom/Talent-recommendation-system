package MVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {


    @RequestMapping("/Stuff_Recommend_History")
    public String Stuff_Recommend_History() {
        return "/html/Stuff_Recommend_History";
    }

    @RequestMapping("/RP_Detail")
    public String RP_Detail() {
        return "/html/RP_Detail";
    }

    @RequestMapping("/Stuff_Recommend_Page")
    public String Stuff_Recommend_Page() {
        return "/html/Stuff_Recommend_Page";
    }

    @RequestMapping("Stuff_Recommend_Track")
    public String Stuff_Recommend_Track() {
        return "/html/Stuff_Recommend_Track";
    }

    @RequestMapping("resume_entry")
    public String resume_entry() {
        return "/html/resume_entry";
    }

    @RequestMapping("Republish_Demand")
    public String Republish_Demand() {
        return "/html/Republish_Demand";
    }

    @RequestMapping("Recruitment_Demand_Page")
    public String Recruitment_Demand_Page() {
        return "/html/Recruitment_Demand_Page";
    }

    @RequestMapping("Interview_build_page")
    public String Interview_build_page() {
        return "/html/Interview_build_page";
    }

}
