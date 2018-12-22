package bean;

import Interface.Rs2Bean;
import com.sun.rowset.CachedRowSetImpl;
import ienum.RrStage;

import java.util.Date;

public class Recruit implements Rs2Bean {
    private int rr_id;
    private String jb_name;
    private int rr_num;
    private String wp_name;
    private String ed_name;
    private Date rr_el;
    private RrStage rrStage;

    public int getRr_id() {
        return rr_id;
    }

    public int getRr_num() {
        return rr_num;
    }

    public Date getRr_el() {
        return rr_el;
    }

    public String getJb_name() { return jb_name; }

    public RrStage getRrStage() { return rrStage; }

    public String getWp_name() {
        return wp_name;
    }

    public String getEd_name() {
        return ed_name;
    }

    public void setRrStage(int stage_id) {
        RrStage rrStage_enum=null;
        for(RrStage i:RrStage.values()){
            if(i.toId()==stage_id)rrStage_enum=i;
        }
        this.rrStage = rrStage_enum;
    }

    public Recruit fromRs(CachedRowSetImpl rs){
        Recruit r=new Recruit();
        try{
            r.rr_id=rs.getInt("rr_id");
            r.jb_name=rs.getString("jb_name").trim();
            r.rr_num=rs.getInt("rr_num");
            r.wp_name=rs.getString("wp_name").trim();
            r.rr_el=rs.getDate("rr_el");
            r.ed_name=rs.getString("ed_name").trim();
            r.setRrStage(rs.getInt("rr_sta_id"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }
}
