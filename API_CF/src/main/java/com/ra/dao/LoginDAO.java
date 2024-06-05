package com.ra.dao;

import com.ra.model.entity.Cfmast;
import com.ra.model.entity.login;

import java.util.List;

public interface LoginDAO {
    List<login> findAll(String inputParameter1, String inputParameter2);
}
