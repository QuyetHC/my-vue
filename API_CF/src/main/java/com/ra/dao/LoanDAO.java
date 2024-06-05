package com.ra.dao;

import com.ra.model.entity.Semast;
import com.ra.model.entity.loan;

import java.util.List;

public interface LoanDAO {
    List<loan>findAll();
}
