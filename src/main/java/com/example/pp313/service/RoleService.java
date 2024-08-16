package com.example.pp313.service;

import com.example.pp313.model.Role;

import java.util.Collection;
import java.util.Optional;

public interface RoleService {
    Collection<Role> allRoles();
    Optional<Role> findByName(String name);
}
