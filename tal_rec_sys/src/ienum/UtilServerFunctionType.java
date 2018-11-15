package ienum;

public enum UtilServerFunctionType {
    CHECKDUPUSERNAME;

    @Override
    public String toString() {
        String type=null;
        switch (this){
            case CHECKDUPUSERNAME:type="check_dup_username";break;
        }
        return type;
    }
}
