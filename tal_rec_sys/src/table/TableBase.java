package table;

import util.CommonConnection;
import ienum.ConnectUser;
import util.iutil;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class TableBase {
    String []head=null;
     String [][]str_load=null;
     TableBase table_load=null;
     boolean switcher=true;  //开关，true使用str_load，false使用table_load
     int nrows=0;
     int ncols=0;
     //String default_table_css="border=1px style=\"border-collapse:collapse;\"";
    //要求bootstrip的样式设定
    //<link href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
     String default_table_css="class=\"table\"";
     int npage=1;
     boolean with_order;

     //*******************************Initialize*************************************
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
    //*******************************Initialize*************************************

    //*******************************Receive Methods*************************************
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
        makeShape();
    }

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
    //*******************************Receive Methods*************************************
    public int[] shape(){
        int []s={nrows,ncols};
        return s;
    }

    public void makeShape(){
        makeShape(str_load.length,str_load[0].length);
    }

    public void makeShape(int data_nrow,int data_ncol){
        this.nrows=data_nrow;
        this.ncols=data_ncol;
    }

    public void setWith_order(boolean with_order){this.with_order=with_order;}

    public String _getItem(int row,int col){
        if(switcher)return str_load[row][col];
        else return table_load.getItem(row,col);
    }

    // 用来被重写
    public String getItem(int row,int col){
        return this._getItem(row,col);
    }

    //****************************************HTML Generator*******************************************
    public String[] genTableWrapper(String table_css){
        String pre="<div><table "+table_css+">\n";
        String post="\n</table></div>\n";
        String table_wapper[]={pre,post};
        return table_wapper;
    }

    public String genHead(){
        // 产生的内容不包含换行符
        String head_content="";
        String item_wrapper[]={"<th>","</th>"};
        String line_wrapper[]={"<tr>\n","\n</tr>"};

        if(with_order)head_content+="<th>序号</th>";

        for(String i:head){head_content+=item_wrapper[0]+i+item_wrapper[1];}

        return line_wrapper[0]+head_content+line_wrapper[1];
    }

    public String genLine(int row){
        // 产生的内容包含换行符
        String line_content="";
        String item_wrapper[]={"<td>","</td>"};
        String line_wrapper[]={"<tr>\n","\n</tr>\n"};

        // 添加序号信息
        if(with_order)line_content+=item_wrapper[0]+(row+1)+item_wrapper[1];

        for(int i: iutil.range(ncols))line_content+=item_wrapper[0]+getItem(row,i)+item_wrapper[1];
        return line_wrapper[0]+line_content+line_wrapper[1];
    }

    public String genLine4Vertical(int row){
        // 产生的内容包含换行符
        String line_content="";
        String item_wrapper[]={"<td>","</td>"};
        String head_wrapper[]={"<th scope=\"row\">","</th>"};
        String line_wrapper[]={"<tr>\n","\n</tr>\n"};

        //加入head
        line_content+=head_wrapper[0]+head[row]+head_wrapper[1];

        for(int i:iutil.range(ncols))line_content+=item_wrapper[0]+getItem(row,i)+item_wrapper[1];
        return line_wrapper[0]+line_content+line_wrapper[1];
    }
    //****************************************HTML Generator*******************************************

    //*****************************************Horizontal table API****************************************************
    public String genHTML(String []head){
        return genHTML(head,default_table_css,true);
    }

    public String genHTML(String []head,String table_css,boolean with_order) {
        setWith_order(with_order);

        // if you don't need head,pass null
        String body_content="";
        String table_wrapper[]=genTableWrapper(table_css);
        String head_wrapper[]={"<thead>\n","\n</thead>"};
        String body_wrapper[]={"<tbody>\n","</tbody>"};

        // 加入head
        if (head!=null&&head.length != ncols){
            System.out.println("Error:length of head don't correspond to content....");
            System.out.println("length of head:"+head.length+"\tncols:"+ncols);
            return null;
        }
        if(head!=null){
            this.head=head;
            body_content+=head_wrapper[0]+genHead()+head_wrapper[1];
        }


        body_content+="\n";

        // 加入body
        body_content+=body_wrapper[0];
        for(int i:iutil.range(nrows))body_content+=genLine(i);
        body_content+=body_wrapper[1];

        return table_wrapper[0]+body_content+table_wrapper[1];
    }
    //*****************************************Horizontal table API****************************************************

    //*****************************************Vertical table API****************************************************
    public String genVerticalHTML(String []head){return genVerticalHTML(head,default_table_css);}

    public String genVerticalHTML(String []head,String table_css){
        str_load=iutil.transpose(str_load);
        makeShape();

        String body_content="";
        String table_wrapper[]=genTableWrapper(table_css);
        String body_wrapper[]={"<tbody>\n","</tbody>"};

        // 加入head
        if (head!=null&&head.length != nrows){
            System.out.println("Error:length of head don't correspond to content....");
            System.out.println("length of head:"+head.length+"\tnrows:"+nrows);
            return null;
        }
        if(head!=null)this.head=head;

        // 加入body
        body_content+=body_wrapper[0];
        for(int i:iutil.range(nrows))body_content+=genLine4Vertical(i);
        body_content+=body_wrapper[1];

        return table_wrapper[0]+body_content+table_wrapper[1];
    }
    //*****************************************Vertical table API****************************************************
}
