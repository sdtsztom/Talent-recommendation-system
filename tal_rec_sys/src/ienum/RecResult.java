package ienum;

// 用于代表追踪的最终的安排结果

public enum RecResult {
    TALENTS,OTHERNEED,NOOFFER,REFUSE,TAKE,NONE,OVERTIME;

    @Override
    public String toString(){
        String s=null;
        switch(this){
            case TALENTS:{s="放入人才库";break;}
            case OTHERNEED:{s="安排其它需求";break;}
            case NOOFFER:{s="不发放offer";break;}
            case REFUSE:{s="拒绝offer";break;}
            case TAKE:{s="接受offer并入职";break;}
            case NONE:{s="暂无";break;}
            case OVERTIME:{s="确认超时";break;}
        }
        return s;
    }

    public int toId(){
        int id=-1;
        switch(this){
            case TALENTS:{id=1;break;}
            case OTHERNEED:{id=2;break;}
            case NOOFFER:{id=3;break;}
            case REFUSE:{id=4;break;}
            case TAKE:{id=5;break;}
            case NONE:{id=6;break;}
            case OVERTIME:{id=7;break;}
        }
        return id;
    }

}