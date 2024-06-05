package com.ra.service;

import com.ra.dao.LoanDAO;
import com.ra.dao.SemastDAO;
import com.ra.model.entity.Semast;
import com.ra.model.entity.loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{
    @Autowired
    private LoanDAO loanDAO;
    @Override
    public List<loan> findAll() {
        return loanDAO.findAll();
    }
}
