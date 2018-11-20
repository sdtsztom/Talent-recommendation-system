package ienum;

public enum RStage {
    WAITOFFERCONFIRM;

    @Override
    public String toString() {
        String stage=null;
        switch (this){
            case WAITOFFERCONFIRM:stage="等待offer确认";break;
        }
        return stage;
    }

    public int toInt(){
        int stage=0;
        switch (this){
            case WAITOFFERCONFIRM:stage=4;break;
        }
        return stage;
    }
}
