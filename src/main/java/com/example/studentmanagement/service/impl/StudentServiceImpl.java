package com.example.studentmanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studentmanagement.dao.StudentRepository;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	public StudentRepository repo;

	public StudentServiceImpl(StudentRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return repo.save(student);
	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();

	}

	@Override
	public void deleteStudent(Long id) {
		repo.deleteById(id);
	}

}
