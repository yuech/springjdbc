package com.it.aop.dao;

import com.it.aop.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void add(Users users){
        String sql = "insert into users(user_name,pwd,age)values(?,?,?)";
        jdbcTemplate.update(sql,users.getUserName(),users.getPwd(),users.getAge());
    }
    public void update(Users users){
        String sql = "update users set user_name=?,pwd=?,age=? where id=?";
        Object[] obj = new Object[]{users.getUserName(),users.getPwd(),users.getUserName(),users.getId()};
        jdbcTemplate.update(sql,obj);
    }
    public void delete(int id){
        String sql = "delete from users where id=?";
        jdbcTemplate.update(sql,id);
    }
    public Integer getUsersCount(){
        String sql = "select count(id) count from users";
        Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }
    public Users getUsersById(int id){
        String sql = "select id,user_name userName,pwd,age from users where id=?";
        Users u = jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Users>(Users.class));
        return u;
    }
    public List<Users> getUsers(){
        String sql = "select id,user_name userName,pwd,age from users";
        List<Users> users = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Users>(Users.class));
        return users;
    }
    /**
     * 以下操作是对用户表的money进行增加和减少
     */
    public void addMoney(int id,double money){
        String sql = "update users set money=money+? where id=?";
        jdbcTemplate.update(sql,money,id);
    }
    public void reduceMoney(int id,double money){
        String sql = "update users set money=money-? where id=?";
        jdbcTemplate.update(sql,money,id);
    }
    public void testGit(){}
    public void testGit2(){}
}
