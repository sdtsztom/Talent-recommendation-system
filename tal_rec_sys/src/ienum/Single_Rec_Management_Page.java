package ienum;

public enum Single_Rec_Management_Page {
    OPEN;

    @Override
    public String toString() {
        String page_name=null;
        switch (this){
            case OPEN:page_name="Single_Rec_vOpen.jsp";break;
        }
        return page_name;
    }

    public static Single_Rec_Management_Page convert(RrStage stage){
        Single_Rec_Management_Page convertedPage=null;
        switch (stage){
            case OPEN:convertedPage=OPEN;break;
        }
        return convertedPage;
    }
}
