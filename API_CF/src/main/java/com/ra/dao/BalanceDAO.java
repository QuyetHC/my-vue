package com.ra.dao;

import com.ra.model.entity.Cfmast;
import com.ra.model.entity.balance;

import java.util.List;

public interface BalanceDAO {
    List<balance> findAll();
}
