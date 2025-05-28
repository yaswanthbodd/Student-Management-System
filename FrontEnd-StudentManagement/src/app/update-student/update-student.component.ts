import { Component, OnInit } from '@angular/core';
import { Student } from '../Student/student';
import { StudentService } from '../Student/student.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrl: './update-student.component.css'
})
export class UpdateStudentComponent implements OnInit{
  studentId: string = '';
  student: Student= new Student();
  constructor(private studentService:StudentService, private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.studentId = this.route.snapshot.params['studentId'];
    this.studentService.getStudentById(this.studentId).subscribe(
      data => { this.student = data;}
    )
  }
  
  onSubmit(){
    this.studentService.updateStudent(this.studentId,this.student).subscribe(
      data=>{this.student = data;
        this.goToStudentList();
      }
    )
  }

  goToStudentList(){
    this.router.navigate(['students']);
  }
}
