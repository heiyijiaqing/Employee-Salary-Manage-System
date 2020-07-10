package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.Department;
import com.how2java.tmall.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
//    Page<User> findByDepartment(Department category, Pageable pageable);
    User getByNameAndPassword(String name, String password);
}