import { Component, OnInit } from '@angular/core';
import { Student } from '../Student/student';
import { StudentService } from '../Student/student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrl: './create-student.component.css'
})
export class CreateStudentComponent implements OnInit {
  student: Student = new Student();
  constructor(private studentService : StudentService, private router:Router){}
  ngOnInit(): void {
  }

  onSubmit(){
    this.insertStudent();
    console.log(this.student);
  }

  insertStudent(){
    this.studentService.createStudent(this.student).subscribe(data=>{
      this.goToStudentList();
      console.log(data);
    })
  }
  goToStudentList(){
    this.router.navigate(['students'])
  }
}
