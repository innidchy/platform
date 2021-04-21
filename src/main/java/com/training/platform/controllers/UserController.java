package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/ser1")
    public List<User> index() {
        // Change from UserRepository to UserService
        return userService.findAllByJpqlParamsQuery(0, "bangkok");
    }
    @GetMapping(value = "/ser2")
    public List<User> ser2(@RequestParam String Active,String city) {
        return userService.findAllByParamsQuery(0, "nakornpathom");
    }
    @GetMapping(value = "/ser3")
    public List<User> ser3() {

        return userService.findAllByJpqlQuery();
    }
    @GetMapping(value = "/ser4")
    public List<User> ser4() {

        return userService.findAllByQuery();
    }

    @GetMapping(value = "/ser5")
    public List<User> ser5(@RequestParam (name="age") List<Integer>ageList){
        return userService.findByAgeIn(ageList);
    }

    @GetMapping(value = "/ser6")
    public List<User> ser6() {

        return userService.findAll();
    }
    @GetMapping(value = "/ser7")
    public Optional<User>ser7(@PathVariable Integer id){
        return userService.findById(id);
    }
    @GetMapping(value = "/ser8")
    public Page<User>findAllByLimit(@RequestParam Integer start,@RequestParam Integer limit,@RequestParam String field) {
        PageRequest findAllByLimit = PageRequest.of(start, limit, Sort.by(Sort.Direction.ASC, field));
        return userService.findAllByLimit(start,limit,field);
    }
    @GetMapping(value = "/ser9")
    public List<User> findByCityAndActiveAndAge(@RequestParam String city, @RequestParam Integer active, @RequestParam Integer age) {
        return userService.findByCityAndActiveAndAge(city, active, age);
    }
    @GetMapping(value = "/ser10")
    public Collection<User> ser10(@RequestParam Integer active) {
        return userService.findAllActiveUsers(active);
    }
    @GetMapping(value = "/ser11")
    public List<User> findAllUsers(Sort sort){
        return userService.findAllUsers(sort);
    }

}



