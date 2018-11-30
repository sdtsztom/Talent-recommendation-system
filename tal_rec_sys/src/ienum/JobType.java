package ienum;

public enum JobType {
    STUFF,HR,ADMIN;

    @Override
    public String toString() {
        String type=null;
        switch(this){
            case STUFF:type="开发人员";break;
            case HR:type="人事人员";break;
            case ADMIN:type="管理人员";break;
        }
        return type;
    }

    public int toId() {
        int type=-1;
        switch(this){
            case STUFF:type=1;break;
            case HR:type=2;break;
            case ADMIN:type=3;break;
        }
        return type;
    }
}
