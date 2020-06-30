package com.how2java.tmall.web;

import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.UserService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired UserService userService;


    //DepartmentController 修改原 list 方法，接受 start 和 size 参数。
    @GetMapping("/users")
    public Page4Navigator<User> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Page4Navigator<User> page = userService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

//    @GetMapping("/departments/{cid}/users")
//    public Page4Navigator<User> list(@PathVariable("departmentId") int departmentId, @RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
//        start = start<0?0:start;
//        Page4Navigator<User> page =userService.list(departmentId, start, size,5);
//        return page;
//    }

    @GetMapping("/users/{id}")
    public User get(@PathVariable("id") int id) throws Exception {
        User bean=userService.get(id);
        return bean;
    }

    @PostMapping("/users")
    public Object add(@RequestBody User bean) throws Exception {
        bean.setCreateDate(new Date());
        userService.add(bean);
        return bean;
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        userService.delete(id);
        return null;
    }

    @PutMapping("/users")
    public Object update(@RequestBody User bean) throws Exception {
        userService.update(bean);
        return bean;
    }

//    @PostMapping("/users")
//    public Object add(User bean, MultipartFile image, HttpServletRequest request) throws Exception {
//        bean.setCreateDate(new Date()); //自动录入当前时间
//        userService.add(bean);
//        return bean;
//    }
//
//    @DeleteMapping("/users/{id}")
//    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
//        userService.delete(id);
//        File  imageFolder= new File(request.getServletContext().getRealPath("img/category"));
//        File file = new File(imageFolder,id+".jpg");
//        file.delete();
//        return null;
//    }
//
//    @GetMapping("/users/{id}")
//    public User get(@PathVariable("id") int id) throws Exception {
//        User bean=userService.get(id);
//        return bean;
//    }
//
//    @PutMapping("/users/{id}")
//    public Object update(User bean, MultipartFile image,HttpServletRequest request) throws Exception {
//        String name = request.getParameter("name");
//        bean.setName(name);
//        bean.setCreateDate(new Date()); //自动录入当前时间
//        userService.update(bean);
//        return bean;
//    }
}
