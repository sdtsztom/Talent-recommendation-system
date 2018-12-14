package procedure;

import Interface.Procedure;

import java.sql.CallableStatement;

public class rp2stuff implements Procedure {
    private String  procedureName="rp2stuff(?,?,?)";
    private String rpid;
    private String username;
    private String pwd;

    public rp2stuff(String rpid,String username,String pwd){
        this.rpid=rpid;
        this.username=username;
        this.pwd=pwd;
    }

    @Override
    public String getProcedureName() {
        return procedureName;
    }

    @Override
    public void setProcedure(CallableStatement procedure) {
        try{
            procedure.setInt(1,Integer.parseInt(rpid));
            procedure.setString(2,username);
            procedure.setString(3,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void receive(CallableStatement procedure) {

    }
}
