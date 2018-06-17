package com.example.demo.controller;

import com.example.demo.dao.GuitarDao;
import com.example.demo.entity.Guitar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuitarController {

    @Autowired
    private GuitarDao guitarDao;
    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("guitars",guitarDao.findAllGuitar());
        return "list";
    }

    @PostMapping("/add")
    public String add(Guitar guitar){
        guitarDao.addGuitar(guitar);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String  deleteById(@PathVariable("id") Integer id ){
        guitarDao.deleteById(id);
        return "redirect:/";
    }
    @PostMapping("/findByName")
    public String findByName(String name,Model model){
       model.addAttribute("guitars", guitarDao.findByName(name));
       return "list";
    }

}
