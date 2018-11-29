package bean;

public class Recruit {
    private int rr_id;
    private int rr_num;
    private String rr_el;
    private String wp_name;
    private String ed_name;

    public Recruit(int rr_id, String ed_name, int rr_num, String wp_name,String rr_el){
        this.ed_name = ed_name;
        this.rr_el = rr_el;
        this.rr_id = rr_id;
        this.rr_num = rr_num;
        this.wp_name = wp_name;
    }

    public int getRr_id() {
        return rr_id;
    }

    public int getRr_num() {
        return rr_num;
    }

    public String getRr_el() {
        return rr_el;
    }

    public String getWp_name() {
        return wp_name;
    }

    public String getEd_name() {
        return ed_name;
    }
}
