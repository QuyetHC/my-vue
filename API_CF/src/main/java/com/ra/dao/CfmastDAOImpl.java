package com.ra.dao;

import com.ra.Utils.ConnectionDB;
import com.ra.model.entity.Cfmast;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CfmastDAOImpl implements CfmastDAO {
    @Override
    public List<Cfmast> findAll() {
        List<Cfmast> cfmasts = new ArrayList<>();
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("{call INOPKS_API.API_TRUONG_CFMAST(?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.execute();

            ResultSet rs = ((OracleCallableStatement) call).getCursor(1);
            while (rs.next()) {
                Cfmast cfmast = new Cfmast();
                cfmast.setCustid(rs.getString("custid"));
                cfmast.setCustodycd(rs.getString("custodycd"));
                cfmast.setFullName(rs.getString("fullname"));
                cfmast.setAddr(rs.getString("addr"));
                cfmast.setIdCode(rs.getString("IDCODE"));
                cfmast.setCusttype(rs.getString("CUSTTYPE"));
                cfmast.setScore(rs.getString("SCORE"));
                cfmasts.add(cfmast);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return cfmasts;
    }
}
