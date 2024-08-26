package com.example.graphQL.graphql.resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.graphQL.graphql.dto.StudentInput;
import com.example.graphQL.graphql.model.Student;
import com.example.graphQL.graphql.service.StudentService;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class StudentResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final StudentService studentService;

    public StudentResolver(StudentService studentService) {
        this.studentService = studentService;
    }

 // Query for getting all students
    public List<Student> students() {
        return studentService.findAll();
    }

    // Query for getting a student by ID
    public Optional<Student> student(Long id) {
        return studentService.findById(id);
    }

    // Mutation for creating a student
    public Student createStudent(StudentInput studentInput) {
        Student student = new Student();
        student.setSname(studentInput.getSname());
        student.setAddress(studentInput.getAddress());
        student.setCourse(studentInput.getCourse());
        return studentService.save(student);
    }

    // Mutation for updating a student
    public Student updateStudent(Long id, StudentInput studentInput) {
        Optional<Student> optionalStudent = studentService.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setSname(studentInput.getSname());
            student.setAddress(studentInput.getAddress());
            student.setCourse(studentInput.getCourse());
            return studentService.save(student);
        }
        return null;
    }

    // Mutation for deleting a student
    public Boolean deleteStudent(Long id) {
        studentService.deleteById(id);
        return true;
    }
}
