package com.hngy.controller;

import com.github.pagehelper.PageInfo;
import com.hngy.entity.Date;
import com.hngy.entity.User;
import com.hngy.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author 6-126
 * @date 2023/5/2 21:56
 */
@Controller
public class DateController {
    @Autowired
    private DateService dateService;

    @GetMapping("/date")
    public String page(@RequestParam(defaultValue = "1", required = false) Integer pageNum, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        PageInfo<Date> pageInfo = dateService.page(user.getUsername(), pageNum);
        model.addAttribute("pageInfo", pageInfo);
        return "dateInfo";
    }

    @GetMapping("/date/add")
    public String add(){
        return "addDate";
    }
    @PostMapping("/date/handleAdd")
    public String handleAdd(Date date, HttpSession session, RedirectAttributes model){
        User user = (User)session.getAttribute("user");
        try {
            date.setUsername(user.getUsername());
            dateService.addDate(date);
            model.addFlashAttribute("msg", "添加成功！");
        }catch (Exception e){
            model.addFlashAttribute("msg", "该日已有行程，添加失败！");
        }

        return "redirect:/date/add";
    }

    @GetMapping("/date/edit")
    public String update(){
        return "editDate";
    }
    @PostMapping("/date/handleEdit")
    public String handleUpdate(Date date, HttpSession session, RedirectAttributes model){
        User user = (User) session.getAttribute("user");
        date.setUsername(user.getUsername());
        if (dateService.editDate(date) == 1){
            model.addFlashAttribute("msg", "修改成功！");
        }else {
            model.addFlashAttribute("msg","该日没有行程，修改失败！");
        }
        return "redirect:/date/edit";
    }

    @GetMapping("/date/delete")
    public String delete(){
        return "deleteDate";
    }
    @PostMapping("/date/handleDelete")
    public String handleDelete(@RequestParam String date, HttpSession session, RedirectAttributes model){
        User user = (User) session.getAttribute("user");
        if (dateService.deleteDate(user.getUsername(), date) == 1){
            model.addFlashAttribute("msg", "删除成功！");
        }else {
            model.addFlashAttribute("msg","该日没有行程，删除失败！");
        }
        return "redirect:/date/delete";
    }
}
