package email_template;

import ienum.ConnectUser;
import util.CommonConnection;
import util.Config;
import util.MD5;
import util.iutil;

import java.util.Date;

public class Intv2Pass2RpEmailTemplate extends emailTemplateBase{
    private String rpid;
    private String rp_name;
    private String tel_num;
    private String formattedDDL;
    private String sex; //应该为先生或女士

    public Intv2Pass2RpEmailTemplate(String rec_id){
        super();
        String values[]=CommonConnection.singleLineQuery("select rec_rr_id,rec_rp_id from recommend where rec_id="+rec_id,2,ConnectUser.SYS);
        String rrid=values[0];
        this.rpid=values[1];

        //截止日期
        Date DDL=CommonConnection.singleDataQuery("select rr_el from recruitment_requirements where rr_id="+rrid,ConnectUser.SYS);
        this.formattedDDL= iutil.formattedDate(DDL);

        //被推荐人的相关信息
        values=CommonConnection.singleLineQuery("select rp_name,rp_sex,rp_tel_num,rp_email from recommend_people where rp_id="+rpid,4, ConnectUser.SYS);
        this.rp_name=values[0];
        this.tel_num=values[2];
        this.sex=values[1].equals("男")?"先生":"女士";
        setAddrto(values[3]);
    }

    public void setSubject(){
        this.subject="职位发放";
    }

    public void genContent(){
        this.content=rp_name+sex+",恭喜您已经通过了最终面试，我们将对你提供对应职位。\r\n请在"+formattedDDL+"之前点击下方链接选择接受或拒绝offer，逾期将视为自动拒绝offer!\n" +
                "http://"+ Config.getWebServerIp()+":"+Config.getWebServerPort()+"/confirm_offer.jsp?u="+rpid+"&v="+ MD5.encrypt(tel_num);
    }
}
