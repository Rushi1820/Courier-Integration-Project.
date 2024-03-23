package com.Fastvan.Assignment.Fastvan.Assignment.Controller;

import com.Fastvan.Assignment.Fastvan.Assignment.Entity.User;
import com.Fastvan.Assignment.Fastvan.Assignment.Entity.UserRole;
import com.Fastvan.Assignment.Fastvan.Assignment.Service.UserRoleService;
import com.Fastvan.Assignment.Fastvan.Assignment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ontrac/orders")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;
    @PostMapping("/adduser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        if (user.getRole() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/addrole")
    public UserRole addRole(@RequestBody UserRole userRole){
        return userRoleService.addrole(userRole);
    }

}
