package bean;

public class TaskRepresentation {

    private String id;
    private String name;
    private String ececutionid;

    public TaskRepresentation(String id, String name,String ececutionid) {
        this.id = id;
        this.name = name;
        this.ececutionid = ececutionid;
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

    public String getEcecutionid() {
        return ececutionid;
    }

    public void setEcecutionid(String ececutionid) {
        this.ececutionid = ececutionid;
    }
}
