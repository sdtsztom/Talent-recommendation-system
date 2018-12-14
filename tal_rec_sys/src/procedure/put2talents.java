package procedure;

import Interface.Procedure;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class put2talents implements Procedure {
    private String name="put2talents(?,?)";
    private int rec_id;
    private int from_id;

    public put2talents(int rec_id,int from_id){
        this.rec_id =rec_id;
        this.from_id =from_id;
    }

    @Override
    public String getProcedureName() {
        return name;
    }

    @Override
    public void setProcedure(CallableStatement procedure) {
        try {
            procedure.setInt(1, rec_id);
            procedure.setInt(2, from_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receive(CallableStatement procedure) {

    }
}
