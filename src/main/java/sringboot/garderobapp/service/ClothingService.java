package sringboot.garderobapp.service;

import org.springframework.data.domain.Page;
import sringboot.garderobapp.model.Clothing;
import java.util.Map;

public interface ClothingService {
    Clothing add(Clothing clothing);

    Clothing get(Long id);

    Page<Clothing> findAll(Map<String, String> params);

    void delete(Long id);
}
