package procedure;

import Interface.Procedure;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class put2otherneed implements Procedure {
    private String name="put2otherneed(?,?,?)";
    private int rec_id;
    private int otherneed_id;
    private int from_id;

    public put2otherneed(int rec_id,int otherneed_id,int from_id){
        this.rec_id =rec_id;
        this.otherneed_id=otherneed_id;
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
            procedure.setInt(2,otherneed_id);
            procedure.setInt(3, from_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receive(CallableStatement procedure) {

    }
}
