package sringboot.garderobapp.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sringboot.garderobapp.model.Role;
import sringboot.garderobapp.model.Season;
import sringboot.garderobapp.model.User;
import sringboot.garderobapp.service.RoleService;
import sringboot.garderobapp.service.SeasonService;
import sringboot.garderobapp.service.UserService;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;
    private final SeasonService seasonService;
    @PostConstruct
    public void inject() {
        seasonService.add(new Season(Season.SeasonName.WINTER));
        seasonService.add(new Season(Season.SeasonName.SPRING));
        seasonService.add(new Season(Season.SeasonName.SUMMER));
        seasonService.add(new Season(Season.SeasonName.AUTUMN));
        Role adminRole = new Role();
        adminRole.setName(Role.RoleName.ROLE_ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setName(Role.RoleName.ROLE_USER);
        roleService.add(userRole);
        User user = new User();
        user.setEmail("admin@i.ua");
        user.setPassword("admin1234");
        user.setRoles(Set.of(adminRole));
        userService.add(user);
    }
}
