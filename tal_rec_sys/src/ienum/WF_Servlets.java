package ienum;

public enum WF_Servlets {
    OPEN2SIFT,SIFT,SIFTARR,INTV1,INTV2,OC;

    @Override
    public String toString() {
        String page="/Packer4WF/";
        switch (this){
            case OPEN2SIFT:{page+="Open2Sift";break;}
            case SIFT:{page+="Sift";break;}
            case SIFTARR:{page+="SiftArr";break;}
            case INTV1:{page+="Intv1";break;}
            case INTV2:{page+="Intv2";break;}
            case OC:{page+="OfferConfirm";break;}
        }
        return page;
    }
}
