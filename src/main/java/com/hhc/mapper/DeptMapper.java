package com.hhc.mapper;

import com.hhc.entity.Dept;

import java.util.List;

public interface DeptMapper {
    List<Dept> getAllDept();
    Dept getDeptById(Integer id);
    List<Dept> getDeptByName(String name);
    int addDept(Dept dept);
    int deleteDeptById(Integer id);
    int updateDeptById(Dept dept);

}
