package example;

import table.TableBase;
import ienum.ConnectUser;

public class TableBaseExample {
    public static void main(String []args){
        // use str to create table
        String []head={"col1","col2"};
        String []line1={"11","12"};
        String []line2={"21","22"};
        String [][]table_content={line1,line2};
        TableBase table=new TableBase(table_content);
        System.out.println(table.genHTML(head));

        // usr query to create table
        TableBase table2=new TableBase("select * from SRM_OPEN", ConnectUser.HR);
        String []head2={"推荐id","推荐人","被推荐人","推荐来源"};
        System.out.println(table2.genHTML(head2));
    }
}
