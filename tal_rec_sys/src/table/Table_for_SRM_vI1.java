package table;

import ienum.ConnectUser;
import util.CommonConnection;

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
        else if (col==ncols-3)return "<button><a href=\"/recommend_person_details.jsp?rpid="+_getItem(row,0)+"\">查看详细信息</a></button>";
        else if(col==ncols-2){
            boolean itv_exist= CommonConnection.existQuery("select * from interview where itv_rr_id="+rrid+" and itv_rnd=1 and itv_rp_id="+rpid,ConnectUser.SYS);
            if(itv_exist){
                String name="res_"+rec_id;
                return "<input type=\"radio\" name=\""+name+"\" value=\"pass\">通过"+
                        "<input type=\"radio\" name=\""+name+"\" value=\"fail\">不通过";
            }else return "<a href=\"...\">建立面试</a>";
        }
        else if(col==1){
            String other_need_name="id_otherNeed_"+rec_id;
            return "<input type=\"text\" name=\""+other_need_name+"\">";
        }
        else return null;
    }
}
