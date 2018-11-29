package ienum;

public enum eErrorPage {
    PERMISSIONDENY,NOCORRESPONDINGRECORD,NOTMATCHEDSTAGE,RECOMMENDEDPERSONNOTVALID,NOTHISREQUIREMENT;

    @Override
    public String toString() {
        String page_uri=null;
        switch (this){
            case PERMISSIONDENY:page_uri="/ErrorPage/PermissionDeny.jsp";break;
            case NOCORRESPONDINGRECORD:page_uri="/ErrorPage/NoCorrespondingRecord.jsp";break;
            case NOTMATCHEDSTAGE:page_uri="/ErrorPage/NotMatchedStage.jsp";break;
            case RECOMMENDEDPERSONNOTVALID:page_uri="/ErrorPage/RecommendedPersionNotValid.jsp";break;
            case NOTHISREQUIREMENT:page_uri="/ErrorPage/NoThisRequirement.jsp";break;
        }
        return page_uri;
    }
}
