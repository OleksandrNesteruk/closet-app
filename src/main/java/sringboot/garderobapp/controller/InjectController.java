package sringboot.garderobapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sringboot.garderobapp.model.Role;
import sringboot.garderobapp.model.Season;
import sringboot.garderobapp.model.User;
import sringboot.garderobapp.service.AuthenticationService;
import sringboot.garderobapp.service.RoleService;
import sringboot.garderobapp.service.SeasonService;

@RestController
@RequestMapping("/inject")
@RequiredArgsConstructor
public class InjectController {
    private final AuthenticationService authenticationService;
    private final RoleService roleService;
    private final SeasonService seasonService;
    @PostMapping
    public String inject() {
        roleService.add(new Role(Role.RoleName.ROLE_ADMIN));
        roleService.add(new Role(Role.RoleName.ROLE_USER));
        seasonService.add(new Season(Season.SeasonName.WINTER));
        seasonService.add(new Season(Season.SeasonName.SPRING));
        seasonService.add(new Season(Season.SeasonName.SUMMER));
        seasonService.add(new Season(Season.SeasonName.AUTUMN));

        User register = authenticationService.register("alex@i.ua", "12345678", "Alex", "Popusk");
        register.getRoles().add(roleService.getByName(Role.RoleName.ROLE_ADMIN.name()));
        return "done";
    }
}
