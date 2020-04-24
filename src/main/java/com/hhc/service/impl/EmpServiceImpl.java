package com.hhc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhc.entity.Emp;
import com.hhc.mapper.EmpMapper;
import com.hhc.service.EmpService;
import com.hhc.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public ResultVO queryById(Integer id) {
        Emp emp=empMapper.getEmpByEmpId(id);
        if (emp==null){
            return ResultVO.fail(1,"没有此员工！");
        }
        return ResultVO.success(emp);
    }

    @Override
    public ResultVO queryByName(String name) {
        List<Emp> emps = empMapper.getEmpByName(name);
        for (Emp emp : emps) {
            if (emp==null){
                return ResultVO.fail(1,"没有此员工！");
            }
            return ResultVO.success(emps);
        }
        /*for (int i = 0; i <emps.size() ; i++) {
            if (emps.get(i)==null){
                return ResultVO.fail(1,"没有此员工！");
            }else {
                return ResultVO.success(emps);
            }
        }*/
        return null;
    }


    @Override
    public ResultVO queryAll() {
        return ResultVO.success(empMapper.emplist());
    }

    @Override
    public ResultVO deleteEmpById(Integer id) {
        int i = empMapper.deleteEmpById(id);
        if (i!=0){
            return ResultVO.success("删除成功");
        }
        return ResultVO.fail(1,"删除失败");
    }

    @Override
    public ResultVO updateEmpById(Emp emp) {
        int i = empMapper.updateEmpById(emp);
        System.out.println(i);
        if (i!=0){
            return ResultVO.success("修改成功");
        }
       return ResultVO.fail(1,"修改失败");
    }

    @Override
    public ResultVO addEmp(Emp emp) {
        int i = empMapper.addEmp(emp);
        if (i!=0){
            return ResultVO.success("增加成功",emp);
        }
        return ResultVO.fail(1,"增加失败");
    }

    /**
     * 分页查询
     * @param pageNum 当前页（第几页）
     * @param pageSize  页面大小(一页有多少数据)
     * @return
     */
    @Override
    public ResultVO listByPage(Integer pageNum, Integer pageSize) {
//        在查询之前设置分页参数
        PageHelper.startPage(pageNum,pageSize);
//        调用查询
        List<Emp> emps = empMapper.emplist();
//        封装
        PageInfo pageInfo=new PageInfo(emps);
        return ResultVO.success(pageInfo);
    }
}
