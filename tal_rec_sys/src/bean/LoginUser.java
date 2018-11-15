package bean;

public class LoginUser {
    String username;
    String pwd;
    String id;
    String job_type;

    public LoginUser(String username, String pwd) {
        this.username = username;
        this.pwd=pwd;
    }

    public LoginUser(String username, String pwd, String id, String job_type){
        this.username=username;
        this.pwd=pwd;
        this.id=id;
        this.job_type=job_type;
    }

    public String getPwd() {
        return pwd;
    }

    public String getUsername() { return username; }

    public String getId() { return id; }

    public String getJob_type() { return job_type; }
}
