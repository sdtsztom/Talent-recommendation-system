package bean;

import ienum.Arr_result;

public class Arrangement {
    private int id; //注意这是推荐id，而非推荐人id
    private Arr_result result;
    private int rr_id=-1;   //当Arrangement为安排到其它需求时，所提供的需求id

    public Arrangement(int id,Arr_result result){
        this.id=id;
        this.result=result;
    }

    public Arrangement(int id,Arr_result result,int rr_id){
        this.id=id;
        this.result=result;
        this.rr_id=rr_id;
    }

    public int getId() {
        return id;
    }

    public Arr_result getResult() {
        return result;
    }

    public int getRr_id(){return rr_id;}
}
