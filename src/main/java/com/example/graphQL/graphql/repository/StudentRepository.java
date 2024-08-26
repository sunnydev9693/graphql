package com.example.graphQL.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphQL.graphql.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
