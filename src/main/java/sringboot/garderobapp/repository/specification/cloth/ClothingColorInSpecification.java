package sringboot.garderobapp.repository.specification.cloth;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import sringboot.garderobapp.model.Clothing;
import sringboot.garderobapp.repository.specification.SpecificationProvider;

@Component
public class ClothingColorInSpecification implements SpecificationProvider<Clothing> {
    private static final String FILTER_KEY = "colorIn";
    private static final String FIELD_NAME = "color";

    @Override
    public Specification<Clothing> getSpecification(String[] colors) {
        return (root, query, criteriaBuilder) -> {
          CriteriaBuilder.In<String> predicate = criteriaBuilder.in(root.get(FIELD_NAME));
          for (String value : colors) {
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
