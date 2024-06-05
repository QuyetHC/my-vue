package com.ra.dao;

import com.ra.Utils.ConnectionDB;
import com.ra.model.entity.Semast;
import com.ra.model.entity.loan;
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
public class LoanDAOImpl implements LoanDAO{
    @Override
    public List<loan> findAll() {
        List<loan> loanList=new ArrayList<>();
        Connection connection=null;
        connection= ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("{call INOPKS_API.API_TRUONG_LOAN(?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.execute();

            ResultSet rs = ((OracleCallableStatement) call).getCursor(1);
            while (rs.next()){
                loan ln=new loan();
                ln.setCustid(rs.getString("custid"));
                ln.setAcct(rs.getString("acct"));
                ln.setLoan(rs.getString("loan"));
                ln.setValue(rs.getString("value"));
                ln.setBad(rs.getString("bad"));
                ln.setJob(rs.getString("job"));
                loanList.add(ln);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return loanList;
    }
}
