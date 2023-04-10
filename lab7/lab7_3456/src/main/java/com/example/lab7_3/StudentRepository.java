package com.example.lab7_3;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByAgeGreaterThanEqual(int age);
    long countByIeltsScore(double ieltsScore);
    List<Student> findByNameContainingIgnoreCase(String name);

    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    List<Student> ageGreaterOrEqual(int age);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.ieltsScore = :score")
    long countIelts(int score);

    @Query("SELECT s FROM Student s WHERE LOWER(s.name) LIKE CONCAT('%', LOWER(:name), '%')")
    List<Student> searchName(String name);
}
