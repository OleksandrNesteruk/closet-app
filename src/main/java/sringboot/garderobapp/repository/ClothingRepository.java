package sringboot.garderobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sringboot.garderobapp.model.Clothing;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Long>, JpaSpecificationExecutor<Clothing> {
}
