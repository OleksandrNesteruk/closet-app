package sringboot.garderobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sringboot.garderobapp.model.Season;

import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    Optional<Season> getSeasonByName(Season.SeasonName name);
    Optional<Season> getSeasonById(Long id);
}
