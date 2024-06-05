package com.ra.dao;

import com.ra.Utils.ConnectionDB;
import com.ra.model.entity.Cfmast;
import com.ra.model.entity.Semast;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SemasetDAOImpl implements SemastDAO{
    @Override
    public List<Semast> findAll() {
        List<Semast> semastList=new ArrayList<>();
        Connection connection=null;
        connection= ConnectionDB.openConnection();
        try {
            CallableStatement call = connection.prepareCall("{call INOPKS_API.API_TRUONG_SEMAST(?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.execute();

            ResultSet rs = ((OracleCallableStatement) call).getCursor(1);
            while (rs.next()){
                Semast semast=new Semast();
                semast.setLOAN(rs.getString("LOAN"));
                semast.setMORTDUE(rs.getString("MORTDUE"));
                semast.setVALUE(rs.getString("VALUE"));
                semast.setREASON(rs.getString("REASON"));
                semast.setJOB(rs.getString("JOB"));
                semast.setYOJ(rs.getString("YOJ"));
                semast.setDEROG(rs.getString("DEROG"));
                semast.setDELINQ(rs.getString("DELINQ"));
                semast.setCLAGE(rs.getString("CLAGE"));
                semast.setNINQ(rs.getString("NINQ"));
                semast.setCLNO(rs.getString("CLNO"));
                semast.setDEBTINC(rs.getString("DEBTINC"));
                semast.setCUSTID(rs.getString("CUSTID"));
                semastList.add(semast);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return semastList;
    }
}
