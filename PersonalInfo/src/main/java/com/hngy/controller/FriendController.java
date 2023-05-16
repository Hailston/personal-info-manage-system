package com.hngy.controller;

import com.github.pagehelper.PageInfo;
import com.hngy.entity.Friend;
import com.hngy.entity.User;
import com.hngy.service.FriendService;
import com.hngy.util.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * @author 6-126
 * @date 2023/4/30 14:39
 */
@Controller
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping("/friend")
    public String pageFriend(@RequestParam(defaultValue = "1") Integer pageNum, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        PageInfo<Friend> page = friendService.page(user.getUsername(), pageNum);
        model.addAttribute("pageInfo", page);
        return "friendInfo";
    }

    @GetMapping("/friend/add")
    public String addFriend(Model model) {
        model.addAttribute("provinces", DataUtils.provinces);
        return "addFriend";
    }

    @PostMapping("/friend/handleAdd")
    public String handleAdd(Friend friend, RedirectAttributes model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        friend.setUsername(user.getUsername());
        try {
            friendService.addFriend(friend);
            model.addFlashAttribute("msg", "添加成功！");
        } catch (Exception e) {
            model.addFlashAttribute("msg", "添加失败！");
        }
        return "redirect:/friend/add";
    }

    @GetMapping("/friend/edit")
    public String editFriend(String name, Model model, HttpSession session) {
        if (!Objects.isNull(name)) {
            User user = (User) session.getAttribute("user");
            Friend friend = friendService.getFriend(user.getUsername(), name);
            if (!Objects.isNull(friend)){
                model.addAttribute("provinces", DataUtils.provinces);
                model.addAttribute("friend", friend);
                return "editFriendForm";
            }
            model.addAttribute("msg", "通讯录没有该联系人!");
        }
        return "editFriend";
    }

    @PostMapping("/friend/handleEdit")
    public String handleEdit(Friend friend, HttpSession session, Model model){
        try {
            User user = (User) session.getAttribute("user");
            friend.setUsername(user.getUsername());
            friendService.editFriend(friend);
            model.addAttribute("friend", friend);
            model.addAttribute("provinces", DataUtils.provinces);
            model.addAttribute("msg", "修改成功");
        }catch (Exception e){
            model.addAttribute("msg", "修改失败");
        }
        return "editFriendForm";
    }

    @GetMapping("/friend/delete")
    public String delete(String name, Model model, HttpSession session){
        if (!Objects.isNull(name)) {
            User user = (User) session.getAttribute("user");
            int row = friendService.deleteFriend(user.getUsername(), name);
            if (row == 1){
                model.addAttribute("msg", "删除成功!");
            }else {
                model.addAttribute("msg","该通讯录中没有该联系人，删除失败！");
            }
        }
        return "deleteFriend";
    }

}
