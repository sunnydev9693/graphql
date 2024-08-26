package com.example.graphQL.graphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphQL.graphql.model.Student;
import com.example.graphQL.graphql.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
    	Student newStudent = studentRepository.save(student);
    	if(newStudent != null)
    		return studentRepository.save(student);
    	else
    		return new Student();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
	
}
