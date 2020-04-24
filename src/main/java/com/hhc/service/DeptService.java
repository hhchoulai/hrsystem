package com.hhc.service;

import com.hhc.entity.Dept;
import com.hhc.util.ResultVO;

public interface DeptService {
    ResultVO getAllDept();
    ResultVO getDeptById(Integer id);
    ResultVO getDeptByName(String name);
    ResultVO addDept(Dept dept);
    ResultVO deleteDeptById(Integer id);
    ResultVO updateDeptById(Dept dept);
    ResultVO listByPage(Integer pageNum,Integer pageSize);
}
