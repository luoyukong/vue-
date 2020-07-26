package com.springbooot3.web;


import java.util.List;

import com.springbooot3.mapper.CategoryMapper;
import com.springbooot3.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/addCategory")
    public List<Category> listCategory(String username,String password) throws Exception {
        categoryMapper.save(username,password);
        return categoryMapper.findAll();
    }
    @RequestMapping("/deleteCategory")
    @ResponseBody
    public List<Category> deleteCategory(int id) throws Exception {
        categoryMapper.delete(id);
        return categoryMapper.findAll();
    }
    @RequestMapping("/updateCategory")
    public List<Category> updateCategory(String username,String password) throws Exception {
        categoryMapper.update(username,password);
        return categoryMapper.findAll();
    }
    @RequestMapping("/editCategory")
    public List<Category> listCategory(int id,String username,String password) throws Exception {
        Category c= categoryMapper.get(id);
        c.setUsername(username);
        c.setPassword(password);
        return categoryMapper.findAll();
    }

    @RequestMapping("/listCategory")
    @ResponseBody
    public List<Category> listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
       // PageHelper.startPage(start,size,"id desc");
        List<Category> cs=categoryMapper.findAll();
       // PageInfo<Category> page = new PageInfo<>(cs);
       // m.addAttribute("page", page);
        return cs;
    }

}