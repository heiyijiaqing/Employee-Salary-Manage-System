package com.how2java.tmall.dao;


import com.how2java.tmall.pojo.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryDAO extends JpaRepository<Salary,Integer> {

}
