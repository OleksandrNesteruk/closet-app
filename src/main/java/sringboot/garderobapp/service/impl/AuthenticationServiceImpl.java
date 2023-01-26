package sringboot.garderobapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sringboot.garderobapp.model.Role;
import sringboot.garderobapp.model.User;
import sringboot.garderobapp.service.AuthenticationService;
import sringboot.garderobapp.service.ClosetService;
import sringboot.garderobapp.service.RoleService;
import sringboot.garderobapp.service.UserService;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final ClosetService closetService;
    private final UserService userService;
    private final RoleService roleService;

    @Override
    public User register(String email, String password, String firstName, String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(Set.of(roleService.getByName(Role.RoleName.ROLE_USER.name())));
        userService.add(user);
        closetService.registerCloset(user);
        return user;
    }
}
