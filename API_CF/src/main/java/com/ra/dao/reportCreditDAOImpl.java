package com.ra.dao;

import com.ra.Utils.ConnectionDB;
import com.ra.model.entity.Semast;
import com.ra.model.entity.reportcredit;
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
public class reportCreditDAOImpl implements reportCreditDAO{
    @Override
    public List<reportcredit> findAll() {
        List<reportcredit> reportcredit=new ArrayList<>();
        Connection connection=null;
        connection= ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("{call INOPKS_API.API_TRUONG_REPORT(?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.execute();

            ResultSet rs = ((OracleCallableStatement) call).getCursor(1);
            while (rs.next()){
                reportcredit re=new reportcredit();
                re.setId(rs.getString("id"));
                re.setName(rs.getString("name"));
                re.setCreditScore(rs.getString("creditScore"));
                reportcredit.add(re);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return reportcredit;
    }
}
