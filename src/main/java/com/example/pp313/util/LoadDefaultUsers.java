package com.example.pp313.util;

import com.example.pp313.dao.RoleDao;
import com.example.pp313.model.Role;
import com.example.pp313.model.User;
import com.example.pp313.service.RoleService;
import com.example.pp313.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoadDefaultUsers {
    private final RoleService roleService;
    private final UserService userService;
    private final RoleDao roleDao;

    public LoadDefaultUsers(RoleService roleService, UserService userService, RoleDao roleDao) {
        this.roleService = roleService;
        this.userService = userService;
        this.roleDao = roleDao;
    }

    @PostConstruct
    public void createUsersWithRoles() {
        if (roleService.allRoles().isEmpty()) {
            Role roleAdmin = new Role("ROLE_ADMIN");
            roleDao.save(roleAdmin);
            List<Role> role_ad = new ArrayList<>();
            role_ad.add(roleAdmin);
            User admin = new User();
            admin.setAge(23);
            admin.setFirstName("ded");
            admin.setLastName("stariy");
            admin.setUserName("mashina");
            admin.setPassword("old");
            admin.setRoles(role_ad);
            userService.add(admin); // Login: mashina; Password: old

            Role roleUser = new Role("ROLE_USER");
            roleDao.save(roleUser);
            List<Role> role_us = new ArrayList<>();
            role_us.add(roleUser);
            User user = new User();
            user.setAge(23);
            user.setFirstName("adam");
            user.setLastName("ivanov");
            user.setUserName("foo");
            user.setPassword("1111");
            user.setRoles(role_us);
            userService.add(user); // Login: foo; Password: 1111

        }
    }
}
