package bean;

import ienum.Arr_result;

public class Arrangement {
    private String rec_id; //注意这是推荐id，而非推荐人id
    private Arr_result result;
    private String rr_id_of_otherNeed =null;   //当Arrangement为安排到其它需求时，所提供的需求id

    public Arrangement(){}

    public Arrangement(String rec_id, Arr_result result){
        this.rec_id = rec_id;
        this.result=result;
    }

    public Arrangement(String rec_id, Arr_result result, String rr_id_of_otherNeed){
        //当安排是推荐到其它需求时使用此方法初始化
        this.rec_id = rec_id;
        this.result=result;
        this.rr_id_of_otherNeed = rr_id_of_otherNeed;
    }

    public String getRec_id() {
        return rec_id;
    }

    public Arr_result getResult() {
        return result;
    }

    public String getRr_id_of_otherNeed(){return rr_id_of_otherNeed;}

    public void setRec_id(String rec_id) {
        this.rec_id = rec_id;
    }

    public void setResult(Arr_result result) {
        this.result = result;
    }

    public void setRr_id_of_otherNeed(String rr_id_of_otherNeed) {
        this.rr_id_of_otherNeed = rr_id_of_otherNeed;
    }
}
