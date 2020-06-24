package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDAO extends JpaRepository<Department,Integer> {

}
