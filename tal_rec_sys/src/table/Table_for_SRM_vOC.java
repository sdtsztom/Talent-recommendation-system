package table;

import ienum.ConnectUser;
import util.CommonConnection;
import util.iutil;

public class Table_for_SRM_vOC extends TableBase {
    private String rrid=null;

    public Table_for_SRM_vOC(){super();}
    public Table_for_SRM_vOC(TableBase table_load,String rrid){ super(table_load);this.rrid=rrid;}
    public Table_for_SRM_vOC(String [][]str_load,String rrid){super(str_load);this.rrid=rrid;}
    public Table_for_SRM_vOC(String query, ConnectUser user, String rrid)throws Exception{ super(query,user);this.rrid=rrid;}

    @Override
    public void makeShape(int data_nrow, int data_ncol) {
        super.makeShape(data_nrow, data_ncol+1);
    }

    @Override
    public String getItem(int row, int col) {
        String rpid=_getItem(row,1);

        if(col<ncols-1)return _getItem(row, col);
        else if (col==ncols-1)return "<a href=\"/recommend_person_details.jsp?rpid="+rpid+"\">查看详细信息</a>";
        else return null;
    }
}
