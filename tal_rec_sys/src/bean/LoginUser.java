package bean;

public class LoginUser {
    String userName;
    String pwd;
    public LoginUser(String userName,String pwd) {
        this.userName=userName;
        this.pwd=pwd;
    }

    public String getName() {
        return userName;
    }

    public String getPwd() {
        return pwd;
    }
}
