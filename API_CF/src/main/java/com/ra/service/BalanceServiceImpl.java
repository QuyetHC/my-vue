package com.ra.service;

import com.ra.dao.BalanceDAO;
import com.ra.dao.SemastDAO;
import com.ra.model.entity.Semast;
import com.ra.model.entity.balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService{
    @Autowired
    private BalanceDAO balanceDAO;
    @Override
    public List<balance> findAll() {
        return balanceDAO.findAll();
    }
}
