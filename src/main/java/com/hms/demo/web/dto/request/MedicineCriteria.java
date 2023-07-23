package com.hms.demo.web.dto.request;

import com.hms.demo.model.Medicine;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class MedicineCriteria {
    private String keyword;

    public Specification<Medicine> toSpecification() {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (Objects.nonNull(keyword)) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + keyword + "%"));
                predicates.add(criteriaBuilder.like(root.get("useManual"), "%" + keyword + "%"));
                predicates.add(criteriaBuilder.like(root.get("quantity"), "%" + keyword + "%"));
                predicates.add(criteriaBuilder.like(root.get("price"), "%" + keyword + "%"));
                predicates.add(criteriaBuilder.like(root.get("unit"), "%" + keyword + "%"));
                predicates.add(criteriaBuilder.like(root.get("supplier").get("name"), "%" + keyword + "%"));
            }
            return criteriaBuilder.or(predicates.toArray(Predicate[]::new));
        });
    }
}
