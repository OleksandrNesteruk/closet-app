package sringboot.garderobapp.repository.specification.cloth;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import sringboot.garderobapp.model.Clothing;
import sringboot.garderobapp.repository.specification.SpecificationProvider;

@Component
public class ClothingSizeInSpecification implements SpecificationProvider<Clothing> {
    private static final String FILTER_KEY = "sizeIn";
    private static final String FIELD_NAME = "size";

    @Override
    public Specification<Clothing> getSpecification(String[] sizes) {
        return (root, query, criteriaBuilder) -> {
            CriteriaBuilder.In<String> predicate = criteriaBuilder.in(root.get(FIELD_NAME));
            for (String value : sizes) {
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
