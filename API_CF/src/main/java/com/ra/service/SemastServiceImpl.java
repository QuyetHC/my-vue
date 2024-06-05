package com.ra.service;

import com.ra.dao.SemastDAO;
import com.ra.model.entity.Semast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemastServiceImpl implements SemastService{
    @Autowired
    private SemastDAO semastDAO;
    @Override
    public List<Semast> findAll() {
        return semastDAO.findAll();
    }
}
