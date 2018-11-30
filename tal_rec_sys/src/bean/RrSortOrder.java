package bean;

public class RrSortOrder {
    String time_order=null;
    String emergency_degree_order=null;

    public RrSortOrder(){
        setDefault();
    }

    public void setDefault(){
        time_order="desc";
        emergency_degree_order="asc";
    }

    public void reverse_time(){
        if(time_order.equals("desc"))time_order="asc";
        else time_order="desc";
    }
    
    public void reverse_ed(){
        if(emergency_degree_order.equals("desc"))emergency_degree_order="asc";
        else emergency_degree_order="desc";
    }

    public String getTime_order() {
        return time_order;
    }

    public String getEmergency_degree_order() {
        return emergency_degree_order;
    }
}
