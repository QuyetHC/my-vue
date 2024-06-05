package com.ra.service;

import com.ra.dao.SemastDAO;
import com.ra.dao.reportCreditDAO;
import com.ra.model.entity.Semast;
import com.ra.model.entity.reportcredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportScreditServiceImpl implements ReportCreditService{
    @Autowired
    private reportCreditDAO semastDAO;
    @Override
    public List<reportcredit> findAll() {
        return semastDAO.findAll();
    }
}
