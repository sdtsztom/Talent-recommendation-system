# Project Schedule
|Event|Status|Completion|DDL|Interval/Day|Responsible|
|-----|------|----------|---|------------|-----------|
|demand analysis|Done|-|-|-|-|
|Data Flow Diagram|Done|-|-|-|-|
|UML|Done|-|-|-|-|
|programing start|Done|18/09/25|-|-|-|
|Tables and Pages outline|Done|18/09/25|-|-|Dev Group|
|Internal check on outline|Done|18/09/26|-|-|Dev Group|
|details table draft|Done|18/09/30|-|-|Dev Group|
|mature details table|Done|18/09/30|-|-|Dev Group|
|model design in PowerDesinger|Done|18/10/08|-|-|Dev Group|
|half of pages|Done|18/11/18|18/11/18|-|Dev Group|
|Workflow backend|Undone|-|18/11/25|6|Dev Group|
|assemble Workflow backend and pages|Undone|-|18/11/30|5|Dev Group|
|the other half of pages|Undone|-|18/12/9|9|Dev Group|
|assemble&perfection|Undone|-|18/12/14|5|Dev Group|
|reserve time|Undone|-|18/12/21|7|Dev Group|
|beautify|Undone|-|18/12/28|7|-|
|program test|Undone|-|18/12/28|7|-|
|document|Undone|-|18/12/28|7|-|

## Frontend:Pages
|Main pages|Responsible|Status|Completion|DDL|function description|
|----------|-----------|------|----------|---|--------------------|
|view_points|tsz|Done|18/10/29|-|查询积分|
|confirm_offer|tsz|Done|18/10/29|-|入职确认|
|register|tsz|Done|18/10/30|-|新员工注册|
|recommend_person_details|tsz|Done|18/11/15|-|被推荐人详细信息|
|Single_Rec_vOpen|tsz|Undone|-|18/12/09|需求管理(HR/OPEN)|
|Single_Rec_vSift|tsz|Undone|-|18/12/09|需求管理(HR/Sift)|
|Single_Rec_vSift_Arr|tsz|Undone|-|18/12/09|需求管理(HR/Arrangement after Sift)|
|Single_Rec_vIntv1|tsz|Undone|-|18/12/10|需求管理(HR/Interview1)|
|Single_Rec_vIntv1_Arr|tsz|Undone|-|18/12/10|需求管理(HR/Arrangement after Interview1)|
|Single_Rec_vIntv2|tsz|Undone|-|18/12/10|需求管理(HR/Interview2)|
|Single_Rec_vIntv2_Arr|tsz|Undone|-|18/12/10|需求管理(HR/Arrangement after Interview2)|
|Single_Rec_vWait|tsz|Undone|-|18/12/14|需求管理(HR/Wait for Confirm)|
|Single_Rec_vFinish|tsz|Undone|-|18/12/14|需求管理(HR/Finish)|
|login|a10442|Done|18/10/14|-|登陆页面|
|Admin_function|a10442|Done|18/10/15|-|功能选择(Admin Version)|
|Stuff_function|a10442|Done|18/10/15|-|功能选择(Stuff Version)|
|HR_function|a10442|Done|18/10/15|-|功能选择(HR Version)|
|Query_Recruit|a10442|Done|18/10/29|-|需求查询|
|Query_Recruit_HR|a10442|Done|18/10/29|-|需求查询(HR Version)|
|Recruit_Detail|a10442|Undone|-|18/12/10|需求详情|
|Recruit_Detail_HR|a10442|Undone|-|18/12/10|需求详情(HR Version)|
|Publish_Recruit|a10442|Undone|-|18/12/14|发布需求(Chose job)|
|Publish_Recruit|a10442|Undone|-|18/12/14|发布需求(Details)|
|Interview_build_page|xsy|Undone|-|18/12/14|创建面试|
|Recruit_Detail_Admin|xsy|Undone|-|18/12/14|被推荐人信息查询|
|Recruitmentment_Demand_Page|xsy|Undone|-|18/12/14|招聘需求大厅|
|Republicsh_Demand|xsy|Undone|-|18/12/14|重新分配招聘需求|
|resume_entry|xsy|Undone|-|18/12/14|录入简历页面|
|Stuff_Recommend_History|xsy|Undone|-|18/12/14|员工推荐历史|
|Stuff_Recommend_Page|xsy|Undone|-|18/12/14|员工推荐人员|
|Stuff_Recommend_Track|xsy|Undone|-|18/12/14|员工推荐情况追踪|

## Backend:Workflow Java Classes
<table>
    <tr>
        <th>Process</th>  <th>Subtasks</th>  <th>Java Classes</th>
        <th>Func_name</th>  <th>Status</th>  <th>Responsible</th>
        <th>Completion</th>
    </tr>
    <!--               Process1: Post Recruitment Needs                     -->
    <tr>
        <td rowspan="2">Post Recruitment Needs</td>  <td>数据录入</td>  <td rowspan="2">Tsk_post_need</td>
        <td>record_needs</td>  <td>Undone</td>  <td>cwj</td>
        <td>-</td>
    </tr>
    <tr>
        <td>邮件通知(only urgent)</td>  
        <td>notify_urgent</td>  <td>Undone</td>  <td>cwj</td>
        <td>-</td>
    </tr>
    <!--                        Process2: RecommendB                    -->
    <tr>
        <td rowspan="5">Recommend</td>  <td>情形选择</td>  <td rowspan="5">Tsk_recommend</td>
        <td>case_switch</td>  <td>Undone</td>  <td>cwj</td>
        <td>-</td>
    </tr>
    <tr>
        <td>需求更新</td>
        <td>update_need</td>  <td>Undone</td>  <td>cwj</td>
        <td>-</td>
    </tr>
    <tr>
        <td>录入人才信息</td>
        <td>record_rp</td>  <td>Undone</td>  <td>cwj</td>
        <td>-</td>
    </tr>
    <tr>
        <td>邮件提醒</td>
        <td>notify</td>  <td>Undone</td>  <td>cwj</td>
        <td>-</td>
    </tr>
    <tr>
        <td>关闭招聘需求</td>
        <td>close_need</td>  <td>Undone</td>  <td>cwj</td>
        <td>-</td>
    </tr>
    <!--                  Process3: Sift                      -->
    <tr>
        <td rowspan="3">Sift</td>  <td>记录筛选结果</td>  <td rowspan="3">Tsk_sift</td>
        <td>record_sift_res</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>
    <tr>
        <td>积分奖励发放</td>
        <td>deal_points</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>    
    <tr>
        <td>结束判断</td>
        <td>isFinish</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>
    <!--                Process4: Arrangement After Sift                  -->
    <tr>
        <td rowspan="6">Arrangement After Sift</td>  <td>情形选择</td>  <td rowspan="6">Tsk_Arr</td>
        <td>case_switch</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>
    <tr>
        <td>安排面试</td>
        <td>to_Intv</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>
    <tr>
        <td>安排其它需求</td>
        <td>to_other_need</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>
    <tr>
        <td>放入人才库</td>
        <td>to_talent</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>
    <tr>
        <td>邮件提醒</td>
        <td>notify</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>
    <tr>
        <td>结束判断</td>
        <td>isFinish</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>
    <!--                Process5: Interview1                     -->
    <tr>
        <td rowspan="3">Interview 1</td>  <td>记录面试结果</td>  <td rowspan="3">Tsk_Intv1</td>
        <td>record_Intv1_res</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>
    <tr>
        <td>积分奖励发放</td>
        <td>deal_points</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>    
    <tr>
        <td>结束判断</td>
        <td>isFinish</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>
    <!--              Process6: Arrangement After Interview 1            -->
    <tr>
        <td >Arrangement After Interview 1</td>  <td colspan="3">REUSE Tsk_Arr</td>
        <td>Undone</td> <td>tsz</td> <td>-</td>
    </tr>
    <!--                Process7: Interview2                     -->
    <tr>
        <td rowspan="4">Interview 2</td>  <td>记录面试结果</td>  <td rowspan="4">Tsk_Intv2</td>
        <td>record_Intv2_res</td>  <td>Undone</td>  <td>xsy</td>
        <td>-</td>
    </tr>
    <tr>
        <td>积分奖励发放</td>
        <td>deal_points</td>  <td>Undone</td>  <td>xsy</td>
        <td>-</td>
    </tr>
    <tr>
        <td>邮件提醒</td>
        <td>notify</td>  <td>Undone</td>  <td>xsy</td>
        <td>-</td>
    </tr>
    <tr>
        <td>结束判断</td>
        <td>isFinish</td>  <td>Undone</td>  <td>tsz</td>
        <td>-</td>
    </tr>
    <!--                Process7: Offer Confirm                    -->
    <tr>
        <td rowspan="5">Offer Confirm</td>  <td>记录结果</td>  <td rowspan="5">Tsk_offer_confirm</td>
        <td>record</td>  <td>Undone</td>  <td>xsy</td>
        <td>-</td>
    </tr>
    <tr>
        <td>情形选择</td>
        <td>case_switch</td>  <td>Undone</td>  <td>xsy</td>
        <td>-</td>
    </tr>
    <tr>
        <td>新员工注册</td>
        <td>register_new_stuff</td>  <td>Undone</td>  <td>xsy</td>
        <td>-</td>
    </tr>
    <tr>
        <td>邮件提醒</td>
        <td>notify</td>  <td>Undone</td>  <td>xsy</td>
        <td>-</td>
    </tr>
    <tr>
        <td>积分奖励发放</td>
        <td>deal_points</td>  <td>Undone</td>  <td>xsy</td>
        <td>-</td>
    </tr>
</table>

- PS:DDL of all these task classes is 18/11/25