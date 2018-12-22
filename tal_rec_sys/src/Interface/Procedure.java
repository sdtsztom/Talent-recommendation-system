package Interface;

import java.sql.CallableStatement;

public interface Procedure {
    String getProcedureName();
    void setProcedure(CallableStatement procedure);
    void receive(CallableStatement procedure);
}
