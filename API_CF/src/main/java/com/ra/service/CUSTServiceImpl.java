package com.ra.service;

import com.ra.dao.CUSTDAO;
import com.ra.model.entity.CUST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CUSTServiceImpl implements CUSTService {
    @Autowired
    private CUSTDAO custDAO;
    @Override
    public List<CUST> findAll(String a) {
        return  custDAO.findAll(a);
    }
}
