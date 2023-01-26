package sringboot.garderobapp.service;

import sringboot.garderobapp.model.Season;

public interface SeasonService {
    Season add(Season season);

    Season getByName(String name);

    Season getById(Long id);
}
