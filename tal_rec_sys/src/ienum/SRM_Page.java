package ienum;

public enum SRM_Page {
    OPEN,W_SIFT,W_ARR_S,W_I1,W_I2,W_OC,W_TW;

    @Override
    public String toString() {
        String page_name=null;
        switch (this){
            case OPEN:page_name="/SRMPages/Single_Rec_vOpen.jsp";break;
            case W_SIFT:page_name="/SRMPages/Single_Rec_vSift.jsp";break;
            case W_ARR_S:page_name="/SRMPages/Single_Rec_vSift_Arr.jsp";break;
            case W_I1:page_name="/SRMPages/Single_Rec_vIntv1.jsp";break;
            case W_I2:page_name="/SRMPages/Single_Rec_vIntv2.jsp";break;
            case W_OC:page_name="/SRMPages/Single_Rec_vOC.jsp";break;
            //case W_TW:page_name="/SRMPages/Single_Rec_vTW.jsp";break;
        }
        return page_name;
    }

    public static SRM_Page convert(RrStage stage){
        SRM_Page convertedPage=null;
        switch (stage){
            case OPEN:convertedPage=OPEN;break;
            case W_SIFT:convertedPage=W_SIFT;break;
            case W_ARR_S:convertedPage=W_ARR_S;break;
            case W_I1:convertedPage=W_I1;break;
            case W_I2:convertedPage=W_I2;break;
            case W_OC:convertedPage=W_OC;break;
            //case W_TW:convertedPage=W_TW;break;
        }
        return convertedPage;
    }
}
