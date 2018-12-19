package table;

import ienum.ConnectUser;

public class Table_for_SRM_vOpen extends TableBase{

    public Table_for_SRM_vOpen(){super();}
    public Table_for_SRM_vOpen(TableBase table_load){
        super(table_load);
    }
    public Table_for_SRM_vOpen(String [][]str_load){
        super(str_load);
    }
    public Table_for_SRM_vOpen(String query, ConnectUser user){
        super(query,user);
    }

    @Override
    public void makeShape(int data_nrow, int data_ncol) {
        super.makeShape(data_nrow, data_ncol+1);    //要增加一个查看简历的列
    }

    @Override
    public String getItem(int row, int col) {
        if(col!=ncols-1)return _getItem(row, col);
        else return "<a href=\"/recommend_person_details.jsp?rpid="+_getItem(row,1)+"\">查看详细信息</a>";
    }
}
