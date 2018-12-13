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
        super.makeShape(data_nrow, data_ncol+3);    //要增加一个查看简历的列和安排选项列和id选择列
    }

    @Override
    public String getItem(int row, int col) {
        if(col<ncols-3)return _getItem(row, col);
        else if (col==ncols-3)return "<button><a href=\"/recommend_person_details.jsp?rpid="+_getItem(row,0)+"\">查看详细信息</a></button>";
        else if(col==ncols-2){
            String name="arr_"+_getItem(row,0);
            return "<input type=\"radio\" name=\""+name+"\" value=\"itv\">安排面试"+
                    "<input type=\"radio\" name=\""+name+"\" value=\"otherneed\">安排其它需求"+
                    "<input type=\"radio\" name=\""+name+"\" value=\"talents\">放入人才库";
        }
        else if(col==ncols-1)return "<input type=\"text\" name=\"id_otherNeed\">";
        else return null;
    }
}
