package table;

import util.CommonConnection;
import ienum.ConnectUser;
import util.iutil;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class TableBase {
     String [][]str_load=null;
     TableBase table_load=null;
     boolean switcher=true;  //开关，true使用str_load，false使用table_load
     int nrows=0;
     int ncols=0;
     String default_table_css="border=1px style=\"border-collapse:collapse;\"";
     int npage=1;
     boolean with_order=true;

    public TableBase(){};
    
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
        makeShape(s[0],s[1]);
    }

    public void receive(String [][]str_load){
        this.str_load=str_load;
        switcher=true;
        if(table_load!=null)table_load=null;
        makeShape(str_load.length,str_load[0].length);
    }

    public void setWith_order(boolean with_order){this.with_order=with_order;}

    public void receive(String query, ConnectUser user){
        CachedRowSetImpl rs=CommonConnection.makeQuery(query,user);
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

    public String genHTML(String []head){
        return genHTML(head,default_table_css);
    }

    public String genHTML(String []head,String table_css) {
        // if you don't need head,pass null
        String content="";
        if (head!=null&&head.length != ncols) return null;
        if(head!=null)content+=genHead(head);
        for(int i:iutil.range(nrows))content+=genLine(i);
        return "<table "+table_css+">\n"+content+"</table>\n";
    }

    public String genHead(String []head){
        String content="";
        if(with_order)content+="<th>序号</th>";
        for(String i:head){content+="<th>"+i+"</th>";}
        return "<tr>\n"+content+"\n</tr>\n";
    }

    public String genLine(int row){
        String content="";
        if(with_order)content+="<td>"+(row+1)+"</td>";
        for(int i: iutil.range(ncols))content+="<td>"+getItem(row,i)+"</td>";
        return "<tr>\n"+content+"\n</tr>\n";
    }
    
    public void makeShape(int data_nrow,int data_ncol){
        this.nrows=data_nrow;
        this.ncols=data_ncol;
    }
}
