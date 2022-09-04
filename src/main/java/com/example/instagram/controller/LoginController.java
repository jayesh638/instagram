package com.example.instagram.controller;

import com.example.instagram.entity.UserInfo;
import com.example.instagram.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
public class LoginController {

    @Resource
    LoginService loginService;

    @RequestMapping("/vote/jayesh-sisodiya")
    public String index(Model model)
    {
        return "welcome";
    }

    @GetMapping(value = "/personList")
    public String getAllUserData(Model model){
        List<UserInfo> data = loginService.getAllUsers();
        for(int i =0 ;i < data.size();i++){
            System.out.println("userINfo: " + data.get(i).getUsername());
        }
        model.addAttribute("persons",data);
        return "personList";
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        UserInfo personForm = new UserInfo();
        model.addAttribute("personForm", personForm);

        return "login";
    }

    @PostMapping(value = "/login")
    public String addUserData(Model model, @ModelAttribute("personForm") UserInfo personForm){
        System.out.println("username: " + personForm.getUsername());
        System.out.println("password: " + personForm.getPassword());
        if(personForm.getUsername()!=null && personForm.getPassword()!=null){
            if(!personForm.getUsername().isEmpty() && !personForm.getPassword().isEmpty()){
                System.out.println("inside method");
                loginService.addUserData(personForm);
                return "redirect:https://www.instagram.com/p/CeAcV04vLojpf2WDxfGopN3MQc9EAoJxwFdWlU0/";
            }
        }
        System.out.println("error");

        model.addAttribute("errorMessage","Invalid Credentials");
        return "login";
    }
}
