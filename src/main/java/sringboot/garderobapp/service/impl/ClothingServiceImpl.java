package sringboot.garderobapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import sringboot.garderobapp.model.Clothing;
import sringboot.garderobapp.repository.ClothingRepository;
import sringboot.garderobapp.repository.specification.SpecificationManager;
import sringboot.garderobapp.service.ClothingService;
import sringboot.garderobapp.service.SortOrderService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ClothingServiceImpl implements ClothingService {
    private final ClothingRepository clothingRepository;
    private final SortOrderService sortOrderService;
    private final SpecificationManager<Clothing> clothingSpecificationManager;
    @Override
    public Clothing add(Clothing clothing) {
        return clothingRepository.save(clothing);
    }

    @Override
    public Clothing get(Long id) {
        return clothingRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Page<Clothing> findAll(Map<String, String> params) {
        Specification<Clothing> specification = null;
        List<Sort.Order> orders = new ArrayList<>();
        int size = 20, page = 0;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            switch (entry.getKey()) {
                case "sortBy" -> orders = sortOrderService.sortOrders(entry.getValue());
                case "size" -> size = Integer.parseInt(entry.getValue());
                case "page" -> page = Integer.parseInt(entry.getValue());
                default -> {
                    Specification<Clothing> sc = clothingSpecificationManager.get(entry.getKey(),
                            entry.getValue().split(","));
                    specification = specification == null
                            ? Specification.where(sc) : specification.and(sc);
                }
            }
        }
        if (orders.isEmpty()) {
            orders.add(new Sort.Order(Sort.Direction.ASC,"brand"));
        }
        Sort sortBy = Sort.by(orders);
        PageRequest pageRequest = PageRequest.of(page, size, sortBy);
        return clothingRepository.findAll(specification, pageRequest);
    }

    @Override
    public void delete(Long id) {
        clothingRepository.deleteById(id);
    }
}
