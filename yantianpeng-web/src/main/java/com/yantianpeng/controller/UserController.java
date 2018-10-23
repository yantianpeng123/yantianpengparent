package com.yantianpeng.controller;


import com.yantianpeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/regit")
    public String regit(String name,String pwd){
        return userService.regit(name,pwd);
    }

    /**
     * 根据ID查找用户
     * @param uuid
     * @return
     */
    @RequestMapping("/QueryUserById")
    public String QueryUserById(Long uuid){
       return userService.getUser(uuid);
    }

}
