package com.hhc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhc.entity.Dept;
import com.hhc.mapper.DeptMapper;
import com.hhc.service.DeptService;
import com.hhc.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public ResultVO getAllDept() {
        return ResultVO.success(deptMapper.getAllDept());
    }

    @Override
    public ResultVO getDeptById(Integer id) {
        Dept dept = deptMapper.getDeptById(id);
        if (dept==null){
            return ResultVO.fail(1,"该部门不存在！");
        }
        return ResultVO.success(dept);
    }

    @Override
    public ResultVO getDeptByName(String name) {
        List<Dept> depts = deptMapper.getDeptByName(name);
        for (Dept dept : depts) {
            if (dept==null){
                return ResultVO.fail(1,"该部门不存在！");
            }
            return ResultVO.success(depts);
        }
        return ResultVO.fail(2,"参数传递错误");
    }

    @Override
    public ResultVO addDept(Dept dept) {
        int i = deptMapper.addDept(dept);
        if (i!=0){
            return ResultVO.success();
        }
        return ResultVO.fail(1,"增加失败，可能传参错误");
    }

    @Override
    public ResultVO deleteDeptById(Integer id) {
        int i = deptMapper.deleteDeptById(id);
        if (i!=0){
            return ResultVO.success("删除成功");
        }
        return ResultVO.fail(1,"删除失败");
    }

    @Override
    public ResultVO updateDeptById(Dept dept) {
        int i = deptMapper.updateDeptById(dept);
        if (i!=0){
            return ResultVO.success("修改成功");
        }
        return ResultVO.fail(1,"修改失败");
    }

    @Override
    public ResultVO listByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Dept> allDept = deptMapper.getAllDept();
        PageInfo pageInfo=new PageInfo(allDept);
        return ResultVO.success(pageInfo);
    }

}
