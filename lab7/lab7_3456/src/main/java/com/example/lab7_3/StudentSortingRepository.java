package com.example.lab7_3;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSortingRepository extends PagingAndSortingRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    List<Student> findByAgeGreaterOrEqual(int age, Sort sort);

    @Query("SELECT s FROM Student s WHERE s.ieltsScore = :ieltsScore")
    int countByIelts(int ieltsScore);

    @Query("SELECT s FROM Student s WHERE lower(s.name) like lower(concat('%', :name, '%'))")
    List<Student> findByNameContaining(String name, Pageable pageable);

}

