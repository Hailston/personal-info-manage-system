package com.hngy.controller;

import com.hngy.entity.User;
import com.hngy.service.UserService;
import com.hngy.util.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author 6-126
 * @date 2023/4/28
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/handleLogin")
    public String handleLogin(@RequestParam String username, @RequestParam String password, RedirectAttributes model, HttpSession session){
        User user = userService.login(username, password);
        if (user != null){
            session.setAttribute("user", user);
            return "redirect:/index";
        }
        model.addFlashAttribute("msg", "登录失败，账号或密码错误！");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("provinces", DataUtils.provinces);
        return "register";
    }

    @PostMapping("/handleRegister")
    public String handleRegister( User user, RedirectAttributes model){
        if (userService.addUser(user)) {
            model.addFlashAttribute("msg", "注册成功请登录!");
        }else {
            model.addFlashAttribute("msg", "注册失败，登录名字已存在！");
        }
        return "redirect:/login";
    }

    @GetMapping("/userInfo")
    public String userInfo(){
        return "userInfo";
    }

    @GetMapping("/userInfo/edit")
    public String editUserInfo(Model model){
        List<String> edu = Arrays.asList("博士","硕士","本科","专科","高中","初中");
        List<String> work = Arrays.asList("软件开发工程师","前端开发工程师","后端开发工程师","全栈开发工程师", "码农");
        model.addAttribute("edu", edu);
        model.addAttribute("work", work);
        return "userInfoEdit";
    }

    @PostMapping("/userInfo/handleEdit")
    public String handleEditUserInfo(@RequestParam String edu, @RequestParam String work,
                                     @RequestParam String phone, @RequestParam String email, HttpSession session,RedirectAttributes model ){
        User user = (User) session.getAttribute("user");
        try {
            userService.editUserInfo(user.getUsername(),edu, work, phone, email);
            model.addFlashAttribute("msg", "修改成功!");
            // 修改成功后更新 session 里面的用户信息
            user.setEdu(edu);
            user.setWork(work);
            user.setPhone(phone);
            user.setEmail(email);
            session.setAttribute("user", user);
        }catch (Exception e){
            model.addFlashAttribute("msg", "修改失败");
        }
        return "redirect:/userInfo/edit";
    }

    @GetMapping("/userInfo/editPassword")
    public String editPassword(){
        return "editPassword";
    }
    @PostMapping("/userInfo/handleEditPassword")
    public String handleEditPassword(@RequestParam String password, HttpSession session, RedirectAttributes model){
        User user = (User)session.getAttribute("user");
        try {
            userService.editPassword(user.getUsername(), password);
            model.addFlashAttribute("msg", "修改成功！");
            user.setPassword(password);
            session.setAttribute("user", user);
        }catch (Exception e){
            model.addFlashAttribute("msg", "修改失败！");
        }
        return "redirect:/userInfo/editPassword";
    }
}
