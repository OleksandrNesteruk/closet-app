package sringboot.garderobapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sringboot.garderobapp.service.SortOrderService;

@Service
public class SortOrderServiceImpl implements SortOrderService {
    public static final String ORDER_SEPARATOR = ":";
    public static final String FIELD_SEPARATOR = ";";
    public static final Integer FIELD_INDEX = 0;
    public static final Integer SORT_ORDER_INDEX = 1;

    @Override
    public List<Sort.Order> sortOrders(String sortBy) {
        List<Sort.Order> orders = new ArrayList<>();
        if (sortBy.contains(ORDER_SEPARATOR)) {
            String[] sortingFields = sortBy.split(FIELD_SEPARATOR);
            for (String field: sortingFields) {
                Sort.Order order;
                if (field.contains(ORDER_SEPARATOR)) {
                    String[] fieldsAndDirections = field.split(ORDER_SEPARATOR);
                    order = new Sort.Order(Sort.Direction
                            .valueOf(fieldsAndDirections[SORT_ORDER_INDEX]),
                            fieldsAndDirections[FIELD_INDEX]);
                } else {
                    order = new Sort.Order(Sort.Direction.DESC, field);
                }
                orders.add(order);
            }
        } else {
            Sort.Order order = new Sort.Order(Sort.Direction.DESC, sortBy);
            orders.add(order);
        }
        return orders;
    }
}