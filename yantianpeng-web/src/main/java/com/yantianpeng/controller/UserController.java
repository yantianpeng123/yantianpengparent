package com.yantianpeng.controller;


import com.yantianpeng.entity.User;
import com.yantianpeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController//返回json数据
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 注册用户
     * @param name
     * @param pwd
     * @return
     */
    @CrossOrigin
    @RequestMapping("/regit")
    public String regit(String name,String pwd){
        return userService.regit(name,pwd);
    }

    /**
     * 根据ID查找用户
     * @param uuid
     * @return
     */
    @CrossOrigin
    @RequestMapping("/QueryUserById")
    public List<User> QueryUserById(String uuid){
        Long uid =Long.parseLong(uuid);
       return userService.getUser(uid);
    }

    /**
     * 验证验证码是否一致
     * @param randomString
     * @return
     */
//    @CrossOrigin
//    @RequestMapping("/ValitonIsTrue")
//    public BaseResponse ValitonIsTrue(String randomString){
//        return userService.ValitonIsTrue(randomString);
//    }

}
