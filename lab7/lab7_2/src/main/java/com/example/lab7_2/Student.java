package com.example.lab7_2;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Double ieltsScore;

    public Student(String name, Integer age, String email, Double ieltsScore) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.ieltsScore = ieltsScore;
    }
}

