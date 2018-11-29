package ienum;

// 对应的是recruitment requirement stage

public enum RrStage{
    FINISH,OPEN,CLOSE_T,W_SIFT,W_ARR_S,W_I1,W_ARR_I1,W_I2,W_OC,W_TW;

    @Override
    public String toString(){
        String s=null;
        switch(this){
            case FINISH:{s="结束";break;}
            case OPEN:{s="开放";break;}
            case CLOSE_T:{s="暂时关闭";break;}
            case W_SIFT:{s="等待筛选";break;}
            case W_ARR_S:{s="等待安排(筛选后)";break;}
            case W_I1:{s="等待初轮面试";break;}
            case W_ARR_I1:{s="等待安排(初轮面试后)";break;}
            case W_I2:{s="等待最终面试";break;}
            case W_OC:{s="等待offer确认";break;}
            case W_TW:{s="等待入职";break;}
        }
        return s;
    }

    public int toId(){
        int id=-1;
        switch(this){
            case FINISH:{id=1;break;}
            case OPEN:{id=2;break;}
            case CLOSE_T:{id=3;break;}
            case W_SIFT:{id=4;break;}
            case W_ARR_S:{id=5;break;}
            case W_I1:{id=6;break;}
            case W_ARR_I1:{id=7;break;}
            case W_I2:{id=8;break;}
            case W_OC:{id=9;break;}
            case W_TW:{id=10;break;}
        }
        return id;
    }

}