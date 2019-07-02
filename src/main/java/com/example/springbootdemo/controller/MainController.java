package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //tags this class as a Controller
@RequestMapping("/demo") // URL's start with /demo after Application path
public class MainController {
    @Autowired // will automatically get the bean called userRepository which will be used to handle data
    private UserRepository userRepository;

    @GetMapping(path = "/add") //Get request, equals to @RequestMapping(method = GET)
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email) {
        //@ResponseBody means the returned String is the response, not a view name
        //@RequestParam means it is a parameter from the Get or Post request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved!";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        //returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
