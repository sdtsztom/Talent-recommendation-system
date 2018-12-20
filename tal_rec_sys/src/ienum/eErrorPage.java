package ienum;

public enum eErrorPage {
    PERMISSIONDENY,NOCORRESPONDINGRECORD,NOTMATCHEDSTAGE,RECOMMENDEDPERSONNOTVALID,NOTHISREQUIREMENT,NORECORDYET;

    @Override
    public String toString() {
        String page_uri=null;
        switch (this){
            case PERMISSIONDENY:page_uri="/ErrorPage/PermissionDeny.jsp";break;
            case NOCORRESPONDINGRECORD:page_uri="/ErrorPage/NoCorrespondingRecord.jsp";break;
            case NOTMATCHEDSTAGE:page_uri="/ErrorPage/NotMatchedStage.jsp";break;
            case RECOMMENDEDPERSONNOTVALID:page_uri="/ErrorPage/RecommendedPersionNotValid.jsp";break;
            case NOTHISREQUIREMENT:page_uri="/ErrorPage/NoThisRequirement.jsp";break;
            case NORECORDYET:page_uri="/ErrorPage/NoRecordYet.jsp";break;
        }
        return page_uri;
    }
}
