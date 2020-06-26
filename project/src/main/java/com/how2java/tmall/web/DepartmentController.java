package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Department;
import com.how2java.tmall.service.DepartmentService;
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
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired DepartmentService departmentService;

//    @GetMapping("/departments")
//    public List<Department> list() throws Exception{
//        return departmentService.list();
//    }

    //DepartmentController 修改原 list 方法，接受 start 和 size 参数。
    @GetMapping("/departments")
    public Page4Navigator<Department> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Page4Navigator<Department> page = departmentService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

    @PostMapping("/departments")
    public Object add(Department bean, MultipartFile image, HttpServletRequest request) throws Exception {
        departmentService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }

    public void saveOrUpdateImageFile(Department bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/department"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping("/departments/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        departmentService.delete(id);
        File  imageFolder= new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return null;
    }

    @GetMapping("/departments/{id}")
    public Department get(@PathVariable("id") int id) throws Exception {
        Department bean=departmentService.get(id);
        return bean;
    }

    @PutMapping("/departments/{id}")
    public Object update(Department bean, MultipartFile image,HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        bean.setName(name);
        departmentService.update(bean);

        if(image!=null) {
            saveOrUpdateImageFile(bean, image, request);
        }
        return bean;
    }
}
