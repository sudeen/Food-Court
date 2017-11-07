package com.sudin.foodCourt.foodcourtapp.Service.Impls;

import com.sudin.foodCourt.foodcourtapp.Entity.Users;
import com.sudin.foodCourt.foodcourtapp.Repository.UserRepository;
import com.sudin.foodCourt.foodcourtapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }

    @Override
    public List<Users> findAllUsers() {
        return (List<Users>) userRepository.findAll();
    }

    @Override
    public void removeOne(Long id) {
        userRepository.delete(id);
    }

    @Override
    public Users findOne(Long id) {
        return userRepository.findOne(id);
    }
}
