package com.example.helloidea.mapper;

import com.example.helloidea.bean.User;

public interface UserMapper {

    Integer insert(User user);

    User findById(Integer id);
}
