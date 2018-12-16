package world.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

public interface Specification<T> {
    Predicate toPredicate(CriteriaBuilder cb, Root<T> root);
}
