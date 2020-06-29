package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.BasicSalary;
import com.how2java.tmall.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicSalaryDAO extends JpaRepository<BasicSalary,Integer> {
    Page<BasicSalary> findByUser(User user, Pageable pageable);
}