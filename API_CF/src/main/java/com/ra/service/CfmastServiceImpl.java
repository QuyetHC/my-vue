package com.ra.service;

import com.ra.dao.CfmastDAO;
import com.ra.model.entity.Cfmast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CfmastServiceImpl implements CfmastService {
    @Autowired
    private CfmastDAO cfmastDAO;
    @Override
    public List<Cfmast> findAll() {
        return  cfmastDAO.findAll();
    }
}
