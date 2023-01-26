package sringboot.garderobapp.repository.specification.cloth;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import sringboot.garderobapp.model.Clothing;
import sringboot.garderobapp.repository.specification.SpecificationProvider;

@Component
public class ClothingPriceInSpecification implements SpecificationProvider<Clothing> {
    private static final String FILTER_KEY = "priceIn";
    private static final String FIELD_NAME = "price";

    @Override
    public Specification<Clothing> getSpecification(String[] prices) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate;
            if (prices.length > 1) {
                predicate = criteriaBuilder.between(root.get(FIELD_NAME), prices[0], prices[1]);
            } else {
                predicate = criteriaBuilder.greaterThanOrEqualTo(root.get(FIELD_NAME), prices[0]);
            }
            return predicate;
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }

}
