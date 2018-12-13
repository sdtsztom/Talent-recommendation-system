package ienum;

// 对应的是recommend stage
public enum RStage{
    FINISH,W_SIFT,W_I1,W_I2,W_OC,W_TW,W_ARR_S,W_ARR_I1;

    @Override
    public String toString(){
        String stage=null;
        switch(this){
            case FINISH:{stage="结束";break;}
            case W_SIFT:{stage="等待筛选";break;}
            case W_I1:{stage="等待初轮面试";break;}
            case W_I2:{stage="等待最终面试";break;}
            case W_OC:{stage="等待offer确认";break;}
            case W_TW:{stage="等待入职";break;}
            case W_ARR_S:{stage="等待安排(筛选后)";break;}
        }
        return stage;
    }

    public int toId(){
        int id=-1;
        switch(this){
            case FINISH:{id=1;break;}
            case W_SIFT:{id=2;break;}
            case W_I1:{id=3;break;}
            case W_I2:{id=4;break;}
            case W_OC:{id=5;break;}
            case W_TW:{id=6;break;}
            case W_ARR_S:{id=7;break;}
        }
        return id;
    }

}