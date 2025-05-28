import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseURL = "http://localhost:8081/students";
  constructor(private httpClient : HttpClient) { }

  getStudentList(): Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseURL}`);
  }

  createStudent(student: Student): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,student);
  }

  getStudentById(studentId: String): Observable<Student>{
    return this.httpClient.get<Student>(`${this.baseURL}/${studentId}`);
  }

  updateStudent(studentId:string, student:Student):Observable<Student>{
    return this.httpClient.put<Student>(`${this.baseURL}/${studentId}`,student);
  }

  deleteStudentById(studentId: string): Observable<Object>{
    return this.httpClient.delete<Student>(`${this.baseURL}/${studentId}`);
  }
}
