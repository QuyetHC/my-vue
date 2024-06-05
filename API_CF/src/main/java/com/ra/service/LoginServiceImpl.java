package com.ra.service;

import com.ra.dao.LoginDAO;
import com.ra.model.entity.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDAO loginDAO;
    @Override
    public List<login> findAll(String inputParameter1, String inputParameter2) {
        return  loginDAO.findAll(inputParameter1,inputParameter2);
    }
}
