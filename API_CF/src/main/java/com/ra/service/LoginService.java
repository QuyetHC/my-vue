package com.ra.service;
import com.ra.model.entity.login;

import java.util.List;

public interface LoginService {
    List<login> findAll(String inputParameter1, String inputParameter2);
}
