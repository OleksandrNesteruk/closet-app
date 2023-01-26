package sringboot.garderobapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sringboot.garderobapp.model.Season;
import sringboot.garderobapp.repository.SeasonRepository;
import sringboot.garderobapp.service.SeasonService;

@Service
@RequiredArgsConstructor
public class SeasonServiceImpl implements SeasonService {
    private final SeasonRepository seasonRepository;
    @Override
    public Season add(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public Season getByName(String name) {
        return seasonRepository.getSeasonByName(Season.SeasonName.valueOf(name))
                .orElseThrow(()->new RuntimeException("Can't find season with name: " + name));
    }

    @Override
    public Season getById(Long id) {
        return seasonRepository.getSeasonById(id)
                .orElseThrow(()->new RuntimeException("Can't find season with id: " + id));
    }
}
