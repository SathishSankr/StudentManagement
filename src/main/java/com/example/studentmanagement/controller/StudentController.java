package com.example.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;

@Controller
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", service.findAll());
		return "students";
	}

	@GetMapping("/students/new")
	public String newStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";

	}

	@GetMapping("/students/editStudent/{id}")
	public String editStudent(@PathVariable long id, Model model) {
		model.addAttribute("student", service.findById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable long id, @ModelAttribute("student") Student student, Model model) {
		Student exist = service.findById(id);
		exist.setId(student.getId());
		exist.setFirstName(student.getFirstName());
		exist.setLastName(student.getLastName());
		exist.setEmail(student.getEmail());
		service.saveStudent(exist);
		return "redirect:/students";
	}

	@GetMapping("/students/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
		return "redirect:/students";

	}

}
