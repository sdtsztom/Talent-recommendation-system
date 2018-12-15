package email_template;

import ienum.ConnectUser;
import util.CommonConnection;
import util.Config;
import util.MD5;

public class Intv2Pass2RpEmailTemplate extends emailTemplateBase{
    private String rpid;
    private String rp_name;
    private String tel_num;
    private String formattedDDL;
    private String sex; //应该为先生或女士

    public Intv2Pass2RpEmailTemplate(String addrto, String rpid, String formattedDDL){
        super(addrto);
        String values[]=CommonConnection.singleLineQuery("select rp_name,rp_sex,rp_tel_num from recommend_people where rp_id="+rpid,2, ConnectUser.SYS);
        this.rpid=rpid;
        this.rp_name=values[0];
        this.tel_num=values[2];
        this.formattedDDL=formattedDDL;
        this.sex=values[1].equals("男")?"先生":"女士";
    }

    public void setSubject(){
        this.subject="职位发放";
    }

    public void genContent(){
        this.content=rp_name+sex+",恭喜您已经通过了最终面试，我们将对你提供对应职位。请在"+formattedDDL+"之前点击下方链接选择接受或拒绝offer，逾期将视为自动拒绝offer!\n" +
                "http://"+ Config.getWebServerIp()+":"+Config.getWebServerPort()+"/confirm_offer.jsp?u="+rpid+"&v="+ MD5.encrypt(tel_num);
    }
}
