package com.it.aop.service;

import com.it.aop.dao.UserDao;
import com.it.aop.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    public void addUser(Users u){
        userDao.add(u);
    }

    @Override
    public Integer getCount() {
        return userDao.getUsersCount();
    }

    @Override
   // @Transactional(readOnly = true)
    public Users getUsersById(int id) {
        return userDao.getUsersById(id);
    }

    @Override
    public List<Users> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public void zhuanzhang(int id1, int id2, double money) {
        //从账户id为id1的用户减钱
        userDao.reduceMoney(id1,money);
       // int i = 1/0;
        userDao.addMoney(id2,money);
    }
}
