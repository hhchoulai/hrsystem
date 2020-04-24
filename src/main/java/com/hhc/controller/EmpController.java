package com.hhc.controller;

import com.hhc.entity.Emp;
import com.hhc.service.EmpService;
import com.hhc.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/queryEmpById")
    public ResultVO queryById(Integer id){
        return empService.queryById(id);
    }

    @GetMapping("/queryEmpByName")
    public ResultVO queryByName(String name){
        return empService.queryByName(name);
    }

    @GetMapping("/queryAllEmp")
    public ResultVO queryAllEmp(){
        return empService.queryAll();
    }

    @GetMapping("/deleteEmpById")
    public ResultVO deleteEmpById(Integer id){
//        System.out.println(id);
        return empService.deleteEmpById(id);
    }

    @PostMapping("/updateEmpById")
    public ResultVO updateEmpById(Emp emp){
        return empService.updateEmpById(emp);
    }

    @PostMapping("/addEmp")
    public ResultVO addEmp(Emp emp){
        return empService.addEmp(emp);
    }

    @GetMapping("listEmpByPage")
    public ResultVO listEmpByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "5") Integer pageSize){
        return empService.listByPage(pageNum,pageSize);
    }
}
