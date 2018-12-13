package bean;

import ienum.Arr_result;

public class Arrangement {
    private int rec_id; //注意这是推荐id，而非推荐人id
    private Arr_result result;
    private int rr_id_of_otherNeed =-1;   //当Arrangement为安排到其它需求时，所提供的需求id

    public Arrangement(int rec_id, Arr_result result){
        this.rec_id = rec_id;
        this.result=result;
    }

    public Arrangement(int rec_id, Arr_result result, int rr_id_of_otherNeed){
        //当安排是推荐到其它需求时使用此方法初始化
        this.rec_id = rec_id;
        this.result=result;
        this.rr_id_of_otherNeed = rr_id_of_otherNeed;
    }

    public int getRec_id() {
        return rec_id;
    }

    public Arr_result getResult() {
        return result;
    }

    public int getRr_id_of_otherNeed(){return rr_id_of_otherNeed;}
}
