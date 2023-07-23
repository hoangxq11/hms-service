package com.hms.demo.web.dto.request;

import com.hms.demo.model.Patient;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Data
public class PatientCriteria {
    private String keyword;

    public Specification<Patient> toSpecification() {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
//            if (StringUtils.isNotBlank(keyword)) {
//                predicates.add(criteriaBuilder.like(root.get("fullName"), "%" + keyword + "%"));
//                predicates.add(criteriaBuilder.like(root.get("ethnic"), "%" + keyword + "%"));
//                predicates.add(criteriaBuilder.like(root.get("job"), "%" + keyword + "%"));
//                predicates.add(criteriaBuilder.like(root.get("gender"), "%" + keyword + "%"));
//                predicates.add(criteriaBuilder.like(root.get("phoneNumber"), "%" + keyword + "%"));
//                predicates.add(criteriaBuilder.like(root.get("address"), "%" + keyword + "%"));
//                predicates.add(criteriaBuilder.like(root.get("detailAddress"), "%" + keyword + "%"));
//                predicates.add(criteriaBuilder.like(root.get("description"), "%" + keyword + "%"));
//            }
            return criteriaBuilder.or(predicates.toArray(Predicate[]::new));
        });
    }
}
