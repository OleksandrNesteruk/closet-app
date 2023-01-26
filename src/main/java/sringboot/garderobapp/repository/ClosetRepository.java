package sringboot.garderobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sringboot.garderobapp.model.Closet;
import sringboot.garderobapp.model.User;

@Repository
public interface ClosetRepository extends JpaRepository<Closet, Long> {
    Closet getClosetByUser(User user);
}
