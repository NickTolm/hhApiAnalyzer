//package com.example.hhapianalyzer.dto.vacancies;
//
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Predicate;
//import jakarta.persistence.criteria.Root;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.util.StringUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RequiredArgsConstructor
//public class VacancySpecification implements Specification<VacancyDto> {
//    private final Searcher searcher;
//
//    @Override
//    public Predicate toPredicate(Root<VacancyDto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//
//        List<Predicate> predicates = new ArrayList<>();
//
//        if (!StringUtils.isEmpty(searcher.getName())) {
//            predicates.add(criteriaBuilder.like(root.get("name"), "%" + searcher.getName() + "%"));
//        }
//
//
//
//        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//    }
//}
