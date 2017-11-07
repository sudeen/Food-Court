package com.sudin.foodCourt.foodcourtapp.Service;

import com.sudin.foodCourt.foodcourtapp.Entity.Users;

import java.util.List;

public interface UserService {

    Users save(Users users);

    List<Users> findAllUsers();

    void removeOne(Long id);

    Users findOne(Long id);

}
