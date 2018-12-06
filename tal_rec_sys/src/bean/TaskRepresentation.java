package bean;

import java.util.Date;
import java.util.Map;

public class TaskRepresentation {

    private String id;
    private String name;
    private String ececutionId;
    private String createTime;
    private String processDefinitionId;
    private String processInstanceId;
    private String taskDefinitionKey;

    public TaskRepresentation(String id, String name,String ececutionId,Date createTime,String processDefinitionId,String processInstanceId,String taskDefinitionKey) {
        this.id = id;
        this.name = name;
        this.ececutionId = ececutionId;
        this.createTime = createTime.toString();
        this.processDefinitionId = processDefinitionId;
        this.processInstanceId = processInstanceId;
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEcecutionId() {
        return ececutionId;
    }

    public void setEcecutionId(String ececutionId) {
        this.ececutionId = ececutionId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime.toString();
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }


    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }
}
