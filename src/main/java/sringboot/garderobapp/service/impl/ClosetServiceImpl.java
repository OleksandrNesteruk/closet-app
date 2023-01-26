package sringboot.garderobapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sringboot.garderobapp.model.Closet;
import sringboot.garderobapp.model.Clothing;
import sringboot.garderobapp.model.User;
import sringboot.garderobapp.repository.ClosetRepository;
import sringboot.garderobapp.service.ClosetService;
import sringboot.garderobapp.service.ClothingService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClosetServiceImpl implements ClosetService {
    private final ClosetRepository closetRepository;
    private final ClothingService clothingService;


    @Override
    public void addClothing(Clothing clothing, User user) {
        clothingService.add(clothing);
        Closet closet = closetRepository.getClosetByUser(user);
        closet.getClothes().add(clothing);
        closetRepository.save(closet);
    }

    @Override
    public Clothing findClothingById(Long id, Closet closet) {
        return closet.getClothes().stream()
                .filter(c -> Objects.equals(c.getId(), id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Can't find clothing with id " + id));
    }

    @Override
    public Closet getByUser(User user) {
        return closetRepository.getClosetByUser(user);
    }

    @Override
    public void registerCloset(User user) {
        Closet closet = new Closet();
        closet.setUser(user);
        closetRepository.save(closet);
    }
}
