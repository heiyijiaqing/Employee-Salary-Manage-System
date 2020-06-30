package com.how2java.tmall.service;

import com.how2java.tmall.dao.BasicSalaryDAO;
import com.how2java.tmall.pojo.BasicSalary;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BasicSalaryService {
    @Autowired BasicSalaryDAO basicSalaryDAO;
    @Autowired UserService userService;

    public void add(BasicSalary bean) {
        basicSalaryDAO.save(bean);
    }

    public void delete(int id) {
        basicSalaryDAO.delete(id);
    }

    public BasicSalary get(int id) {
        return basicSalaryDAO.findOne(id);
    }

    public void update(BasicSalary bean) {
        basicSalaryDAO.save(bean);
    }

    public Page4Navigator<BasicSalary> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =basicSalaryDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

//    public Page4Navigator<BasicSalary> list(int userId, int start, int size, int navigatePages) {
//        User user = userService.get(userId);
//
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        Pageable pageable = new PageRequest(start, size, sort);
//
//        Page<BasicSalary> pageFromJPA =basicSalaryDAO.findByUser(user,pageable);
//
//        return new Page4Navigator<>(pageFromJPA,navigatePages);
//
//    }
}
