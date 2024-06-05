package com.ra.dao;

import com.ra.Utils.ConnectionDB;
import com.ra.model.entity.CUST;
import com.ra.model.entity.Cfmast;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CUSTDAOImpl implements CUSTDAO {
    @Override
    public List<CUST> findAll(String inputParameter1) {
        List<CUST> cust = new ArrayList<>();
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("{call INOPKS_API.API_TRUONG_CUST(?,?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, inputParameter1); // Thay inputParameter1 bằng giá trị thích hợp
            call.execute();
            ResultSet rs = ((OracleCallableStatement) call).getCursor(1);
            while (rs.next()){
                CUST custs=new CUST();
                custs.setCustid(rs.getString("custid"));
                custs.setCustodycd(rs.getString("custodycd"));
                custs.setFullName(rs.getString("fullname"));
                custs.setAddr(rs.getString("ADDR"));
                custs.setIdCode(rs.getString("IDCODE"));
                custs.setCusttype(rs.getString("CUSTTYPE"));
                custs.setScore(rs.getString("SCORE"));
                cust.add(custs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return cust;
    }
}
