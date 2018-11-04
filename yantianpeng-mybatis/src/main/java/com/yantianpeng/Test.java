package com.yantianpeng;

import com.yantianpeng.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class Test {
    public static void main(String[] args) throws Exception{
        String string  ="mybatis.xml";
        Reader resourceAsReader = Resources.getResourceAsReader(string);
        //获取会话工厂
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //获取会话
        SqlSession sqlSession = build.openSession();
        String sql="com.yantianpeng.mapper.UserMapping.getUser";
        User user =sqlSession.selectOne(sql,1);
        System.out.println(user.toString());
    }
}
