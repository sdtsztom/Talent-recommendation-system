package ienum;

public enum RrStage {
    OPEN,FINISH;

    @Override
    public String toString() {
        String stage=null;
        switch (this){
            case FINISH:stage="结束";break;
            case OPEN:stage="开放";break;
        }
        return stage;
    }

    public static RrStage fromStr(String stage){
        RrStage enum_stage=null;
        for(RrStage i:RrStage.values()){if(i.toString().equals(stage))enum_stage=i;}
        return enum_stage;
    }
}
