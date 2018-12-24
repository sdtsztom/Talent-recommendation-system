package table;

import ienum.ConnectUser;
import util.CommonConnection;
import util.iutil;

public class Table_for_SRM_vI2 extends TableBase{
    private String rrid=null;

    public Table_for_SRM_vI2(){super();}
    public Table_for_SRM_vI2(TableBase table_load,String rrid){ super(table_load);this.rrid=rrid;}
    public Table_for_SRM_vI2(String [][]str_load,String rrid){super(str_load);this.rrid=rrid;}
    public Table_for_SRM_vI2(String query, ConnectUser user, String rrid){ super(query,user);this.rrid=rrid;}

    @Override
    public void makeShape(int data_nrow, int data_ncol) {
        super.makeShape(data_nrow, data_ncol+2);
    }

    @Override
    public String getItem(int row, int col) {
        String rec_id=_getItem(row,0);
        String rpid=_getItem(row,1);

        if(col<ncols-2)return _getItem(row, col);
        else if (col==ncols-2)return "<a href=\"/recommend_person_details.jsp?rpid="+rpid+"\">查看详细信息</a>";
        else if(col==ncols-1){
            boolean itv_exist= CommonConnection.existQuery("select * from interview where itv_rr_id="+rrid+" and itv_rnd=2 and itv_rp_id="+rpid,ConnectUser.SYS);
            if(itv_exist){
                boolean access=CommonConnection.existQuery("select * from interview where itv_rr_id="+rrid+" and itv_rnd=2 and itv_rp_id="+rpid+" and itv_time<="+ iutil.getDate(),ConnectUser.SYS);
                if(access){
                    String arr_name="res_"+rec_id;
                    return "<input type=\"radio\" name=\""+arr_name+"\" value=\"pass\">发放offer"+
                            "<input type=\"radio\" name=\""+arr_name+"\" value=\"fail\">不发放offer";
                }else return "未到安排时间";
            }else return "<a href=\"/Interview_build_page?rr_id=" + _getItem(row,0) +
                    "&rec_rp_id=" + _getItem(row,1) +
                    "&rec_rp_name=" + _getItem(row,2) +
                    "&ip_rnd=1" +
                    "\">建立面试</a>";    //TODO: 建立面试
        }
        else return null;
    }
}
