package com.example.DoThanhPhuong_2011062697.services;

import com.example.DoThanhPhuong_2011062697.entity.User;
import com.example.DoThanhPhuong_2011062697.repository.IuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IuserRepository userRepository;
//    @Autowired
//    private IRoleRepository roleRepository;
    public void save(User user) {
        userRepository.save(user);
    }
}
