import { Component, OnInit } from '@angular/core';
import { Student } from '../Student/student';
import { Router } from '@angular/router';
import { StudentService } from '../Student/student.service'; // Add this import

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrl: './list-student.component.css'
})
export class ListStudentComponent implements OnInit {
  students: Student[] = [];
  constructor(private studentService: StudentService, private router:Router){}
  ngOnInit(): void {
    this.getStudents();
  }

  private getStudents(){
    this.studentService.getStudentList().subscribe(data => {
      this.students = data;
    })
  }

  updateStudent(studentId: string){
    this.router.navigate(['update-student',studentId])
  }

  deleteStudent(studentId: string){
    this.studentService.deleteStudentById(studentId).subscribe(data=>{
      console.log(data);
      this.getStudents();
    })
  }
}
