package com.ra.dao;

import com.ra.Utils.ConnectionDB;
import com.ra.model.entity.Cfmast;
import com.ra.model.entity.login;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginDAOImpl implements LoginDAO {
    @Override
    public List<login> findAll(String inputParameter1, String inputParameter2) {
        List<login> login = new ArrayList<>();
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("{call INOPKS_API.API_TRUONG_userlogin(?,?,?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, inputParameter1); // Thay inputParameter1 bằng giá trị thích hợp
            call.setString(3, inputParameter2);
            call.execute();

            ResultSet rs = ((OracleCallableStatement) call).getCursor(1);
            while (rs.next()){
                login lg=new login();
                lg.setUsername(rs.getString("USERNAME"));
                lg.setPasswd(rs.getString("LOGINPWD"));
                lg.setRole(rs.getString("ROLE"));
                lg.setCustid(rs.getString("CUSTID"));
                login.add(lg);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return login;
    }
}
