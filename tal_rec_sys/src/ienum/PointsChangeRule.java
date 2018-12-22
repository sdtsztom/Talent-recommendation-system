package ienum;

public enum PointsChangeRule{
    PASS_SIFT,PASS_I1,PASS_I2,TW;

    @Override
    public String toString(){
        String s=null;
        switch(this){
            case PASS_SIFT:{s="通过筛选加分";break;}
            case PASS_I1:{s="通过初次面试等待终面";break;}
            case PASS_I2:{s="通过终面";break;}
            case TW:{s="入职";break;}
        }
        return s;
    }

    public int toId(){
        int id=-1;
        switch(this){
            case PASS_SIFT:{id=1;break;}
            case PASS_I1:{id=2;break;}
            case PASS_I2:{id=3;break;}
            case TW:{id=4;break;}
        }
        return id;
    }

    public int toPoints(){
        int points=-1;
        switch(this){
            case PASS_SIFT:{points=1;break;}
            case PASS_I1:{points=2;break;}
            case PASS_I2:{points=2;break;}
            case TW:{points=2;break;}
        }
        return points;
    }
}