package com.yantianpeng.service;

import com.mysql.jdbc.StringUtils;
import com.yantianpeng.Utils.VerificationCodeImg;
import com.yantianpeng.entity.User;
import com.yantianpeng.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 注册用户
     * @param name
     * @param pwd
     * @return
     */
    public String regit(String name,String pwd){
        //1.生成Userid；
        String insertUUidSql="insert into uuid values(null)";
        jdbcTemplate.update(insertUUidSql);
        Long queryForObject = jdbcTemplate.queryForObject("select last_insert_id()", Long.class);
        //2。存放到集体的表里面
        String tableName = "user"+queryForObject%3;
        //3。插入到表中。
        String insertSqluser ="insert into "+tableName+" values( "+queryForObject+" ,"+"'"+name+"'"+","+"'"+pwd+"'"+")";
        System.out.println(insertSqluser);
        jdbcTemplate.update(insertSqluser);
        return "success";
    }

    /**
     *  根据用户id查询用户。
     * @param uuid
     * @return
     */
    public List<User> getUser(Long uuid){
        String tableName="user"+uuid%3;
        String selectUserByIdSql="select name from "+tableName+ " where id="+uuid;
        System.out.println("sql: "+selectUserByIdSql);
        String name = jdbcTemplate.queryForObject(selectUserByIdSql, String.class);
       List<User> list= new ArrayList<User>();
        User use= new User();
        use.setName(name);
        list.add(use);
        return list;

    }

    public BaseResponse ValitonIsTrue(String randomString){
        BaseResponse baseResponse =new BaseResponse();
        Map<String, Object> stringObjectMap = VerificationCodeImg.generateCodeAndPic();
        if(StringUtils.isNullOrEmpty(randomString)){
//            baseResponse.setCode(400);
//            baseResponse.setMessage("验证码为空");
            baseResponse.setSuccess(false);
            return  baseResponse;
        }
        if(randomString.equalsIgnoreCase((String) stringObjectMap.get("code").toString())){
            baseResponse.setSuccess(true);
//            baseResponse.setMessage("验证成功");
//            baseResponse.setCode(200);
            return baseResponse;
        }else{
            baseResponse.setSuccess(false);
//            baseResponse.setMessage("验证码不一致");
//            baseResponse.setCode(500);
            return baseResponse;
        }
    }
}


