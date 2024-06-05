package com.ra.service;

import com.ra.model.entity.Semast;
import com.ra.model.entity.loan;

import java.util.List;

public interface LoanService {
    List<loan> findAll();
}
