package bean;

import Interface.Bean2LineContent;
import Interface.Rs2Bean;
import com.sun.rowset.CachedRowSetImpl;

public class RP_Details implements Rs2Bean, Bean2LineContent {
    String rpid;
    String name;
    String age;
    String sex;
    String tel_num;
    String email;
    String job;
    String deg;
    String uni;
    String stu;
    String grt;
    String maj;
    String abi;
    String cv_path;

    @Override
    public RP_Details fromRs(CachedRowSetImpl rs) {
        RP_Details rp_details_temp=new RP_Details();
        try {
            rp_details_temp.rpid=rs.getString("rp_id");
            rp_details_temp.name = rs.getString("rp_name");
            rp_details_temp.age = rs.getString("rp_age");
            rp_details_temp.sex = rs.getString("rp_sex");
            rp_details_temp.tel_num = rs.getString("rp_tel_num");
            rp_details_temp.email = rs.getString("rp_email");
            rp_details_temp.job = rs.getString("rp_job");
            rp_details_temp.deg = rs.getString("rp_deg_name");
            rp_details_temp.uni = rs.getString("rp_uni_name");
            rp_details_temp.stu = rs.getString("rp_stu");
            rp_details_temp.grt = rs.getString("rp_grt");
            rp_details_temp.maj = rs.getString("rp_maj");
            rp_details_temp.abi = rs.getString("rp_abi");
            rp_details_temp.cv_path = rs.getString("rp_res_path");
        }catch (Exception e){
            e.printStackTrace();
        }
        return rp_details_temp;
    }

    @Override
    public String[] Convert2LineContent() {
        return new String[]{rpid,name,age,sex,tel_num,email,job,deg,uni,stu,grt,maj,abi};
    }
}
