package com.example.studentmanagement.service;

import java.util.List;

import com.example.studentmanagement.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public Student saveStudent(Student student);

	public Student findById(Long id);

	public void deleteStudent(Long id);

}
