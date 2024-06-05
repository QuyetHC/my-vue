package com.ra.dao;

import com.ra.Utils.ConnectionDB;
import com.ra.model.entity.Cfmast;
import com.ra.model.entity.balance;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BalanceDAOImpl implements BalanceDAO {
    @Override
    public List<balance> findAll() {
        List<balance> balance = new ArrayList<>();
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("{call INOPKS_API.API_TRUONG_BALANCE(?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.execute();

            ResultSet rs = ((OracleCallableStatement) call).getCursor(1);
            while (rs.next()) {
                balance bl = new balance();
                bl.setCustid(rs.getString("custid"));
                bl.setAcct(rs.getString("acct"));
                bl.setValue(rs.getString("value"));
                bl.setCLNO(rs.getString("CLNO"));
                bl.setDEBTNIC(rs.getString("DEBTNIC"));
                bl.setDelinq(rs.getString("Delinq"));
                balance.add(bl);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return balance;
    }
}
