package sringboot.garderobapp.service;


import sringboot.garderobapp.model.User;

public interface AuthenticationService {
    User register(String email, String password, String firstName, String lastName);
}
