package sringboot.garderobapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sringboot.garderobapp.model.Role;
import sringboot.garderobapp.repository.RoleRepository;
import sringboot.garderobapp.service.RoleService;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleRepository.getRoleByName(Role.RoleName.valueOf(roleName)).orElseThrow(() ->
                new RuntimeException("Can't find role with name: " + roleName));
    }
}