package MVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {


    @RequestMapping("/Stuff_Recommend_History")
    public String Stuff_Recommend_History() {
        return "/html/Stuff_Recommend_History.html";
    }

    @RequestMapping("/RP_Detail")
    public String RP_Detail() {
        return "/html/RP_Detail.html";
    }

    @RequestMapping("/Stuff_Recommend_Page")
    public String Stuff_Recommend_Page() {
        return "/html/Stuff_Recommend_Page.html";
    }

    @RequestMapping("Stuff_Recommend_Track")
    public String Stuff_Recommend_Track() {
        return "/html/Stuff_Recommend_Track.html";
    }

    @RequestMapping("resume_entry")
    public String resume_entry() {
        return "/html/resume_entry.html";
    }

    @RequestMapping("Republish_Demand")
    public String Republish_Demand() {
        return "/html/Republish_Demand.html";
    }

    @RequestMapping("Recruitment_Demand_Page")
    public String Recruitment_Demand_Page() {
        return "/html/Recruitment_Demand_Page.html";
    }

    @RequestMapping("Interview_build_page")
    public String Interview_build_page() {
        return "/html/Interview_build_page.html";
    }

}
