package ienum;

public enum TalentsFrom{
    BF_SIFT,AFT_SIFT,AFT_I1;

    @Override
    public String toString(){
        String s=null;
        switch(this){
            case BF_SIFT:{s="未通过筛选放入";break;}
            case AFT_SIFT:{s="通过筛选后放入";break;}
            case AFT_I1:{s="通过初级面试后放入";break;}
        }
        return s;
    }

    public int toId(){
        int id=-1;
        switch(this){
            case BF_SIFT:{id=1;break;}
            case AFT_SIFT:{id=2;break;}
            case AFT_I1:{id=3;break;}
        }
        return id;
    }

}