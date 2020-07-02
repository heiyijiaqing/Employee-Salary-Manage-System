package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Salary;
import com.how2java.tmall.service.SalaryService;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class SalaryController {
    @Autowired SalaryService salaryService;

    //DepartmentController 修改原 list 方法，接受 start 和 size 参数。
    @GetMapping("/salaries")
    public Page4Navigator<Salary> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Page4Navigator<Salary> page = salaryService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

    @GetMapping("/salaries/{id}")
    public Salary get(@PathVariable("id") int id) throws Exception {
        Salary bean=salaryService.get(id);
        return bean;
    }

    @PostMapping("/salaries")
    public Object add(@RequestBody Salary bean) throws Exception {
        bean.setCreateDate(new Date());
        salaryService.add(bean);
        return bean;
    }

    @DeleteMapping("/salaries/{id}")
    public String delete(@PathVariable("id") int id)  throws Exception {
        salaryService.delete(id);
        return null;
    }

    @PutMapping("/salaries")
    public Object update(@RequestBody Salary bean) throws Exception {
        salaryService.update(bean);
        return bean;
    }
}
