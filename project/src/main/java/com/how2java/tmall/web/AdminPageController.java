package com.how2java.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

    @GetMapping(value = "/admin")
    public String admin(){
        return "redirect:admin_department_list";
    }

    //部门表
    @GetMapping(value = "/admin_department_list")
    public String listDepartment(){
        return "admin/listDepartment";
    }

    @GetMapping(value="/admin_department_edit")
    public String editDepartment(){ return "admin/editDepartment"; }

    //用户表
    @GetMapping(value = "/admin_user_list")
    public String listUser(){
        return "admin/listUser";
    }

    @GetMapping(value="/admin_user_edit")
    public String editUser(){
        return "admin/editUser";
    }

    //薪资基本参数表
    @GetMapping(value = "/admin_basicsalary_list")
    public String listBasicSalary(){
        return "admin/listBasicSalary";
    }

    @GetMapping(value="/admin_basicsalary_edit")
    public String editBasicSalary(){
        return "admin/editBasicSalary";
    }

    //奖励和惩罚表
    @GetMapping(value = "/admin_rewardpunish_list")
    public String listRewardPunish(){
        return "admin/listRewardPunish";
    }

    @GetMapping(value="/admin_rewardpunish_edit")
    public String editRewardPunish(){
        return "admin/editRewardPunish";
    }

    //薪资统计表
    @GetMapping(value = "/admin_salary_list")
    public String listSalary(){
        return "admin/listSalary";
    }

    @GetMapping(value="/admin_salary_edit")
    public String editSalary(){
        return "admin/editSalary";
    }
}
