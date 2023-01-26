package sringboot.garderobapp.repository.specification.cloth;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import sringboot.garderobapp.model.Clothing;
import sringboot.garderobapp.repository.specification.SpecificationProvider;

@Component
public class ClothingBrandInSpecification implements SpecificationProvider<Clothing> {
    private static final String FILTER_KEY = "brandIn";
    private static final String FIELD_NAME = "brand";

    @Override
    public Specification<Clothing> getSpecification(String[] brands) {
        return (root, query, criteriaBuilder) -> {
            CriteriaBuilder.In<String> predicate = criteriaBuilder.in(root.get(FIELD_NAME));
            for (String value : brands) {
                predicate.value(value);
            }
            return criteriaBuilder.and(predicate, predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
