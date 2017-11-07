package com.sudin.foodCourt.foodcourtapp.Controller;

import com.sudin.foodCourt.foodcourtapp.Entity.Users;
import com.sudin.foodCourt.foodcourtapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("users") Users users,
                          Model model,
                          HttpServletRequest httpServletRequest) {
        Users users1=userService.save(users);
        model.addAttribute("user",users1);
        return "redirect:userList";
    }


    @RequestMapping("/userList")
    public String bookList(Model model) {
        List<Users> userList= userService.findAllUsers();
        model.addAttribute("userList", userList);
        return "userList";
    }

    @RequestMapping(value = "/removeUser",method = RequestMethod.POST)
    public String removeUser(
            @ModelAttribute("id") String id,Model model
    ){
        userService.removeOne(Long.parseLong(id.substring(8)));
        List<Users> userList=userService.findAllUsers();
        model.addAttribute("userList",userList);
        return "redirect:userList";
    }

}
