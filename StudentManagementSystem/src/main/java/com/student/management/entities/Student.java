package com.student.management.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table ( name = "students")
public class Student {
	
	@Id
	@Column(name = "student_id")
	private String studentId;
	@Column( name = "student_name")
	private String studentName;
	@Column(name = "student_year")
	private int studentYear;
	@Column(name = "student_branch")
	private String studentBranch;
	@Column(name = "student_college")
	private String studentCollege;
	@Column(name = "student_cgpa")
	private double studentCgpa;
}
