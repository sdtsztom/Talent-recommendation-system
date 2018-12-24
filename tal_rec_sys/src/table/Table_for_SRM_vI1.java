package table;

import bean.LoginUser;
import ienum.ConnectUser;
import util.CommonConnection;
import util.iutil;


public class Table_for_SRM_vI1 extends TableBase{
    private String rrid=null;

    public Table_for_SRM_vI1(){super();}
    public Table_for_SRM_vI1(TableBase table_load,String rrid){ super(table_load);this.rrid=rrid;}
    public Table_for_SRM_vI1(String [][]str_load,String rrid){super(str_load);this.rrid=rrid;}
    public Table_for_SRM_vI1(String query, ConnectUser user,String rrid){ super(query,user);this.rrid=rrid;}

    @Override
    public void makeShape(int data_nrow, int data_ncol) {
        super.makeShape(data_nrow, data_ncol+3);
    }

    @Override
    public String getItem(int row, int col) {
        String rec_id=_getItem(row,0);
        String rpid=_getItem(row,1);

        if(col<ncols-3)return _getItem(row, col);
        else if (col==ncols-3)return "<a href=\"/recommend_person_details.jsp?rpid="+rpid+"\">查看详细信息</a>";
        else if(col==ncols-2){
            boolean itv_exist= CommonConnection.existQuery("select * from interview where itv_rr_id="+rrid+" and itv_rnd=1 and itv_rp_id="+rpid,ConnectUser.SYS);
            if(itv_exist){
                //TODO 每次都查询，效率需要改善
                boolean access=CommonConnection.existQuery("select * from interview where itv_rr_id="+rrid+" and itv_rnd=1 and itv_rp_id="+rpid+" and itv_time<="+ iutil.getDate(),ConnectUser.SYS);
                if(access){
                    String arr_name="arr_"+rec_id;
                    return "<input type=\"radio\" name=\""+arr_name+"\" value=\"itv\">下一轮面试"+
                            "<input type=\"radio\" name=\""+arr_name+"\" value=\"otherneed\">安排其它需求"+
                            "<input type=\"radio\" name=\""+arr_name+"\" value=\"talents\">放入人才库";
                }else return "未到安排时间";
            }else return "<a href=\"/Interview_build_page?rr_id=" + _getItem(row,0) +
                    "&rec_rp_id=" + _getItem(row,1) +
                    "&rec_rp_name=" + _getItem(row,2) +
                    "&ip_rnd=1" +
                    "\">建立面试</a>";    //TODO: 建立面试
        }
        else if(col==ncols-1){
            String other_need_name="id_otherNeed_"+rec_id;
            return "<input type=\"text\" name=\""+other_need_name+"\" style=\"display:none\">";
        }
        else return null;
    }
}
