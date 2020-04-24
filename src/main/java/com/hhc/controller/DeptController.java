package com.hhc.controller;

import com.hhc.entity.Dept;
import com.hhc.service.DeptService;
import com.hhc.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/deptlist")
    public ResultVO deptlist(){
        return deptService.getAllDept();
    }

    @GetMapping("/queryDeptById")
    public ResultVO queryDeptById(Integer id){
        return deptService.getDeptById(id);
    }

    @GetMapping("/queryDeptByName")
    public ResultVO queryDeptByName(String name){
        System.out.println(name);
        return deptService.getDeptByName(name);
    }

    @GetMapping("/addDept")
    public ResultVO addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/deleteDeptById")
    public ResultVO deleteDeptById(Integer id){
        return deptService.deleteDeptById(id);
    }

    @GetMapping("/updateDeptById")
    public ResultVO updateDeptById(Dept dept){
        return deptService.updateDeptById(dept);
    }

    @GetMapping("/listDeptByPage")
    public ResultVO listDeptByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "4") Integer pageSize){
        return deptService.listByPage(pageNum,pageSize);
    }
}
