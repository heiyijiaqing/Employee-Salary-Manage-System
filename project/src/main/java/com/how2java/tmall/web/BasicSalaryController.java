package com.how2java.tmall.web;

import com.how2java.tmall.pojo.BasicSalary;
import com.how2java.tmall.service.BasicSalaryService;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
public class BasicSalaryController {
    @Autowired BasicSalaryService basicSalaryService;

    @GetMapping("/users/{userId}/basicSalaries")
    public Page4Navigator<BasicSalary> list(@PathVariable("userId") int userId, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<BasicSalary> page =basicSalaryService.list(userId, start, size,5);
        return page;
    }

    @GetMapping("/basicSalaries/{id}")
    public BasicSalary get(@PathVariable("id") int id) throws Exception {
        BasicSalary bean=basicSalaryService.get(id);
        return bean;
    }

    @PostMapping("/basicSalaries")
    public Object add(@RequestBody BasicSalary bean) throws Exception {
        bean.setWeekendOverWorkMoney(bean.getBasicSalary() * 2);
        bean.setHolidayOverWorkMoney(bean.getBasicSalary() * 3);
        basicSalaryService.add(bean);
        return bean;
    }

    @DeleteMapping("/basicSalaries/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        basicSalaryService.delete(id);
        return null;
    }

    @PutMapping("/basicSalaries")
    public Object update(@RequestBody BasicSalary bean) throws Exception {
        basicSalaryService.update(bean);
        return bean;
    }

}