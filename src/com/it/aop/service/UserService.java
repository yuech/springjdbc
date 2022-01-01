package com.it.aop.service;

import com.it.aop.pojo.Users;

import java.util.List;

public interface UserService {
    public void addUser(Users u);
    public Integer getCount();
    public Users getUsersById(int id);
    public List<Users> getUsers();

    //转账
    public void zhuanzhang(int id1,int id2,double money);
}
