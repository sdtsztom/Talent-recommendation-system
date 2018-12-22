package procedure;

import Interface.Procedure;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class pointsReward implements Procedure {
    private String name="pointsReward(?,?)";
    private int rec_stf_id;
    private int rule_id;

    public pointsReward(int rec_stf_id,int rule_id){
        this.rec_stf_id=rec_stf_id;
        this.rule_id=rule_id;
    }

    @Override
    public String getProcedureName() {
        return name;
    }

    @Override
    public void setProcedure(CallableStatement procedure) {
        try {
            procedure.setInt(1,rec_stf_id);
            procedure.setInt(2,rule_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receive(CallableStatement procedure) {

    }
}
