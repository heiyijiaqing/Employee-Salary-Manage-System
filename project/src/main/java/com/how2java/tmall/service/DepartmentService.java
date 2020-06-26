package com.how2java.tmall.service;

import com.how2java.tmall.dao.DepartmentDAO;
import com.how2java.tmall.pojo.Department;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired DepartmentDAO departmentDAO;

    //做分页
    public Page4Navigator<Department> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =departmentDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    //首先创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 categoryDAO进行查询。
    public List<Department> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return departmentDAO.findAll(sort);
    }

    public void add(Department bean){
        departmentDAO.save(bean);
    }

    public void delete(int id) {
        departmentDAO.delete(id);
    }

    public Department get(int id) {
        Department d= departmentDAO.findOne(id);
        return d;
    }

    public void update(Department bean) {
        departmentDAO.save(bean);
    }
}
