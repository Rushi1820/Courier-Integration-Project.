package com.Fastvan.Assignment.Fastvan.Assignment.Service;

import com.Fastvan.Assignment.Fastvan.Assignment.Entity.UserRole;
import com.Fastvan.Assignment.Fastvan.Assignment.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserRole addrole(UserRole userRole){
        return  userRoleRepository.save(userRole);
    }
}
