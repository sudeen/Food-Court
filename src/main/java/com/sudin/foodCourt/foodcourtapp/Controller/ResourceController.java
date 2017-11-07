package com.sudin.foodCourt.foodcourtapp.Controller;

import com.sudin.foodCourt.foodcourtapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ResourceController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/removeList", method = RequestMethod.POST)
    public String removeList(
            @RequestBody ArrayList<String> userList, Model model
    ) {
        for (String id : userList) {
            String bookId = id.substring(8);
            userService.removeOne(Long.parseLong(bookId));
        }
        return "delete success";
    }


}
