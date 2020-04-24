package com.hhc.service;

import com.hhc.entity.Emp;
import com.hhc.util.ResultVO;

import java.math.BigDecimal;

public interface EmpService {
    ResultVO queryById(Integer id);
    ResultVO queryByName(String name);
    ResultVO queryAll();
    ResultVO deleteEmpById(Integer id);
    ResultVO updateEmpById(Emp emp);
    ResultVO addEmp(Emp emp);
    ResultVO listByPage(Integer pageNum,Integer pageSize);
}
