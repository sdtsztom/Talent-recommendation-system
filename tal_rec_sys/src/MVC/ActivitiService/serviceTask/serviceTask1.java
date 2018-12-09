package MVC.ActivitiService.serviceTask;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class serviceTask1 implements JavaDelegate {

    //上传招聘需求
    @Override
    public void execute(DelegateExecution delegateExecution) {
        String name = (String)delegateExecution.getVariable("name");
        setName(name);
        function();
    }

    //
    public void function() {
        System.out.println("this is function");
    }

    //设置Execution的NAME
    private void setName(String name) {
        try{
            String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String conn="jdbc:sqlserver://localhost:1433;DatabaseName=activiti";
            String username="u_dev";
            String password="12345678a";

            Connection Conn= DriverManager.getConnection(conn,username,password);
            Statement stat=Conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT ID_ FROM ACT_RU_EXECUTION WHERE NAME_ is null;";
            ResultSet rs = stat.executeQuery(query);
            String ID_ = null;
            if(rs.first()) {
                ID_ = rs.getString("ID_");
            }
            query="update ACT_RU_EXECUTION set NAME_ = '"+name+"' where ID_ = "+ID_+";";
            int i = stat.executeUpdate(query);
            Conn.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
