package MVC.ActivitiService;

import org.activiti.engine.*;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivitiService {

    //配置
    ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

    private RuntimeService runtimeService = engine.getRuntimeService();

    private TaskService taskService = engine.getTaskService();

    private RepositoryService repositoryService = engine.getRepositoryService();

    private void ProcessBuild() {
        repositoryService
                .createDeployment()//创建部署对象
                .name("workflow")//声明流程的名称
                .category("workflow")//修改category
                .addClasspathResource("Process/blankProcess.bpmn").addClasspathResource("Process/blankProcess.png").deploy();
    }

    //根据Execution的NAME获取task的id
    public String getTaskIdByName(String name) {
        List<Execution> list = runtimeService.createExecutionQuery().list();
        List<Task> tasks = taskService.createTaskQuery().list();
        for(Execution e : list)
            if(e.getName().equals(name))
                for(Task t : tasks)
                    if (t.getExecutionId().equals(e.getId()))
                        return t.getId();
        return "null";
    }

    //开始流程
    public ProcessInstance startProcess() {
        if(repositoryService.createDeploymentQuery().count()==0)
        ProcessBuild();
        Map<String,Object> variables = new HashMap<String,Object>();
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("workflow",variables);
        return pi;
    }

    //删除流程
    public void deleteProcess(String name1,String name2) {
        repositoryService.deleteDeployment(name1);
        runtimeService.deleteProcessInstance(name2,"");
    }

    //获得任务列表
    public List<Task> getTasks() {
        return taskService.createTaskQuery().list();
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
            rs.close();
            query="update ACT_RU_EXECUTION set NAME_ = '"+name+"' where ID_ = "+ID_+";";
            int i = stat.executeUpdate(query);
            Conn.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}