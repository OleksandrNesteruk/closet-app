package sringboot.garderobapp.repository.specification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import sringboot.garderobapp.model.Clothing;
import java.util.Map;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ClothingSpecificationManager implements SpecificationManager<Clothing> {
    private final Map<String, SpecificationProvider<Clothing>> providerMap;

    @Autowired
    public ClothingSpecificationManager(List<SpecificationProvider<Clothing>> clothingSpecifications) {
        this.providerMap = clothingSpecifications.stream()
                .collect(Collectors.toMap(SpecificationProvider::getFilterKey,
                        Function.identity()));
    }

    @Override
    public Specification<Clothing> get(String filterKey, String[] params) {
        if (!providerMap.containsKey(filterKey)) {
            throw new RuntimeException("Key " + filterKey + " is not supported for data filtering");
        }
        return providerMap.get(filterKey).getSpecification(params);
    }
}
