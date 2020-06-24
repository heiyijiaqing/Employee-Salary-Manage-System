package com.how2java.tmall.service;

import com.how2java.tmall.dao.DepartmentDAO;
import com.how2java.tmall.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired DepartmentDAO departmentDAO;

    public List<Department> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return departmentDAO.findAll(sort);
    }
}
