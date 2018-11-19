package bean;

public class ConfirmUser {
    String id;
    String name;
    String sex;

    public ConfirmUser(String id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }
}
