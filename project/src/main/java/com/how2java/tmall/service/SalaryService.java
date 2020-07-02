package com.how2java.tmall.service;


import com.how2java.tmall.dao.SalaryDAO;
import com.how2java.tmall.pojo.Salary;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {
    @Autowired SalaryDAO salaryDAO;
    @Autowired UserService userService;
    @Autowired DepartmentService departmentService;

    public void add(Salary bean) {
        salaryDAO.save(bean);
    }

    public void delete(int id) {
        salaryDAO.delete(id);
    }

    public Salary get(int id) {
        return salaryDAO.findOne(id);
    }

    public void update(Salary bean) {
        salaryDAO.save(bean);
    }

    public Page4Navigator<Salary> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =salaryDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }
}
