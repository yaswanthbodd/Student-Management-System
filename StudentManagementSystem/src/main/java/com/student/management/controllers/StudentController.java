package com.student.management.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.entities.Student;
import com.student.management.exceptions.StudentNotFoundException;
import com.student.management.repositories.StudentRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	// Get All Student Details in API
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	// Registered the Student Details
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	// Get Student Details By ID given by the user
	@GetMapping("/students/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable String studentId){
		Student student = studentRepository.findById(studentId).orElseThrow(
				()-> new StudentNotFoundException("Student with Student Id "+studentId+" does not exist."));
				return ResponseEntity.ok(student);
	}
	
	// Update the values of the student
	@PutMapping("/students/{studentId}")
	public ResponseEntity<Student> updateStudent(@PathVariable String studentId, @RequestBody Student studentDetails){
		Student student = studentRepository.findById(studentId).orElseThrow(
				()->new StudentNotFoundException("Student with Student Id "+studentId+" does not exist."));
		student.setStudentName(studentDetails.getStudentName());
		student.setStudentBranch(studentDetails.getStudentBranch());
		student.setStudentCgpa(studentDetails.getStudentCgpa());
		student.setStudentCollege(studentDetails.getStudentCollege());
		student.setStudentYear(studentDetails.getStudentYear());
		studentRepository.save(student);
		return ResponseEntity.ok(student);
	}
	
	//Deleted the student record in the db
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<Map<String,Boolean>> deleteStudent(@PathVariable String studentId){
		Student student = studentRepository.findById(studentId).orElseThrow(
				()-> new StudentNotFoundException("Student with Student Id "+studentId+" does not exist."));
		studentRepository.delete(student);
		Map<String,Boolean> response = new HashMap<String,Boolean>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

/*

API access url - http://localhost:8081/students

*/