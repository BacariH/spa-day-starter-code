package org.launchcode.spaday.controllers;


import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String renderIndex(){
        return "user/index";
    }

    @GetMapping("add")
    public String displayAddUserForm(){
        return "user/add";
    }

    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        model.addAttribute("password", verify);
        if(verify == user.getPassword()){
            return "user/index";
        }

        return "user/add";
    }

}
