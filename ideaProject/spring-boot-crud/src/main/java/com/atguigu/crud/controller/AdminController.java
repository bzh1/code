package com.atguigu.crud.controller;

import com.atguigu.crud.bean.TAdmin;
import com.atguigu.crud.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminMapper adminMapper;

    @GetMapping("/admin")
    public String adminListPage(Model model){

        List<TAdmin> admins = adminMapper.getAllAdmin();

        model.addAttribute("admins",admins);
        return "admin/list";
    }
}
