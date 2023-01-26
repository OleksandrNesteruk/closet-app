package sringboot.garderobapp.repository.specification.cloth;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.SetJoin;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import sringboot.garderobapp.model.Clothing;
import sringboot.garderobapp.model.Season;
import sringboot.garderobapp.repository.specification.SpecificationProvider;
import sringboot.garderobapp.service.SeasonService;

@Component
@RequiredArgsConstructor
public class ClothingSeasonInSpecification implements SpecificationProvider<Clothing> {
    private static final String FILTER_KEY = "seasonIn";
    private static final String FIELD_NAME = "name";
    private final SeasonService seasonService;

    @Override
    public Specification<Clothing> getSpecification(String[] seasons) {
        return (root, query, criteriaBuilder) -> {
            SetJoin<Clothing, Season> clothing = root.joinSet("seasons", JoinType.LEFT);
            CriteriaBuilder.In<Object> predicate = criteriaBuilder.in(clothing.get(FIELD_NAME));
            for (String value : seasons) {
                predicate.value(seasonService.getByName(value.toUpperCase()).getName());
            }
            return criteriaBuilder.and(predicate, predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }

}
