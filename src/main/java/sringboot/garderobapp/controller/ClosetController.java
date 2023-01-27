package sringboot.garderobapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sringboot.garderobapp.dto.response.ClosetResponseDto;
import sringboot.garderobapp.dto.request.ClothingRequestDto;
import sringboot.garderobapp.dto.response.ClothingResponseDto;
import sringboot.garderobapp.mappers.ClosetMapper;
import sringboot.garderobapp.mappers.ClothingMapper;
import sringboot.garderobapp.model.Closet;
import sringboot.garderobapp.model.Clothing;
import sringboot.garderobapp.model.User;
import sringboot.garderobapp.service.ClosetService;
import sringboot.garderobapp.service.ClothingService;
import sringboot.garderobapp.service.UserService;

@RestController
@RequestMapping(value = "/closet")
@RequiredArgsConstructor
public class ClosetController {
    private final UserService userService;
    private final ClosetService closetService;
    private final ClothingService clothingService;
    private final ClothingMapper clothingMapper;
    private final ClosetMapper closetMapper;

    @PostMapping("/add-clothing")
    public ClothingResponseDto addClothingToCloset(@RequestBody ClothingRequestDto requestDto,
                                                   Authentication auth) {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        Clothing clothing = clothingMapper.mapToModel(requestDto);
        closetService.addClothing(clothing, user);
        return clothingMapper.mapToDto(clothing);
    }

    @PutMapping("/update-clothing/{id}")
    public boolean updateClothingInCloset(@PathVariable Long id,
                                       @RequestBody ClothingRequestDto requestDto,
                                       Authentication auth) {
        Closet closet = getCloset(auth);
        Clothing clothingToRemove = closetService.findClothingById(id, closet);
        Clothing updatedClothing = clothingMapper.mapToModel(requestDto);
        updatedClothing.setId(id);
        int index = closet.getClothes().indexOf(clothingToRemove);
        closet.getClothes().set(index, updatedClothing);
        clothingService.add(updatedClothing);
        return closet.getClothes().contains(updatedClothing);
    }

    @GetMapping("/by-user")
    public ClosetResponseDto getByUser(Authentication auth) {
        Closet closet = getCloset(auth);
        return closetMapper.mapToDto(closet);
    }

    @DeleteMapping("/delete-clothing/{id}")
    public boolean delete(@PathVariable Long id, Authentication auth) {
        Closet closet = getCloset(auth);
        Clothing clothingToDelete = closetService.findClothingById(id, closet);
        closet.getClothes().remove(clothingToDelete);
        clothingService.delete(clothingToDelete.getId());
        return !closet.getClothes().contains(clothingToDelete);
    }

    private Closet getCloset(Authentication auth) {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        return closetService.getByUser(user);
    }
}
