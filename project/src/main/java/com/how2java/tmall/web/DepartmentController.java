package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Department;
import com.how2java.tmall.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> list() throws Exception{
        return departmentService.list();
    }
}
