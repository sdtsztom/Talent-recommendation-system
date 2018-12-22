package table;

import ienum.ConnectUser;

public class Table_for_SRM_vSift_Arr extends TableBase {

    public Table_for_SRM_vSift_Arr(){super();}
    public Table_for_SRM_vSift_Arr(TableBase table_load){ super(table_load);}
    public Table_for_SRM_vSift_Arr(String [][]str_load){super(str_load);}
    public Table_for_SRM_vSift_Arr(String query, ConnectUser user){
        super(query,user);
    }

    @Override
    public void makeShape(int data_nrow, int data_ncol) {
        super.makeShape(data_nrow, data_ncol+3);
    }

    @Override
    public String getItem(int row, int col) {
        String rpid=_getItem(row,1);
        String rec_id=_getItem(row,0);

        if(col<ncols-3)return _getItem(row, col);
        else if (col==ncols-3)return "<a href=\"/recommend_person_details.jsp?rpid="+rpid+"\">查看详细信息</a>";
        else if(col==ncols-2){
            String arr_name="arr_"+rec_id;
            return "<input type=\"radio\" name=\""+arr_name+"\" value=\"itv\">安排面试"+
                    "<input type=\"radio\" name=\""+arr_name+"\" value=\"otherneed\">安排其它需求"+
                    "<input type=\"radio\" name=\""+arr_name+"\" value=\"talents\">放入人才库";
        }
        else if(col==ncols-1){
            String other_need_name="id_otherNeed_"+rec_id;
            return "<input type=\"text\" name=\""+other_need_name+"\" style=\"display:none\">";
        }
        else return null;
    }
}
