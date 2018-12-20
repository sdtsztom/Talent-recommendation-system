package email_template;

import ienum.Arr_result;
import ienum.ConnectUser;
import util.CommonConnection;

public class SiftArrEmailTemplate extends emailTemplateBase {
    private String rp_name;
    private String Arr;

    public SiftArrEmailTemplate(String rec_id, Arr_result arr){
        super();
        String []values= CommonConnection.singleLineQuery("select rp_name,recstu_email from recommend_notify where rec_id="+rec_id,2, ConnectUser.SYS);
        setAddrto(values[1]);
        this.rp_name=values[0];
        switch (arr){
            case INTERVIEW:{Arr="安排面试";break;}
            case TALENTS:{Arr="放入人才库";break;}
            case OTHERNEED:{Arr="安排其它需求";break;}
        }
    }

    public void setSubject(){
        this.subject="通过筛选";
    }

    public void genContent(){
        this.content="您推荐的\""+rp_name+"\"已经通过了筛选，积分已经奖励至你的账户。<br/><br/>我们对被推荐人做出了\""+
                Arr+"\"的安排决定，感谢您的推荐！";
    }
}
