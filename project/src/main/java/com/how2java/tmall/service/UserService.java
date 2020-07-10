package com.how2java.tmall.service;

import com.how2java.tmall.dao.UserDAO;
import com.how2java.tmall.pojo.Department;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired UserDAO userDAO;
    @Autowired DepartmentService departmentService;

//    public Page4Navigator<User> list(int departmentId, int start, int size,int navigatePages) {
//        Department department = departmentService.get(departmentId);
//
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        Pageable pageable = new PageRequest(start, size, sort);
//
//        Page<User> pageFromJPA =userDAO.findByDepartment(department,pageable);
//
//        return new Page4Navigator<>(pageFromJPA,navigatePages);
//
//    }

    //做分页
    public Page4Navigator<User> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =userDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    //首先创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 userDAO进行查询。
    public List<User> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return userDAO.findAll(sort);
    }

    public void add(User bean){
        userDAO.save(bean);
    }

    public void delete(int id) {
        userDAO.delete(id);
    }

    public User get(int id) {
        User d = userDAO.findOne(id);
        return d;
    }

    public void update(User bean) {
        userDAO.save(bean);
    }

    public User get(String name, String password) {
        return userDAO.getByNameAndPassword(name,password);
    }
}
