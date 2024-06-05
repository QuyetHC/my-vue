package com.ra.dao;

import com.ra.model.entity.CUST;
import java.util.List;

public interface CUSTDAO {
    List<CUST> findAll(String a);
}
