package table;

import ienum.ConnectUser;

public class Table_for_SRM_vSift extends TableBase {

    public Table_for_SRM_vSift(){super();}
    public Table_for_SRM_vSift(TableBase table_load){ super(table_load);}
    public Table_for_SRM_vSift(String [][]str_load){super(str_load);}
    public Table_for_SRM_vSift(String query, ConnectUser user)throws Exception{
        super(query,user);
    }

    @Override
    public void makeShape(int data_nrow, int data_ncol) {
        super.makeShape(data_nrow, data_ncol+2);
    }

    @Override
    public String getItem(int row, int col) {
        String rpid=_getItem(row,1);

        if(col<ncols-2)return _getItem(row, col);
        else if (col==ncols-2)return "<a href=\"/recommend_person_details.jsp?rpid="+rpid+"\">查看详细信息</a>";
        else if(col==ncols-1){
            String name="res_"+_getItem(row,0);
            return "<input type=\"radio\" name=\""+name+"\" value=\"pass\">通过"+
                    "<input type=\"radio\" name=\""+name+"\" value=\"fail\">不通过";
        }
        else return null;
    }
}
