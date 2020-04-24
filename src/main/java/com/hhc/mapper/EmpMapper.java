package com.hhc.mapper;

import com.hhc.entity.Emp;

import java.util.List;

public interface EmpMapper {
    Emp getEmpByEmpId(Integer empId);
    List<Emp> getEmpByName(String name);
    List<Emp> emplist();
    int deleteEmpById(Integer id);
    int updateEmpById(Emp emp);
    int addEmp(Emp emp);
}
