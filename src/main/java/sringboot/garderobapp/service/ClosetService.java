package sringboot.garderobapp.service;

import sringboot.garderobapp.model.Closet;
import sringboot.garderobapp.model.Clothing;
import sringboot.garderobapp.model.User;

public interface ClosetService {
    void addClothing(Clothing clothing, User user);
    Clothing findClothingById(Long id, Closet closet);
    Closet getByUser(User user);

    void registerCloset(User user);
}
