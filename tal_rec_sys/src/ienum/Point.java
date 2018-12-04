package ienum;

public enum Point {
    FINALINTERVIEW,FILTER,FIRSTINTERVIEW,ENTRY;

    @Override
    public String toString() {
        String PointChangeRule = null;
        switch (this) {
            case FINALINTERVIEW: PointChangeRule = "3";
            case FILTER: PointChangeRule = "1";
            case ENTRY: PointChangeRule = "4";
            case FIRSTINTERVIEW: PointChangeRule = "2";
        }
        return PointChangeRule;
    }
}
