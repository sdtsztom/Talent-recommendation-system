package table;

import util.CommonConnection;
import ienum.ConnectUser;
import util.iutil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class TableBase {
    private String [][]str_load=null;
    private TableBase table_load=null;
    private boolean switcher=true;  //开关，true使用str_load，false使用table_load
    private int ncols=0;
    private int nrows=0;
    private String default_table_css="border=1px style=\"border-collapse:collapse;\"";
    private int npage=1;
    private boolean with_order=true;

    public TableBase(TableBase table_load){
        this.receive(table_load);
    }

    public TableBase(String [][]str_load){
        this.receive(str_load);
    }

    public TableBase(String query,ConnectUser user){
        this.receive(query,user);
    }

    public void receive(TableBase table_load){
        this.table_load=table_load;
        switcher=false;
        if(str_load!=null)str_load=null;
        int []s=table_load.shape();
        nrows=s[0];
        ncols=s[1];
    }

    public void receive(String [][]str_load){
        this.str_load=str_load;
        switcher=true;
        if(table_load!=null)table_load=null;
        nrows=str_load.length;
        ncols=str_load[0].length;
    }

    public void setWith_order(boolean with_order){this.with_order=with_order;}

    public void receive(String query, ConnectUser user){
        CommonConnection.setConnectUser(user);
        ResultSet rs=CommonConnection.makeQuery(query);
        String [][]str_data=null;
        try{
            ResultSetMetaData metars=rs.getMetaData();
            int ncols=metars.getColumnCount();
            ArrayList<String []> str_array=new ArrayList<String []>();
            while(rs.next()){
                String []temp=new String[ncols];
                for(int i:iutil.range(ncols))temp[i]=rs.getString(i+1).trim();
                str_array.add(temp);
            }
            rs.close();
            int nrows=str_array.size();
            str_data=new String[nrows][ncols];
            for(int i:iutil.range(nrows))str_data[i]=str_array.get(i);
        }catch(Exception e){
            e.printStackTrace();
        }
        this.receive(str_data);
    }

    public String _getItem(int row,int col){
        if(switcher)return str_load[row][col];
        else return table_load.getItem(row,col);
    }

    // 用来被重写
    public String getItem(int row,int col){
        return this._getItem(row,col);
    }

    public int[] shape(){
        int []s={nrows,ncols};
        return s;
    }

    public String genHTML(String []head,String table_css) {
        String content="";
        if (head == null || head.length != ncols) return null;
        if(head!=null)content+=genLine(true,head,0);
        if(switcher)for(int i:iutil.range(str_load.length))content+=genLine(false,str_load[i],i);
        else for(int i:iutil.range(nrows))content+=genLine(table_load,i);
        return "<table "+table_css+">\n"+content+"</table>\n";
    }

    public String genHTML(String []head){
        return genHTML(head,default_table_css);
    }

    private String genLine(boolean ishead,String []line,int row){
        String content="";
        String starttag=ishead?"<th>":"<td>";
        String endtag=ishead?"</th>":"</td>";
        if(ishead&&with_order)content+="<th>序号</th>";
        if(!ishead&&with_order)content+="<td>"+(row+1)+"</td>";
        for(String i:line){content+=starttag+i+endtag;}
        return "<tr>\n"+content+"\n</tr>\n";
    }

    private String genLine(TableBase table,int row){
        String content="";
        String starttag="<td>";
        String endtag="</td>";
        if(with_order)content+="<td>"+(row+1)+"</td>";
        for(int i: iutil.range(ncols))content+=starttag+table.getItem(row,i)+endtag;
        return "<tr>\n"+content+"\n</tr>\n";
    }
}
