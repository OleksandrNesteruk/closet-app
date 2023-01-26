package sringboot.garderobapp.service;

import sringboot.garderobapp.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
