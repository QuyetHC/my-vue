package com.ra.dao;

import com.ra.model.entity.balance;
import com.ra.model.entity.reportcredit;

import java.util.List;

public interface reportCreditDAO {
    List<reportcredit> findAll();
}
