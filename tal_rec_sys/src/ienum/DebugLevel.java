package ienum;

public enum DebugLevel {
    VERBOSE,DEBUG,WARNING,ERROR;


    @Override
    public String toString() {
        String level=null;
        switch (this){
            case VERBOSE:level="[VERBOSE]";break;
            case DEBUG:level="[DEBUG]";break;
            case WARNING:level="[WARNING]";break;
            case ERROR:level="[ERROR]";break;
        }
        return level;
    }
}
