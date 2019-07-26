package com.xx.service;

import com.xx.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    User loginByUserId(String snum);

    List<User> selectAllUsers();

    User selectUserById(Integer id);

    void  register(User user);

    void updateUser(User user);

    User selectUser(User user);
}
